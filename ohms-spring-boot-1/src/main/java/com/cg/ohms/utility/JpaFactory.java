package com.cg.ohms.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaFactory {
	
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManagerFactory getEntityManagerFactory() {
		
	
	if(entityManagerFactory==null) {
		 entityManagerFactory=Persistence.createEntityManagerFactory("abc");
		 System.out.println("factory");
	}
	return entityManagerFactory;
	
	}
	public static void closeFactory()
	{
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
	}
}
