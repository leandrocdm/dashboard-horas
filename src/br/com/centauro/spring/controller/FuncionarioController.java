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

import br.com.centauro.jpa.dao.FuncionarioDAO;
import br.com.centauro.jpa.model.Funcionario;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioDAO dao;

	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {	
		return new ModelAndView("funcionario/form");
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Funcionario funcionario, BindingResult b, RedirectAttributes r) {
		if (b.hasErrors()) {
			return cadastrar(funcionario);
		}else {
			dao.inserir(funcionario);
			r.addFlashAttribute("msg", "Funcionario "+ funcionario.getNome() + " registrado!");
			return new ModelAndView("redirect:/funcionario/cadastrar");
		}
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("funcionario/listagem")
				.addObject("funcionarios", dao.listar());
	}
	
	@Transactional
	@PostMapping("excluir")
	public String excluir(int id, RedirectAttributes redirectAttribute) {		
		try {
			dao.remover(id);
			redirectAttribute.addFlashAttribute("msgSucesso", "Funcionario excluído com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar excluir o funcionario!");
		}	
		return "redirect:/funcionario/listar";
	}
}
