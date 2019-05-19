package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.sgeescala.controller.VoluntarioController;
import br.com.sgeescala.model.Escala;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.application.ApplicationException;
import br.unitins.frame.application.Config;
import br.unitins.frame.application.Util;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.repository.Repository;

public class EscalaRepository extends Repository<Escala> {

	public EscalaRepository(EntityManager em) {
		super(em);
	}
	@Override
	protected Class<Escala> getModelClass() {
		return Escala.class;
	}
	
	@SuppressWarnings("uncheckd")
	public List<Escala> buscarTodosV() {
		
		Query query = geEntityManager().createQuery("Select e From Escala e Order by e.voluntario.pessoa.nome Desc");
		List<Escala> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Escala>();

		return lista;

	}
	public Escala buscarVoluntarios(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Voluntario f WHERE f.pessoa.id = ?1 ");
		query.setParameter(1, id);
		Escala turma = null;
		try {
			turma = (Escala) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}
	
		return turma;
	}
	@SuppressWarnings("uncheckd")
	public List<Escala> buscarTodos() {
		
		Query query = geEntityManager().createQuery("Select e From Escala e Order by e.id Desc");
		List<Escala> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Escala>();

		return lista;

	}
	
	public Escala buscarEscalaPorVoluntarioAndEvento(int idVoluntario, int idEvento) {
		
		Query query = geEntityManager().createQuery("Select e From Escala e WHERE e.voluntario.id = :idVoluntario and e.evento.id = :idEvento ");
		query.setParameter("idVoluntario",idVoluntario);
		query.setParameter("idEvento",idEvento);
		Escala escala = null;
		try {
			escala = (Escala) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}
		return escala;

	}

	public List<Escala>  buscarEscalaCor(Integer id) {

		Query query = geEntityManager().createQuery("SELECT es FROM Escala es WHERE es.corE.id = ?1 ORDER BY es.voluntario.pessoa.nome");
		query.setParameter(1, id);
		List<Escala> lista = query.getResultList();
		if (lista == null)
			lista = new ArrayList<Escala>();
		
		return lista;
	}
}
