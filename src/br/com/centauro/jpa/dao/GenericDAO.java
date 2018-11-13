package br.com.centauro.jpa.dao;

import java.util.List;

import br.com.centauro.jpa.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	List<T> listar();
	
	void atualizar(T entidade);
	
	void remover(K id) throws KeyNotFoundException;
	
	T pesquisar(K id);
	
}



