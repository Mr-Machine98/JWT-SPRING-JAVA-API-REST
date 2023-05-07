package com.mrmachine.app.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrmachine.app.persistence.crud.IPurchaseCrudRepository;
import com.mrmachine.app.persistence.entity.Compra;

@Repository
public class PurchaseRepository {
	
	@Autowired
	private IPurchaseCrudRepository pCrudRepo;
	
	public List<Compra> getAll(){
		return (List<Compra>) pCrudRepo.findAll();
	}
	
	public List<Compra> getByClient(String idClient){
		return pCrudRepo.getByClient(idClient);
	}
	
	public Compra save(Compra c) {
		return pCrudRepo.save(c);
	}
}
