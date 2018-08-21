package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.application.Session;
import br.unitins.frame.application.Util;
import br.unitins.frame.repository.Repository;

public class VoluntarioRepository extends Repository<Voluntario>{

	public VoluntarioRepository(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<Voluntario> getModelClass() {
		// TODO Auto-generated method stub
		return Voluntario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Voluntario> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select f From Voluntario f Order by f.id Desc");
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
	
	public Voluntario buscarUVoluntarioPorCPF(String CPF) {
		TypedQuery<Voluntario> query = geEntityManager().createQuery("SELECT f FROM Voluntario f WHERE f.pessoas.cpf = :CPF", Voluntario.class);

		return query.setParameter("CPF", CPF).getSingleResult();
	}
	
//Descomentar depois
//	public void logout(ActionEvent actionEvent) {
//		Session.encerrarSessao();
//		Util.redirect("login.xhtml");
//	}
}
