package com.cg.iter.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Db {

	private static EntityManagerFactory factory;
	private static EntityManager   em;
	
	static{
		factory= Persistence.createEntityManagerFactory("authorinfo");
	}
	
	public EntityManager getManager() {
		if(em==null || !em.isOpen())
			em=factory.createEntityManager();
	
		return em;
	}
}
