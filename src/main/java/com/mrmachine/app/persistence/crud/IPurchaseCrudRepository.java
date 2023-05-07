package com.mrmachine.app.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mrmachine.app.persistence.entity.Compra;

public interface IPurchaseCrudRepository extends CrudRepository<Compra, Long>{
	
	@Query(value = "SELECT c from Compra c WHERE c.idCliente = :id")
	public List<Compra> getByClient(@Param("id") String idCliente);
	
}
