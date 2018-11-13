package br.com.centauro.spring.controller;

import java.util.List;

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
import br.com.centauro.jpa.dao.FuncionarioDAO;
import br.com.centauro.jpa.model.Area;
import br.com.centauro.jpa.model.Funcionario;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioDAO funcDAO;
	
	@Autowired
	private AreaDAO areaDAO;
	
	private ModelAndView model;

	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		List<Area> lista = areaDAO.listar();
		return new ModelAndView("funcionario/cadastrar").addObject("areas", lista);
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Funcionario funcionario, BindingResult b, RedirectAttributes r) {
		if (b.hasErrors()) {
			r.addFlashAttribute("msgErro", "Erro ao fazer o cadastro!");
			return cadastrar(funcionario);
		}else {
			funcDAO.inserir(funcionario);
			r.addFlashAttribute("msgSucesso", funcionario.getNome() + " cadastrado com sucesso!");
			return new ModelAndView("redirect:/funcionario/cadastrar");
		}
	}

	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("funcionario/listagem")
				.addObject("funcionarios", funcDAO.listar());
	}
	
	@Transactional
	@PostMapping("excluir")
	public String excluir(int id, RedirectAttributes redirectAttribute) {		
		try {
			funcDAO.remover(id);
			redirectAttribute.addFlashAttribute("msgSucesso", "Funcionario excluido com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar excluir esse funcionario!");
		}	
		return "redirect:/funcionario/listar";
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id) {
		model = null;	
		List<Area> lista = areaDAO.listar();
		try {
			model = new ModelAndView("funcionario/editar");
			model.addObject("areas", lista);
			model.addObject("funcionario",funcDAO.pesquisar(id));
			return model;
		} catch (Exception e) {
			model.addObject("msgErro", "Erro ao tentar abrir a pagina de edicao.");
			model = new ModelAndView("redirect:/funcionario/listar");
			return model;
		}		
	}

	@Transactional
	@PostMapping("editar")
	public String editar(Funcionario funcionario, RedirectAttributes redirectAttribute) {	
		try {
			funcDAO.atualizar(funcionario);
			redirectAttribute.addFlashAttribute("msgSucesso", funcionario.getNome() + " editado com sucesso!");
		} catch (Exception e) {
			redirectAttribute.addFlashAttribute("msgErro", "Erro ao tentar editar o funcionario!");
		}	
		return "redirect:/funcionario/listar";
	}	
}