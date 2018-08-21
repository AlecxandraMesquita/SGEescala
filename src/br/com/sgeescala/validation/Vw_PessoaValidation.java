package br.com.sgeescala.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.sgeescala.model.Pessoa;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class Vw_PessoaValidation implements Validation<Pessoa> {

	List<String> listMessages;
	
	public void validate(Pessoa t) throws ValidationException {
		
//		if (t.getNome() == null || t.getNome().trim().equals(""))
//			getlistMessages().add("O Nome deve ser informado!");
//		
//		if (t.getTelefone() == null || t.getTelefone().equals(""))
//			getlistMessages().add("O Telefone deve ser informado!");
//		
//		if (t.getGmail() == null || t.getGmail().equals(""))
//			getlistMessages().add("O Email deve ser informado!");
//		if (t.getCpf() == null || t.getCpf().equals(""))
//			getlistMessages().add("O CPF deve ser informado!");
		
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
