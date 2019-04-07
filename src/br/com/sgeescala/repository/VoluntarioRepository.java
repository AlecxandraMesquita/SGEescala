package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.application.Session;
import br.unitins.frame.application.Util;
import br.unitins.frame.repository.Repository;

public class VoluntarioRepository extends Repository<Voluntario>{

	public VoluntarioRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Voluntario> getModelClass() {
		return Voluntario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Voluntario> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select v From Voluntario v Order by v.id Desc");
		List<Voluntario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Voluntario>();
		
		return lista;
	}
	
	public List<Voluntario> bucarVoluntarios(String nome) {
		Query query = geEntityManager().createQuery("SELECT f FROM Voluntario f WHERE f.pessoa.nome LIKE ?1 ORDER BY f.pessoa.nome");
		query.setParameter(1, "%"+nome+"%");
		List<Voluntario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Voluntario>();
		
		return lista;
	}
	
	public Voluntario bucarPessoa(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Voluntario f WHERE f.pessoa.id = ?1 ");
		query.setParameter(1, id);
		Voluntario voluntario = null;
		try {
			voluntario = (Voluntario) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}
	
		return voluntario;
	}
	
	public Voluntario buscarVoluntarioPorCPF(String CPF) {
		TypedQuery<Voluntario> query = geEntityManager().createQuery("SELECT v FROM Voluntario v WHERE v.pessoa.cpf = :CPF", Voluntario.class);
		return query.setParameter("CPF", CPF).getSingleResult();
	}

}
