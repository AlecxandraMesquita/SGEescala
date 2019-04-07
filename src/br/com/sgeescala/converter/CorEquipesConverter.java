package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.repository.CorEquipesRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "CorEquipesConverter", forClass = CorEquipes.class)
public class CorEquipesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CorEquipesRepository repository = new CorEquipesRepository(JPAFactory.getEntityManager());
		try {
			CorEquipes f = ((CorEquipes) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((CorEquipes) arg2).getId() == null ? "" : ((CorEquipes) arg2).getId().toString();
		}
		return "";
	}
}
