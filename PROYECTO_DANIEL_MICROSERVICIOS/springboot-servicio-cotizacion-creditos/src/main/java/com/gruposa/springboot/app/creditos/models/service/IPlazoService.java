package com.gruposa.springboot.app.creditos.models.service;

import java.util.List;

import com.gruposa.springboot.app.creditos.models.entity.Plazo;

public interface IPlazoService {
	
	public List<Plazo> findAll();

	public List<Plazo> findByPlazo(Integer plazo);

	public Plazo findById(Long id);

	public Plazo save(Plazo plazo);

	public void deleteById(Long id);
}
