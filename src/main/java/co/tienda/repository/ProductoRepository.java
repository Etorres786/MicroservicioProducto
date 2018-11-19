package co.tienda.repository;


import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import co.tienda.model.Producto;

@EnableScan
public interface ProductoRepository extends CrudRepository<Producto, String>{
	
	public List<Producto> findByCode(int codigo);
	
}
