package br.com.sgeescala.model;

//import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Escala extends Model<Escala>{

	private static final long serialVersionUID = -3906275387415336590L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidescala")
	@SequenceGenerator(name = "seqidescala", sequenceName = "seqidescala", allocationSize = 1)
	private Integer id;
	
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	
}
