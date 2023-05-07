package com.mrmachine.app.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.mrmachine.app.persistence.entity.Producto;

public interface IProductoCrudRepository extends CrudRepository<Producto, Long>{
	
	
	//public List<Producto> findByIdCategoriaOrderByNombre(Long idCategoria);
	
	@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
	public List<Producto> encontrarProdByCategoria(Long idCategoria);
	
	
}
