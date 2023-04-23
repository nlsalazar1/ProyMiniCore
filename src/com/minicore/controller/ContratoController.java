package com.minicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minicore.repositry.ContratoRepository;

@Controller
@RequestMapping("/contratos") 
public class ContratoController {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("contratos", contratoRepository.findAll());

		return "home";
	}

}
