package com.mrmachine.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrmachine.app.persistence.ProductoRepository;
import com.mrmachine.app.persistence.entity.Producto;

@Service
public class ProductService {

//	@Autowired
//	private IProductRepository productRepository;
//	
	@Autowired
	private ProductoRepository pr;

	public List<Producto> getAll() {
		return pr.getAll();
	}

	public List<Producto> findByIdCategoria(Long idCategoria) {
		return pr.findByIdCategoria(idCategoria);
	}

	public Optional<Producto> getProduct(Long id) {
		return pr.getProduct(id);
	}

//	public Optional<List<Product>> getByCategory(int categoryId) {
//		return productRepository.getByCategory(categoryId);
//	}
//
	public Producto save(Producto producto) {
		return pr.save(producto);
	}

//
	public boolean delete(Long id) {
		return getProduct(id).map(p -> {
			pr.delete(id);
			return true;
		}).orElse(false);
	}
}
