package br.com.sgeescala.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Escala;
import br.com.sgeescala.repository.EscalaRepository;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EscalaController extends Controller<Escala>{

	private List<Escala> listaEscala;
//	private List<Escala> subEquipe;
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	@Override
	public Escala getEntity() {
		if(entity == null) {
			entity = new Escala();
		}
		return entity;	
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaEscala(null);
	}

	@Override
	public Validation<Escala> getValidation() {
		// TODO Auto-generated method stub
//		return new EscalaValidation;
		return null;
	}
	public List<Escala> getListaEscala(){
		if(listaEscala == null) {
			EscalaRepository repository = new EscalaRepository(JPAFactory.getEntityManager());
			listaEscala = repository.buscarTodos();
		}
		return listaEscala;
	}
	
	private void setListaEscala(List<Escala> listaEscala) {
		this.listaEscala = listaEscala;
		
	}
	
	
	public void trocaMembroEscala() {
		
	}
	public void gerarEscala() {
		
	}
	
}
