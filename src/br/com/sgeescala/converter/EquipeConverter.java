package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Turma;
import br.com.sgeescala.repository.TurmaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "EquipeConverter", forClass = Turma.class)
public class EquipeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		TurmaRepository repository = new TurmaRepository(JPAFactory.getEntityManager());
		try {
			Turma f = ((Turma) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Turma) arg2).getId() == null ? "" : ((Turma) arg2).getId().toString();
		}
		return "";
	}
}
