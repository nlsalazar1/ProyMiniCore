package com.minicore.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minicore.repositry.ClienteRepository;


@Controller
@RequestMapping("/clientes") 
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("clientes", clienteRepository.findAll());

		return "home";
	}

}
