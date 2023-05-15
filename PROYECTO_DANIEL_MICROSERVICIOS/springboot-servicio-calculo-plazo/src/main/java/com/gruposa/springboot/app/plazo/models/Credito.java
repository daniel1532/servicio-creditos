package com.gruposa.springboot.app.plazo.models;

import java.util.List;

public class Credito {

	private Producto producto;

	private List<Plazo> plazo;

	public Credito() {
	}

	public Credito(Producto producto, List<Plazo> plazo) {
		this.producto = producto;
		this.plazo = plazo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Plazo> getPlazo() {
		return plazo;
	}

	public void setPlazo(List<Plazo> plazo) {
		this.plazo = plazo;
	}

	public void cotizacionCredito() {
		if (plazo != null) {
			for (Plazo p : plazo) {
				p.setToal((producto.getPrecio() * p.getTasa()) + producto.getPrecio() / p.getTasa());
			}
		}

	}

}
