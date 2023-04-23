package com.minicore.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minicore.model.cliente;
import com.minicore.model.contrato;
import com.minicore.repositry.ClienteRepository;
import com.minicore.repositry.ContratoRepository;

@Controller
@RequestMapping("/reporte") 

public class reporteController {
	

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@GetMapping
	public String Listar2(Model model){
		return "home";
	}
	
	
	
	@GetMapping("/Listar")
	public String Listar(Model model, List<List<String>> resultados ){
		model.addAttribute("core", resultados);
		return "home";
	}
	
	
	@RequestMapping(value = "/resultado", method = { RequestMethod.POST, RequestMethod.GET })
	public String minicore(Model model,  Date fechaFin, Date fechaInicio){
		List<List<String>> resultados = new ArrayList<>();
		
		List<Date> fechas = new ArrayList<>();
		fechas.add(fechaInicio);
		Calendar c = Calendar.getInstance();
		Calendar h = Calendar.getInstance();
		c.setTime(fechaInicio);
		h.setTime(fechaFin);
		Date fechaTemp;
		fechaTemp = new java.sql.Date(c.getTimeInMillis());
		System.out.println(fechaTemp);
		while(c.before(h)) {
			c.add(Calendar.DATE, 1);
			fechaTemp = new java.sql.Date(c.getTimeInMillis());
			fechas.add(fechaTemp);
		}
		float totalGeneral=0;
		for (cliente temp : clienteRepository.findAll()) {
			List<String> clientes = new ArrayList<String>();
			clientes.add(temp.getNombre());
			float total = 0;			
			for (contrato con : contratoRepository.findAll()) {
				for(Date f : fechas) {
					if (con.getCliente().getIdCliente() == temp.getIdCliente() && f.compareTo(con.getFecha()) == 0) {
						total = total + con.getMontos();
						totalGeneral= totalGeneral+total;						
					}
				}				
			}
			clientes.add(Float.toString(total));	
			resultados.add(clientes);
		}
		List<String> montos = new ArrayList<String>();
		montos.add("Total");
		montos.add(Float.toString(totalGeneral));
		resultados.add(montos);
		return Listar(model,resultados);
	}
	
	
	
	
	
	


}
