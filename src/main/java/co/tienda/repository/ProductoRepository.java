package co.tienda.repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import co.tienda.model.Producto;

@EnableScan
public interface ProductoRepository extends CrudRepository<Producto, String>{
	
	
}
