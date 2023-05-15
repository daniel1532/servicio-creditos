package com.gruposa.springboot.app.creditos.models.service;

import java.util.List;

import com.gruposa.springboot.app.creditos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();

	public Producto findById(Long id);

	public List<Producto> findByNombre(String nombre);

	public Producto save(Producto producto);

	public void deleteById(Long id);
}
