package br.com.sgeescala.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
/*import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;*/
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.list.controller.PessoaListController;
/*import br.com.sgeescala.list.controller.TurmaVoluntarioListController;
import br.com.sgeescala.list.controller.VoluntarioListController;*/
import br.com.sgeescala.model.Disponibilidade;
import br.com.sgeescala.model.Permissao;
import br.com.sgeescala.model.Status;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.TipoVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.PessoaRepository;
import br.com.sgeescala.repository.TurmaVoluntarioRepository;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.com.sgeescala.validation.VoluntarioValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.application.Session;
import br.unitins.frame.application.Util;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class VoluntarioController extends Controller<Voluntario>{

	private List<Voluntario> listaVoluntario;
	private List<Pessoa> listaPessoa;
	private Voluntario voluntario;
	private Voluntario voluntarioLogado;
	private TurmaVoluntario turma;
	private List<TurmaVoluntario>listaTurma;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		
		setListaVoluntario(null);
		
	}
	
	
	@Override
	public Voluntario getEntity() {
		if (entity == null) {
			entity = new Voluntario();
			
//			entity.setTurma(new Turma());
		}
		return entity;
	}

	@Override
	public Validation<Voluntario> getValidation() {
		
		return new VoluntarioValidation();

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
		
	public List<Pessoa> getListaPessoa() {
		if (listaPessoa == null) {
			PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
			listaPessoa = repository.bucarTodos();
		}
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
	public void Nome(String nome) {
		nome = voluntario.getPessoa().getNome();
	}

	public void abrirListPessoa(ActionEvent actionEvent) {
		PessoaListController list = new PessoaListController();
		list.openList(new SelectionListener<Pessoa>() {
			@Override
			public void select(Pessoa entity) {
				VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
				voluntario = repository.bucarPessoa(entity.getId());
				//consulta de funcionario que passa como parametro o id da pessoa e retorna um funcionario
				 if (voluntario != null)
						setEntity(voluntario);
				else
				  	getEntity().setPessoa(entity);
			}
		});
	}
	
	public void abrirListVoluntaro(ActionEvent actionEvent) {
		PessoaListController list = new PessoaListController();
		list.openList(new SelectionListener<Pessoa>() {
			@Override
			public void select(Pessoa entity) {
				VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
				voluntario = repository.bucarPessoa(entity.getId());
				//consulta de voluntario que passa como parametro o id da pessoa e retorna um voluntario
				 if (voluntario != null)
						setEntity(voluntario);
				else
				  	getEntity().setPessoa(entity);
				 	System.out.println("nao entrou no voluntario repository");
			}
		});
	}
	
	public Status[] getStatus(){
		return Status.values();
   }
	
	public Permissao[] getPermissao(){
		return Permissao.values();
    }

	
	public Voluntario getVoluntarioLogado() {
		VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		voluntarioLogado = repository.buscarVoluntarioPorCPF(external.getRemoteUser());
		return voluntarioLogado;
	}
	public void setVoluntarioLogado(Voluntario voluntarioLogado) {
		this.voluntarioLogado = voluntarioLogado;
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

	public TipoVoluntario[] getTipo(){
		return TipoVoluntario.values();
	}
	public Disponibilidade[] getOpcao(){
		return Disponibilidade.values();
	}
	
	public void logout(ActionEvent actionEvent) {
		Session.encerrarSessao();
		Util.redirect("login.xhtml");
	}
}
