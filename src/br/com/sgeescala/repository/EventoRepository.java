package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgeescala.model.Evento;
import br.unitins.frame.repository.Repository;

public class EventoRepository extends Repository<Evento>{

	
	public EventoRepository(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Evento> getModelClass() {
		// TODO Auto-generated method stub
		return Evento.class;
	}

	@SuppressWarnings("uncheckd")
	public List<Evento> buscarTodos() {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e From Evento e Order by e.id Desc");
		List<Evento> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Evento>();

		return lista;

	}
	
	public List<Evento> buscarEventos(String nome) {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e From Evento e WHERE pt.nome LIKE ?1 ORDER BY pt.nome");
		query.setParameter(1, "%" + nome + "%");
		List<Evento>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Evento>();

		return lista;

	}
}
