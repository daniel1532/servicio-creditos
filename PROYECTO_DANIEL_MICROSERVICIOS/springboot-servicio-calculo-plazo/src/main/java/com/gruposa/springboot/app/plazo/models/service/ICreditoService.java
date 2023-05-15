package com.gruposa.springboot.app.plazo.models.service;

import java.util.List;

import com.gruposa.springboot.app.plazo.models.Credito;
import com.gruposa.springboot.app.plazo.models.Plazo;
import com.gruposa.springboot.app.plazo.models.Producto;

public interface ICreditoService {

	public List<Producto> getProductName(String nombre);

	public List<Plazo> listPlazo();

	public Credito listCotizacion(Integer plazo, Long id);

}
