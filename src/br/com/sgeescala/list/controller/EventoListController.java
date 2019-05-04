package br.com.sgeescala.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.repository.EventoRepository;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class EventoListController extends ListController<Evento> {

	private static final long serialVersionUID = -5816342500278252412L;
	private Voluntario voluntario;
	public EventoListController() {
		super(new EventoRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemEvento");
		getEntity().setNome("");
	}

	public EventoListController(Voluntario voluntario) {
		super(new EventoRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemEvento");
		getEntity().setNome("");
		this.voluntario = voluntario;
	}
	
	@Override
	public Evento getEntity() {
		if (entity == null)
			entity = new Evento();
		return entity;
	}
	
	@Override
	public List<Evento> getListEntity() {
		
			listEntity = new ArrayList<Evento>();
			EventoRepository repository = new EventoRepository(JPAFactory.getEntityManager());
			try {
				if (getEntity().getData() != null && voluntario != null) {
					listEntity = repository.buscarEventosPorVoluntarioData(voluntario, getEntity().getData());
				}else if(voluntario != null) {
					listEntity = repository.buscarEventosPorVoluntario(voluntario);
				}
				else {
					listEntity = repository.buscarTodos();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return listEntity;
	}
	
	
}