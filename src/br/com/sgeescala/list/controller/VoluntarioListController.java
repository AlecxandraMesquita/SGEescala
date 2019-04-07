package br.com.sgeescala.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class VoluntarioListController extends ListController<Voluntario> {

	private static final long serialVersionUID = -5816342500278252412L;

	public VoluntarioListController() {
		super(new VoluntarioRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemVoluntario");
		getEntity().setNome("");
	}

	@Override
	public Voluntario getEntity() {
		if (entity == null)
			entity = new Voluntario();
		return entity;
	}
	
	@Override
	public List<Voluntario> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<Voluntario>();
			VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
			try {
				listEntity = repository.bucarVoluntarios(getEntity().getNome());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}