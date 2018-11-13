package br.com.centauro.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.centauro.jpa.dao.GenericDAO;
import br.com.centauro.jpa.exception.KeyNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K id) throws KeyNotFoundException {
		T entidade = pesquisar(id);
		if (entidade == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public List<T> listar() {
		return em.createQuery("from "+ clazz.getName(), clazz).getResultList();
	}
}