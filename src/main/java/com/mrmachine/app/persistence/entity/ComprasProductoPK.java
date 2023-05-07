package com.mrmachine.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ComprasProductoPK implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "id_compra")
	private Long idCompra;
	
	@Column(name = "id_producto")
	private Long idProducto;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
}
