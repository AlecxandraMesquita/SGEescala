package br.com.sgeescala.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.repository.PessoaRepository;
import br.com.sgeescala.validation.Vw_PessoaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class PessoaController extends Controller<Pessoa>{
	
	private List<Pessoa> listaPessoa;
	
//	 private Report relatorio;
//
//	 public Report getRelatorio() {
//		 if (relatorio == null)
//		 relatorio = new Report("jdbc/escala", "reports", "RelatorioPessoas");
//		 return relatorio;
//	 }

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaPessoa(null);
	}
	
	
	@Override
	public Pessoa getEntity() {
		if (entity == null) {
			entity = new Pessoa();
		}
		return entity;
	}

	@Override
	public Validation<Pessoa> getValidation() {
		// TODO Auto-generated method stub
		return new Vw_PessoaValidation();
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



//	public TipoPessoa[] getTipo(){
//		return TipoPessoa.values();
//    }
	
}	
