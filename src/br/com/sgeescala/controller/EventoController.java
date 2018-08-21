package br.com.sgeescala.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Turma;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.repository.TurmaRepository;
import br.com.sgeescala.repository.EventoRepository;
import br.com.sgeescala.validation.EventoValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EventoController extends Controller<Evento>{

	List<Evento> listaEvento;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return JPAFactory.getEntityManager();
	}
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaEvento(null);
	}
	
	@Override
	public Evento getEntity() {
		// TODO Auto-generated method stub
		if(entity == null) {
			entity = new Evento();
		}
		return entity;
	}

	@Override
	public Validation<Evento> getValidation() {
		// TODO Auto-generated method stub
		return new EventoValidation();
	}
	
	public List<Evento> getListaEvento(){
		if(listaEvento == null) {
			EventoRepository repository = new EventoRepository(JPAFactory.getEntityManager());
			listaEvento = repository.buscarTodos();
		}
		return listaEvento;
	}
	
	private void setListaEvento(List<Evento> listaEvento) {
		// TODO Auto-generated method stub
		this.listaEvento = listaEvento;
	}
	
	
	public String convertData(Date data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String formData = formato.format(data);
		return formData;
	}

}
