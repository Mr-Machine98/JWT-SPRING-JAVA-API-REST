package com.mrmachine.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmachine.app.persistence.PurchaseRepository;
import com.mrmachine.app.persistence.entity.Compra;


@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository pr;
	
	public List<Compra> getAll(){
		return pr.getAll();
	}
	
	public List<Compra> getByClient(String idClient){
		return pr.getByClient(idClient);
	}
	
	public Compra save(Compra c) {
		return pr.save(c);
	}
	
}
