package com.gruposa.springboot.app.plazo.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gruposa.springboot.app.plazo.models.Plazo;
import com.gruposa.springboot.app.plazo.models.Producto;

@FeignClient(name = "cotizacion-creditos")
public interface ProductoClienteRest {

	@GetMapping("/producto/listar")
	public List<Producto> listProduct();
	
	@GetMapping("/producto/id/{id}")
	public Producto getProduct(@PathVariable Long id);

	@GetMapping("/producto/{nombre}")
	public List<Producto> getProductName(@PathVariable String nombre);

	// ==========================================================

	@GetMapping("/plazo/listar")
	public List<Plazo> listPlazo();

	@GetMapping("/plazo/{tipPlazo}")
	public List<Plazo> listPlazo(@PathVariable Integer tipPlazo);
}
