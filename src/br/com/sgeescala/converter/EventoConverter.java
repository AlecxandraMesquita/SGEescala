package br.com.sgeescala.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.repository.EventoRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "EventoConverter", forClass = Evento.class)
public class EventoConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		EventoRepository repository = new EventoRepository(JPAFactory.getEntityManager());
		try {
			Evento f = ((Evento) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Evento) arg2).getId() == null ? "" : ((Evento) arg2).getId().toString();
		}
		return "";
	}
}
