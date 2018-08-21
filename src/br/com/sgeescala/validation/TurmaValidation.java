package br.com.sgeescala.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.sgeescala.model.Turma;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class TurmaValidation implements Validation<Turma>{
	List<String> listMessages;
	@Override
	public void validate(Turma t) throws ValidationException {
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
