package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import br.com.sgeescala.model.Evento;
import br.com.sgeescala.model.Voluntario;
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
	
	public List<Evento> buscarEventos(Date dataInicio, Date dataFim) {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e From Evento e  WHERE e.data between :inicioDate and :fimDate");
		query.setParameter("inicioDate", dataInicio, TemporalType.DATE);
		query.setParameter("fimDate",  dataFim, TemporalType.DATE);
		List<Evento>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Evento>();

		return lista;

	}
	public Evento buscarEventoData(Date data) {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e From Evento e  WHERE e.data = :data");
		query.setParameter("data", data, TemporalType.DATE);
		Evento evento = (Evento) query.getSingleResult();

		
		return evento;

	}

	public List<Evento> buscarEventosPorVoluntario(Voluntario voluntario) {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e.evento From Escala e WHERE e.voluntario.id = ?1 ORDER BY e.evento.nome");
		query.setParameter(1, voluntario.getId());
		List<Evento>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Evento>();

		return lista;

	}
	public List<Evento> buscarEventosPorVoluntarioData(Voluntario voluntario, Date data) {
		// TODO Auto-generated method stub
		Query query = geEntityManager().createQuery("Select e.evento From Escala e WHERE e.voluntario.id = :idVoluntario AND e.evento.data = :data ");
//		query.setParameter(1, voluntario.getId());
		query.setParameter("idVoluntario", voluntario.getId());
		query.setParameter("data", data, TemporalType.DATE);
		List<Evento>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Evento>();

		return lista;

	}
}
