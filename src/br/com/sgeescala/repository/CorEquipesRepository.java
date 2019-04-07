package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.model.Escala;
import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.repository.Repository;

public class CorEquipesRepository extends Repository<CorEquipes> {

	public CorEquipesRepository(EntityManager em) {
		super(em);
	}
	@Override
	protected Class<CorEquipes> getModelClass() {
		return CorEquipes.class;
	}
	
	@SuppressWarnings("uncheckd")
	public List<CorEquipes> buscarTodos() {
		
		Query query = geEntityManager().createQuery("Select ce From CorEquipes ce Order by ce.id Desc");
		List<CorEquipes> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<CorEquipes>();

		return lista;
	}
	
	public List<CorEquipes> bucarCorEquipes(String nome) {
		Query query = geEntityManager().createQuery("SELECT ce FROM CorEquipes ce WHERE ce.nome LIKE ?1 ORDER BY ce.nome");
		query.setParameter(2, "%" + nome + "%");
		List<CorEquipes> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<CorEquipes>();
		
		return lista;
	}
}
