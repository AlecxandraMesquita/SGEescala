package br.com.sgeescala.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.sgeescala.model.Voluntario;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class VoluntarioValidation implements Validation<Voluntario>{

	List<String> listMessages;
	
	@Override
	public void validate(Voluntario t) throws ValidationException {
		// TODO Auto-generated method stub
		
//		if (t.getSenha() == null || t.getSenha().equals(""))
//			getlistMessages().add("A Senha deve ser informada!");
//		if (t.getTipo() == null || t.getTipo().equals(""))
//			getlistMessages().add("A Tipo deve ser informada!");				
//		if (t.getCodIgreja() != 2);
//			getlistMessages().add("Codigo não pertence a Sibapa!");		
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
