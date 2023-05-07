package com.mrmachine.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrmachine.app.persistence.crud.IProductoCrudRepository;
import com.mrmachine.app.persistence.entity.Producto;

@Repository
public class ProductoRepository {
	
	@Autowired
	private IProductoCrudRepository prodCrudRepo;
	
	
//	@Override
//	public List<Product> getAll(){
//		List<Producto> productos = (List<Producto>) prodCrudRepo.findAll();
//		
//		
//		return  mapper.toProducts(productos);
//	}
	
	public List<Producto> getAll(){
		return  (List<Producto>) prodCrudRepo.findAll();
	}
	
	public List<Producto> findByIdCategoria(Long idCategoria){
		return prodCrudRepo.encontrarProdByCategoria(idCategoria);
	}
	
	
//	@Override
//	public Optional<List<Product>> getByCategory(int categoryId) {
//		List<Producto> productos = prodCrudRepo.encontrarProdByCategoria(Long.parseLong(String.valueOf(categoryId)));
//		return Optional.of(mapper.toProducts(productos));
//	}
//
	
	public Optional<Producto> getProduct(Long productId) {
		return prodCrudRepo.findById(Long.parseLong(String.valueOf(productId)));
	}
//
	public Producto save(Producto producto) {
		return prodCrudRepo.save(producto);
	}
	
	
	public void delete(Long idProducto) {
		prodCrudRepo.deleteById(idProducto);
	}
//	
}