package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Escala;
import br.com.sgeescala.repository.EscalaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "EscalaConverter", forClass = Escala.class)
public class EscalaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		EscalaRepository repository = new EscalaRepository(JPAFactory.getEntityManager());
		try {
			Escala t = ((Escala) repository.find(Integer.parseInt(arg2)));
			return t;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Escala) arg2).getId() == null ? "" : ((Escala) arg2).getId().toString();
		}
		return "";
	}
}
