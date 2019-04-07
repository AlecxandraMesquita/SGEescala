package br.com.sgeescala.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.repository.TurmaVoluntarioRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class TurmaVoluntarioListController extends ListController<TurmaVoluntario> {

	private static final long serialVersionUID = -5816342500278252412L;

	public TurmaVoluntarioListController() {
		super(new TurmaVoluntarioRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemTurma");
		getEntity().setNome("");
	}

	@Override
	public TurmaVoluntario getEntity() {
		if (entity == null)
			entity = new TurmaVoluntario();
		return entity;
	}
	
	@Override
	public List<TurmaVoluntario> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<TurmaVoluntario>();
			TurmaVoluntarioRepository repository = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
			try {
				listEntity = (List<TurmaVoluntario>) repository.buscarTurmaCor(getEntity().getCor().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}