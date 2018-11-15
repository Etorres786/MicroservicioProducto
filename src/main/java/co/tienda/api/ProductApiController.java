package co.tienda.api;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	public ResponseEntity<?> addProducto(
			@ApiParam(value = "Producto para agregar", required = true) @Valid @RequestBody Producto producto) {
		
		System.out.println("ENTRE POR ACA AL CONTROLLE");
		producto.setName(producto.getName());
		producto.setPrecio(producto.getPrecio());
		Producto personaSave = productoRepository.save(producto);
		
		return new ResponseEntity<Producto>(personaSave, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> findAll() {
		System.out.println();
		JsonApiBodyResponseSuccess response = new JsonApiBodyResponseSuccess();
		List<Producto> lista = (List<Producto>) productoRepository.findAll();
		response.setData(lista);

		return new ResponseEntity<JsonApiBodyResponseSuccess>(response, HttpStatus.OK);
	}



}
