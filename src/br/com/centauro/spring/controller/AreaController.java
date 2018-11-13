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

import br.com.centauro.jpa.dao.AreaDAO;
import br.com.centauro.jpa.model.Area;

@Controller
@RequestMapping("area")
public class AreaController {
	
	@Autowired
	private AreaDAO dao;
	
	private ModelAndView model;

	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Area Area) {	
		return new ModelAndView("area/cadastrar");
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Area area, BindingResult b, RedirectAttributes r) {
		if (b.hasErrors()) {
			r.addFlashAttribute("msgErro", "Erro ao fazer o cadastro da area!");
			return cadastrar(area);
		}else {
			dao.inserir(area);
			r.addFlashAttribute("msgSucesso", area.getNome() + " cadastrada com sucesso!");
			return new ModelAndView("redirect:/area/cadastrar");
		}
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("area/listagem")
				.addObject("areas", dao.listar());
	}
	
	@Transactional
	@PostMapping("excluir")
	public String excluir(int id, RedirectAttributes redirectAttribute) {		
		try {
			dao.remover(id);
			redirectAttribute.addFlashAttribute("msgSucesso", "Area excluida com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar excluir essa area!");
		}	
		return "redirect:/area/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		model = null;	
		try {
			model = new ModelAndView("area/editar");
			model.addObject("area",dao.pesquisar(id));
			return model;
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar abrir a pagina de edicao.");
			model = new ModelAndView("redirect:/area/listar");
			return model;
		}		
	}

	@Transactional
	@PostMapping("editar")
	public String editar(Area area, RedirectAttributes redirectAttribute) {	
		try {
			dao.atualizar(area);
			redirectAttribute.addFlashAttribute("msgSucesso", area.getNome() + " editada com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar editar o Area!");
		}	
		return "redirect:/area/listar";
	}	
}