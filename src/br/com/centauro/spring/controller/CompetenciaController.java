package br.com.centauro.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.centauro.jpa.dao.CompetenciaDAO;
import br.com.centauro.jpa.model.Competencia;

@Controller
@RequestMapping("competencia")
public class CompetenciaController {
	
	@Autowired
	private CompetenciaDAO dao;
	
	private ModelAndView model;

	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Competencia competencia) {	
		return new ModelAndView("competencia/cadastrar");
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Competencia competencia, BindingResult b, RedirectAttributes r) {
		if (b.hasErrors()) {
			r.addFlashAttribute("msgErro", "Erro ao fazer o cadastro da competencia!");
			return cadastrar(competencia);
		}else {
			dao.inserir(competencia);
			r.addFlashAttribute("msgSucesso", competencia.getMes() + " " + competencia.getAno() + " foi cadastrada com sucesso!");
			return new ModelAndView("redirect:/competencia/cadastrar");
		}
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("competencia/listagem")
				.addObject("competencias", dao.listar());
	}
		
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		model = null;	
		try {
			model = new ModelAndView("competencia/editar");
			model.addObject("competencia",dao.pesquisar(id));
			return model;
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar abrir a pagina de edicao.");
			model = new ModelAndView("redirect:/competencia/listar");
			return model;
		}		
	}

	@Transactional
	@PostMapping("editar")
	public String editar(Competencia competencia, RedirectAttributes redirectAttribute) {	
		try {
			dao.atualizar(competencia);
			redirectAttribute.addFlashAttribute("msgSucesso", "As horas da competencia: "
												+competencia.getMes() + " " + competencia.getAno() + 
												" foram alteradas com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar editar a competencia!");
		}	
		return "redirect:/competencia/listar";
	}	
}