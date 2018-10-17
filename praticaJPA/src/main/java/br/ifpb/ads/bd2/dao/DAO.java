package br.ifpb.ads.bd2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {

	private final String persistenceUnitName = "praticajpa";
	private static EntityManagerFactory factory;

	protected EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		return factory.createEntityManager();
	}

	protected void close() {
		if (factory.isOpen()) {
			factory.close();
		}
	}

}
