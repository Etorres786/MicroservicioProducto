package co.tienda.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.tienda.model.ErrorDetail;
import co.tienda.model.JsonApiBodyResponseSuccess;
import co.tienda.model.Producto;
import co.tienda.repository.ProductoRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-13T11:30:22.608-05:00")

@Controller
public class ProductApiController implements ProductApi {

	private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ProductoRepository productoRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Producto> addProducto(

			@ApiParam(value = "Producto para agregar", required = true) @Valid @RequestBody Producto producto) {
		
		String accept = request.getHeader("Accept");
		ErrorDetail error = new ErrorDetail();
		
		if (accept != null && accept.contains("application/json")) {
			
			productoRepository.save(producto);
			
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
			
		}else {
			
			error.setCode("204");
			error.detail("Ya existe un producto con este codigo: " + producto.getCode());
			error.setStatus("No content");
			error.setTitle("Error");
			error.setSource("/addProducto");
//			return returnError(error,HttpStatus.METHOD_FAILURE);
			
		}
		return null;
	}

	@Override
	public ResponseEntity<?> findAll() {

		JsonApiBodyResponseSuccess response = new JsonApiBodyResponseSuccess();
		List<Producto> lista = (List<Producto>) productoRepository.findAll();
		response.setData(lista);

		return new ResponseEntity<JsonApiBodyResponseSuccess>(response, HttpStatus.OK);
	}
	
	private ResponseEntity<?> returnError(ErrorDetail oError, HttpStatus status){
		List listaErrores = new ArrayList();
		listaErrores.add(oError);
		return new ResponseEntity<List>(listaErrores, status);
	}

}
