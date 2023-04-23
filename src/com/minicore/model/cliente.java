package com.minicore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")

public class cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idCliente;
	private String nombre;
	
	
	
	
	
	public cliente() {
		super();
	}
	public cliente(Integer idCliente, String nombre) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "cliente [idCliente=" + idCliente + ", nombre=" + nombre + "]";
	}
	

}
