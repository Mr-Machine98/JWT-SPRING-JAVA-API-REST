package com.mrmachine.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrmachine.app.domain.service.PurchaseService;
import com.mrmachine.app.persistence.entity.Compra;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Compra>> getAll(){
		List<Compra> purchases = purchaseService.getAll();
		return purchases.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :  new ResponseEntity<>( purchases , HttpStatus.OK);
	}
	
	@GetMapping("/purchase/client/{id}")
	public ResponseEntity<List<Compra>> getByClient(@PathVariable(name = "id") String idClient){
		List<Compra> purchasesByClient = purchaseService.getByClient(idClient);
		return purchasesByClient.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) :  new ResponseEntity<>( purchasesByClient , HttpStatus.OK);
	}
	//This Method is BAD
//	@PostMapping("/save")
//	public ResponseEntity<Compra> save(@RequestBody Compra c) {
//		return new ResponseEntity<Compra>(purchaseService.save(c), HttpStatus.OK);
//	}
	
}
