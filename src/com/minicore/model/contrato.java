package com.minicore.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contratos")

public class contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContrato;
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "idCliente",insertable=false,updatable=false)
    @ManyToOne
    private cliente cliente;
	
	
	@Column(name = "id_cliente")
	private Integer idcliente;
	
	
	@Column(name = "montos")
	private Float montos;
	
	
	
	
	
	public contrato() {
		super();
	}


	public contrato(Integer idContrato, com.minicore.model.cliente cliente, Integer idcliente, Float montos,
			String descripcion, Date fecha) {
		super();
		this.idContrato = idContrato;
		this.cliente = cliente;
		this.idcliente = idcliente;
		this.montos = montos;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}


	public Integer getIdContrato() {
		return idContrato;
	}


	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}


	public cliente getCliente() {
		return cliente;
	}


	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}


	public Integer getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}


	public Float getMontos() {
		return montos;
	}


	public void setMontos(Float montos) {
		this.montos = montos;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(name = "descripcion")
	private String descripcion;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha")
	private Date fecha;
	

}
