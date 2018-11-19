package br.com.centauro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.centauro.jpa.dao.BancoDeHorasDAO;


@Controller
@RequestMapping("bancodehoras")
public class BancoDeHorasController {
	
	@Autowired
	private BancoDeHorasDAO bancoDAO;
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("bancodehoras/listagem")
				.addObject("bancodehoras", bancoDAO.listar());
	}		
}