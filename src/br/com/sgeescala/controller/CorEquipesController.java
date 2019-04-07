package br.com.sgeescala.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.list.controller.TurmaVoluntarioListController;
import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.repository.CorEquipesRepository;
import br.com.sgeescala.repository.TurmaVoluntarioRepository;
import br.com.sgeescala.validation.CorEquipesValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class CorEquipesController extends Controller<CorEquipes>{
	
	private List<CorEquipes> listaCorEquipes;
	
	
	@Override
	protected EntityManager getEntityManager() {	
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		
		setListaCorEquipes(null);
		
	}

	@Override
	public CorEquipes getEntity() {
		if(entity == null) {
			
			entity = new CorEquipes();
		}
		return entity;
	}

	@Override
	public Validation<CorEquipes> getValidation() {

		return new CorEquipesValidation();
	}
	
	public List<CorEquipes> getListaCorEquipes(){
		if(listaCorEquipes == null) {
			CorEquipesRepository repository = new CorEquipesRepository(JPAFactory.getEntityManager());
			listaCorEquipes = repository.buscarTodos();
		}
		return listaCorEquipes;
	}
	
	private void setListaCorEquipes(List<CorEquipes> listaCorEquipes) {
		
		this.listaCorEquipes = listaCorEquipes;
	}
	
//	public void abrirListTurma(ActionEvent actionEvent) {
//		TurmaListController list = new TurmaListController();
//		list.openList(new SelectionListener<Turma>() {
//			@Override
//			public void select(Turma entity) {
//				EquipeRepository repository = new EquipeRepository(JPAFactory.getEntityManager());
//				equipe = (Equipe) repository.buscarTurmas(entity.getCor());
//				//consulta de voluntario que passa como parametro o id da pessoa e retorna um voluntario
//				 if (equipe != null)
//						setEntity(equipe);
//				else
//				  	getEntity().setTurma(entity);
//				 	System.out.println("nao entrou no voluntario repository");
//			}
//		});
//	}
	
}
