package com.gruposa.springboot.app.plazo.models.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.gruposa.springboot.app.plazo.cliente.ProductoClienteRest;
import com.gruposa.springboot.app.plazo.models.Credito;
import com.gruposa.springboot.app.plazo.models.Plazo;
import com.gruposa.springboot.app.plazo.models.Producto;

@Service
public class CreditoServiceFeign implements ICreditoService {

	private static final Logger log = LoggerFactory.getLogger(CreditoServiceFeign.class);

	@Autowired
	private ProductoClienteRest productoFeign;

	@Override
	public List<Producto> getProductName(String nombre) {
		try {
			return productoFeign.getProductName(nombre);
		} catch (Exception e) {
			log.info("Excepcion en consulta de producto");
			String error = "Excepcion en consulta de producto";
			throw new NotFoundException(error);
		}

	}

	@Override
	public List<Plazo> listPlazo() {
		try {
			return productoFeign.listPlazo();
		} catch (Exception e) {
			log.info("Excepcion en consulta de lista de plazos");
			String error = "Excepcion en consulta de lista de plazos";
			throw new NotFoundException(error);
		}

	}

	@Override
	public Credito listCotizacion(Integer plazo, Long id) {
		Credito credito;
		try {
			Producto producto = productoFeign.getProduct(id);
			List<Plazo> plazos = productoFeign.listPlazo(plazo);
			if (producto != null && !plazos.isEmpty()) {
				credito = new Credito(producto, plazos);
				credito.cotizacionCredito();
				return credito;
			} else {
				return credito = null;
			}
		} catch (Exception e) {
			log.info("Excepcion en cotizacion de credito");
			String error = "Excepcion en cotizacion de credito";
			throw new NotFoundException(error);
		}

	}

}
