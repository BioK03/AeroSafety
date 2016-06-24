package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Action;

public abstract class EntityService {
	
	protected EntityManager entityManager;
	protected EntityManagerFactory emf;
	
	public EntityTransaction startTransaction()
	{
		emf=Persistence.createEntityManagerFactory("JEEProjetPermis");
		entityManager=emf.createEntityManager();
		return entityManager.getTransaction();
	}
	
	public void insert(Object o)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(o))
			{
				transaction.begin();
				entityManager.persist(o);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public void merge(Object o)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(o))
			{
				transaction.begin();
				entityManager.merge(o);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public void deleteObjects(List<Object> objects) {
		emf=Persistence.createEntityManagerFactory("JEEProjetPermis");
		entityManager=emf.createEntityManager();
		Object object;
		while(!objects.isEmpty())
		{
			object = objects.get(0);
			try {
				EntityTransaction transaction = entityManager.getTransaction(); 
				transaction.begin();
				if(object instanceof Action)
				{
					for(Action a : ((Action)object).getActions())
					{
						a.setAction(null);
					}
				}
				entityManager.remove(object);
				objects.remove(object);
				transaction.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		entityManager.close();
		emf.close();
	}

}
