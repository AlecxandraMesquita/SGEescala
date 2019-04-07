package br.com.sgeescala.validation;

import java.util.ArrayList;
import java.util.List;
import br.com.sgeescala.model.Escala;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class EscalaValidation implements Validation<Escala>{
	List<String> listMessages;
	@Override
	public void validate(Escala t) throws ValidationException {
		// TODO Auto-generated method stub
		
		
		if (getlistMessages().size() > 0)
			throw new ValidationException(getlistMessages());
	}
	
	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}
	
	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}
}
