package com.gruposa.springboot.app.creditos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gruposa.springboot.app.creditos.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

	public List<Producto> findByNombreLikeIgnoreCase(String nombre);

}
