package br.com.centauro.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.centauro.jpa.dao.BancoDeHorasDAO;
import br.com.centauro.jpa.model.BancoDeHoras;

@Controller
@RequestMapping("bancodehoras")
public class BancoDeHorasController {
	
	@Autowired
	private BancoDeHorasDAO bancoDAO;
		
	@GetMapping("opcoes")
	public ModelAndView opcoes() {
		return new ModelAndView("bancodehoras/opcoes");
	}
	
   	@GetMapping("cadastrar")
	public ModelAndView cadastrar(BancoDeHoras banco) {	
		return new ModelAndView("bancodehoras/cadastrar");
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid BancoDeHoras banco, BindingResult b, RedirectAttributes r) {
		if (b.hasErrors()) {
			r.addFlashAttribute("msgErro", "Erro ao fazer o cadastro do Banco de Horas!");
			return cadastrar(banco);
		}else {
			bancoDAO.inserir(banco);
			r.addFlashAttribute("msgSucesso", "Banco foi cadastrado com sucesso!");
			return new ModelAndView("redirect:/bancodehoras/cadastrar");
		}
	}		
}