package br.com.sgeescala.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.repository.Repository;

public class TurmaVoluntarioRepository extends Repository<TurmaVoluntario>{

	
	public TurmaVoluntarioRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<TurmaVoluntario> getModelClass() {
		return TurmaVoluntario.class;
	}

	@SuppressWarnings("uncheckd")
	public List<TurmaVoluntario> buscarTodos() {
		
		Query query = geEntityManager().createQuery("Select t From TurmaVoluntario t Order by t.id Desc");
		List<TurmaVoluntario> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<TurmaVoluntario>();

		return lista;

	}
	
	public List<TurmaVoluntario> buscarTurmas(String nome) {
		
		Query query = geEntityManager().createQuery("Select eq From TurmaVoluntario eq WHERE eq.nome LIKE ?1 ORDER BY eq.nome");
		query.setParameter(2, "%" + nome + "%");
		List<TurmaVoluntario>lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<TurmaVoluntario>();

		return lista;

	}
	
	public List<Voluntario> buscarVoluntario(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT f FROM TurmaVoluntario f WHERE f.voluntario.pessoa.nome LIKE ?1 ORDER BY f.pessoa.nome");
		query.setParameter(1, "%"+nome+"%");
		List<Voluntario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Voluntario>();
		
		return lista;
	}
	
	public TurmaVoluntario buscarVoluntarios(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Voluntario f WHERE f.pessoa.id = ?1 ");
		query.setParameter(1, id);
		TurmaVoluntario turma = null;
		try {
			turma = (TurmaVoluntario) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}
	
		return turma;
	}
	

	
	public List<TurmaVoluntario>  buscarTurmaCor(Integer id) {

		Query query = geEntityManager().createQuery("SELECT tv FROM TurmaVoluntario tv WHERE tv.cor.id = ?1 ORDER BY tv.voluntario.opcao");
		query.setParameter(1, id);
		List<TurmaVoluntario> lista = query.getResultList();
		if (lista == null)
			lista = new ArrayList<TurmaVoluntario>();
		
		return lista;
	}
	
	public List<Voluntario>  buscarVoluntarioCor(CorEquipes cor) {
		String sql = "SELECT tv.voluntario FROM TurmaVoluntario tv ";
		if (cor != null ) {		
			sql += "WHERE tv.cor.id = ?1 ";
		}
		sql += "ORDER BY tv.voluntario.opcao";
		Query query = geEntityManager().createQuery(sql);
		if(cor!= null) {
			query.setParameter(1, cor.getId());
		}
		List<Voluntario> lista = query.getResultList();
		if (lista == null)
			lista = new ArrayList<Voluntario>();
		
		return lista;
	}
	
	
	
	
	
//	public List<TurmaVoluntario>  buscarVoluntarioCor(CorEquipes cor) {
//		String sql = "SELECT tv.voluntario FROM TurmaVoluntario tv ";
//		if (cor != null ) {		
//			sql += "WHERE tv.cor.id = ?1 ";
//		}
//		sql += "ORDER BY tv.voluntario.opcao";
//		Query query = geEntityManager().createQuery(sql);
//		if(cor!= null) {
//			query.setParameter(1, cor.getId());
//		}
//		List<TurmaVoluntario> lista = query.getResultList();
//		if (lista == null)
//			lista = new ArrayList<TurmaVoluntario>();
//		
//		return lista;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public List<TurmaVoluntario> buscarCor(String corEquipes){
		Query query = geEntityManager().createQuery("SELECT t FROM TurmaVoluntario t WHERE t.cor =:cor");
		query.setParameter("cor",corEquipes);
		List<TurmaVoluntario> lista = query.getResultList();
		if (lista == null)
			lista = new ArrayList<TurmaVoluntario>();
		
		return lista;
	}*/
	
}
