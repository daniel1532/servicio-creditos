package com.gruposa.springboot.app.creditos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gruposa.springboot.app.creditos.models.dao.IPlazoDao;
import com.gruposa.springboot.app.creditos.models.entity.Plazo;

@Service
public class PlazoServiceImpl implements IPlazoService {

	@Autowired
	private IPlazoDao plazoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Plazo> findAll() {
		return (List<Plazo>) plazoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Plazo> findByPlazo(Integer plazo) {
		return plazoDao.findByPlazo(plazo);
	}

	@Override
	@Transactional(readOnly = true)
	public Plazo findById(Long id) {
		return plazoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Plazo save(Plazo plazo) {
		return plazoDao.save(plazo);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		plazoDao.deleteById(id);

	}

}
