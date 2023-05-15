package com.gruposa.springboot.app.plazo.models;

import java.util.Date;

public class Plazo {
	private Long id;
	private Integer plazo;
	private Integer tipo;
	private String descripcion;
	private Double tasa;
	private Date createAt;

	private Double toal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Double getToal() {
		return toal;
	}

	public void setToal(Double toal) {
		this.toal = toal;
	}

}
