package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Pessoa;
import br.com.sgeescala.repository.PessoaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "PessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
		try {
			Pessoa f = ((Pessoa) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Pessoa) arg2).getId() == null ? "" : ((Pessoa) arg2).getId().toString();
		}
		return "";
	}
}
