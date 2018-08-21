package br.com.sgeescala.controller;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.CorEquipe;
import br.com.sgeescala.model.Turma;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.TurmaRepository;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.com.sgeescala.validation.TurmaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class TurmaController extends Controller<Turma>{
	
	private List<Turma> listaTurma;
	private List<Voluntario> listaVoluntario;
	
	@Override
	protected EntityManager getEntityManager() {	
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaTurma(null);
		setListaVoluntario(null);
	}

	@Override
	public Turma getEntity() {
		if(entity == null) {
			entity = new Turma();
//			entity.setVoluntario(new Voluntario());
		}
		return entity;
	}

	@Override
	public Validation<Turma> getValidation() {

		return new TurmaValidation();
	}
	
	public List<Turma> getListaTurma(){
		if(listaTurma == null) {
			TurmaRepository repository = new TurmaRepository(JPAFactory.getEntityManager());
			listaTurma = repository.buscarTodos();
		}
		return listaTurma;
	}
	
	private void setListaTurma(List<Turma> listaTurma) {
		
		this.listaTurma = listaTurma;
	}
	
	public CorEquipe[] getCor(){
		return CorEquipe.values();
    }

	public List<Voluntario> getListaVoluntario() {
		if (listaVoluntario == null) {
			VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
			listaVoluntario = repository.bucarTodos();
		}
		return listaVoluntario;
	}

	public void setListaVoluntario(List<Voluntario> listaVoluntario) {
		this.listaVoluntario = listaVoluntario;
	}
}
