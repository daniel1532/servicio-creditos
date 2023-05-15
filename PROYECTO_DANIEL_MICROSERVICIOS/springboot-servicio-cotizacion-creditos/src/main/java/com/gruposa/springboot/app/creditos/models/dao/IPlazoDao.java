package com.gruposa.springboot.app.creditos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gruposa.springboot.app.creditos.models.entity.Plazo;

public interface IPlazoDao extends CrudRepository<Plazo, Long> {

	public List<Plazo> findByPlazo(Integer plazo);

}
