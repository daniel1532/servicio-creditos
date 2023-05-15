package com.gruposa.springboot.app.plazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposa.springboot.app.plazo.models.Credito;
import com.gruposa.springboot.app.plazo.models.Plazo;
import com.gruposa.springboot.app.plazo.models.Producto;
import com.gruposa.springboot.app.plazo.models.service.ICreditoService;

@RestController
@RequestMapping("/credito")
public class CreditoController {

	@Autowired
	private ICreditoService creditoService;

	@GetMapping("/producto/{nombre}")
	public ResponseEntity<List<Producto>> producto(@PathVariable String nombre) {
		List<Producto> producto = creditoService.getProductName(nombre);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}

	@GetMapping("/plazo")
	public ResponseEntity<List<Plazo>> plazo() {
		List<Plazo> plazoDB = creditoService.listPlazo();
		if (plazoDB.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(plazoDB);
	}

	@GetMapping("/plazo/{plazo}/producto/{id}")
	public ResponseEntity<Credito> credito(@PathVariable Integer plazo, @PathVariable Long id) {
		Credito credito = creditoService.listCotizacion(plazo, id);
		if (credito == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(credito);
	}
}
