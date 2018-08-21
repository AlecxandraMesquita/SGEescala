package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgeescala.model.Turma;
import br.unitins.frame.repository.Repository;

public class TurmaRepository extends Repository<Turma>{

	
	public TurmaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Turma> getModelClass() {
		return Turma.class;
	}

	@SuppressWarnings("uncheckd")
	public List<Turma> buscarTodos() {
		
		Query query = geEntityManager().createQuery("Select e From Turma e Order by e.id Desc");
		List<Turma> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Turma>();

		return lista;

	}
	
	public List<Turma> buscarTurmas(String nome) {
		
		Query query = geEntityManager().createQuery("Select eq From Turma eq WHERE eq.nome LIKE ?1 ORDER BY eq.nome");
		query.setParameter(1, "%" + nome + "%");
		List<Turma>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Turma>();

		return lista;

	}
}
