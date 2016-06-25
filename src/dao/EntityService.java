package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Action;
import metier.Indicator;
import metier.Inscription;
import metier.InscriptionAction;
import metier.Learner;
import metier.Mission;

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
		EntityTransaction transaction = startTransaction(); // a tester, si probleme -> faire une transaction par delete
		transaction.begin();
		for(int i=0; i<objects.size(); i++)
		{
			if(objects.get(i) instanceof InscriptionAction)
			{
				entityManager.createQuery("delete from InscriptionAction o where o.id like :id").setParameter("id", ((InscriptionAction)objects.get(i)).getId()).executeUpdate();
			}
			if(objects.get(i) instanceof Inscription)
			{
				entityManager.createQuery("delete from Inscription o where o.id like :id").setParameter("id", ((Inscription)objects.get(i)).getId()).executeUpdate();
			}
			if(objects.get(i) instanceof Learner)
			{
				entityManager.createQuery("delete from Learner o where o.id like :id").setParameter("id", ((Learner)objects.get(i)).getId()).executeUpdate();
			}
			if(objects.get(i) instanceof Indicator)
			{
				entityManager.createQuery("delete from Indicator o where o.id like :id").setParameter("id", ((Indicator)objects.get(i)).getId()).executeUpdate();
			}
			if(objects.get(i) instanceof Action)
			{
				//entityManager.createQuery("delete from action__mission o where o.fk_action like :id").setParameter("id", ((Action)objects.get(i)).getId()).executeUpdate();
				entityManager.createQuery("delete from Action o where o.id like :id").setParameter("id", ((Action)objects.get(i)).getId()).executeUpdate();
			}
			if(objects.get(i) instanceof Mission)
			{
				entityManager.createQuery("delete from Mission o where o.id like :id").setParameter("id", ((Mission)objects.get(i)).getId()).executeUpdate();
			}
		}
		entityManager.flush(); 
		transaction.commit();
		entityManager.close();
		emf.close();
		/*
		try {
			EntityTransaction transaction = startTransaction(); // a tester, si probleme -> faire une transaction par delete
			transaction.begin();
			for(Object object : objects)
			{
				if(!entityManager.contains(object))
				{
					object = entityManager.merge(object);
				}
				if(object instanceof Action)
				{
					for(Action a : ((Action)object).getActions())
					{
						a.setAction(null);
					}
				}
				entityManager.remove(object);
			}
			entityManager.flush(); 
			transaction.commit();
			entityManager.close();
			emf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}*/
	}

}
