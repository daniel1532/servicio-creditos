package com.gruposa.springboot.app.creditos.controllers;

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

import com.gruposa.springboot.app.creditos.models.entity.Producto;
import com.gruposa.springboot.app.creditos.models.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private IProductoService productoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listProduct() {
		List<Producto> producto = productoService.findAll();
		if (producto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(producto);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Producto> getProduct(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}

	@GetMapping("/{nombre}")
	public ResponseEntity<List<Producto>> getProductName(@PathVariable String nombre) {
		List<Producto> producto = productoService.findByNombre(nombre);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}

	@PostMapping
	public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
		Producto productoCrear = productoService.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoCrear);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProduct(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDB = productoService.findById(id);
		if (productoDB == null) {
			return ResponseEntity.notFound().build();
		}
		productoDB.setNombre(producto.getNombre());
		productoDB.setDescripcion(producto.getDescripcion());
		productoDB.setPrecio(producto.getPrecio());
		productoService.save(productoDB);
		return ResponseEntity.ok(productoDB);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
		Producto productoDB = productoService.findById(id);
		if (productoDB == null) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
