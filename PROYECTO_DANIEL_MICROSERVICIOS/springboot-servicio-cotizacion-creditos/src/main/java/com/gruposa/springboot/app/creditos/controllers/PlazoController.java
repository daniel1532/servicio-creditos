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

import com.gruposa.springboot.app.creditos.models.entity.Plazo;
import com.gruposa.springboot.app.creditos.models.service.IPlazoService;



@RestController
@RequestMapping("/plazo")
public class PlazoController {
	@Autowired
	private IPlazoService plazoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Plazo>> listPlazo() {
		List<Plazo> plazo = plazoService.findAll();
		if (plazo.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(plazo);
	}

	@GetMapping("/{tipPlazo}")
	public ResponseEntity<List<Plazo>> listPlazo(@PathVariable Integer tipPlazo) {
		List<Plazo> plazoDB = plazoService.findByPlazo(tipPlazo);
		if (plazoDB.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(plazoDB);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Plazo> getProduct(@PathVariable Long id) {
		Plazo plazo = plazoService.findById(id);
		if (plazo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(plazo);
	}

	@PostMapping
	public ResponseEntity<Plazo> createPlazo(@RequestBody Plazo plazo) {
		Plazo plazoCrear = plazoService.save(plazo);
		return ResponseEntity.status(HttpStatus.CREATED).body(plazoCrear);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Plazo> updatePlazo(@RequestBody Plazo plazo, @PathVariable Long id) {
		Plazo plazoDB = plazoService.findById(id);
		if (plazoDB == null) {
			return ResponseEntity.notFound().build();
		}
		plazoDB.setPlazo(plazo.getPlazo());
		plazoDB.setTipo(plazo.getTipo());
		plazoDB.setDescripcion(plazo.getDescripcion());
		plazoDB.setTasa(plazo.getTasa());
		plazoService.save(plazoDB);
		return ResponseEntity.ok(plazoDB);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Plazo> deletePlazo(@PathVariable Long id) {
		Plazo plazoDB = plazoService.findById(id);
		if (plazoDB == null) {
			return ResponseEntity.notFound().build();
		}
		plazoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
