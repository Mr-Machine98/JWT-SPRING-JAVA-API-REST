package com.mrmachine.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrmachine.app.domain.service.ProductService;
import com.mrmachine.app.persistence.entity.Producto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	@ApiOperation("Get all supermarket products.")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Producto>> getAll() {
		return new ResponseEntity<List<Producto>>(productService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	@ApiOperation("Search product by his ID.")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Product not found.") })
	public ResponseEntity<List<Producto>> findByIdCategoriaOrderByNombre(
			@ApiParam(value = "The id of the product", required = true, example = "1") @PathVariable("id") Long idCategoria) {
		List<Producto> prodByCategory = productService.findByIdCategoria(idCategoria);
		return prodByCategory.isEmpty() ? new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Producto>>(prodByCategory, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Producto> getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Producto p) {
		return p.getIdProducto() == null ? new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)
				: new ResponseEntity<Object>(productService.save(p), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Producto> save(@RequestBody Producto p) {
		return new ResponseEntity<Producto>(productService.save(p), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return productService.delete(id) ? new ResponseEntity<Object>(HttpStatus.OK)
				: new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
}
