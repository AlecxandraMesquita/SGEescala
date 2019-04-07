package br.com.sgeescala.controller;



import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.postgresql.jdbc2.ArrayAssistantRegistry;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.list.controller.TurmaVoluntarioListController;
import br.com.sgeescala.list.controller.VoluntarioListController;
import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.CorEquipesRepository;
import br.com.sgeescala.repository.TurmaVoluntarioRepository;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.com.sgeescala.validation.TurmaVoluntarioValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class TurmaVoluntarioController extends Controller<TurmaVoluntario>{
	
	private List<TurmaVoluntario> listaTurma;
	private List<Voluntario> listaVoluntario;
	private TurmaVoluntario turma;
	private Voluntario voluntario;
	private List<CorEquipes> listaCor;
	
	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

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
	public TurmaVoluntario getEntity() {
		if(entity == null) {
			entity = new TurmaVoluntario();

			entity.setVoluntario(new Voluntario());
		}
		return entity;
	}

	@Override
	public Validation<TurmaVoluntario> getValidation() {

		return new TurmaVoluntarioValidation();
	}
	
	public List<TurmaVoluntario> getListaTurma(){
		if(listaTurma == null) {
			TurmaVoluntarioRepository repository = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
			listaTurma = repository.buscarTodos();
		}
		return listaTurma;
	}
	
	private void setListaTurma(List<TurmaVoluntario> listaTurma) {

		this.listaTurma = listaTurma;
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
	
	public void abrirListVoluntario(ActionEvent actionEvent) {
		VoluntarioListController list = new VoluntarioListController();
		list.openList(new SelectionListener<Voluntario>() {
			@Override
			public void select(Voluntario entity) {
				TurmaVoluntarioRepository repository = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
				turma = repository.buscarVoluntarios(entity.getId());
				//consulta de voluntario que passa como parametro o id da pessoa e retorna um voluntario
				 if (turma != null)
						setEntity(turma);
				else
				  	getEntity().setVoluntario(entity);
			}
		});
	}

	public List<CorEquipes> getListaCor() {
		if (listaCor == null) {
			CorEquipesRepository repository = new CorEquipesRepository(JPAFactory.getEntityManager());
			listaCor = repository.buscarTodos();
		}
		return listaCor;
	}

	public void setListaCor(List<CorEquipes> listaCor) {
		this.listaCor = listaCor;
	}
	
	public void buscaTurmaByCor(ActionEvent actionEvent) {
		System.out.println("Entrou ");
		TurmaVoluntarioRepository repository = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
		listaTurma = repository.buscarTurmaCor(getEntity().getCor().getId());
		System.out.println("saiu ");
	}
	
}
