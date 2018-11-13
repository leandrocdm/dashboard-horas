package br.com.centauro.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.centauro.jpa.dao.FuncionarioDAO;
import br.com.centauro.jpa.model.Funcionario;

@Repository
public class FuncionarioDAOImpl extends GenericDAOImpl<Funcionario, Integer> implements FuncionarioDAO{
}
