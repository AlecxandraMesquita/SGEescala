package br.com.sgeescala.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {

private static EntityManagerFactory em = Persistence.createEntityManagerFactory("SGEEscala");

	private JPAFactory() {}
	
	public static EntityManager getEntityManager() {
		return em.createEntityManager();
	}

	public static EntityManagerFactory getEmf() {
		return em;
	}

	public static void setEm(EntityManagerFactory emf) {
		JPAFactory.em = emf;
	}
}
