package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.VoluntarioRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "voluntarioConverter", forClass = Voluntario.class)
public class VoluntarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		VoluntarioRepository repository = new VoluntarioRepository(JPAFactory.getEntityManager());
		try {
			Voluntario f = ((Voluntario) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Voluntario) arg2).getId() == null ? "" : ((Voluntario) arg2).getId().toString();
		}
		return "";
	}
}
