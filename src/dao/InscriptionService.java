package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Inscription;

public class InscriptionService extends EntityService {
	
	public void insertInscription(Inscription inscription)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(inscription))
			{
				transaction.begin();
				entityManager.persist(inscription);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public Inscription find(int id)
	{
		Inscription inscription = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			inscription=entityManager.find(Inscription.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e)
		{
			
		}
		return inscription;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscription> findAll()
	{
		List<Inscription> inscriptions = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			inscriptions= (List<Inscription>) entityManager.createQuery("SELECT i FROM Inscription i ORDER BY i.id").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return inscriptions;
	}
	
	public List<Object> getCascade(int id) {
		Inscription i=find(id);
		ArrayList<Object> returns = new ArrayList<>();
		returns.addAll(i.getInscriptionActions());
		returns.add(i);
		return returns;
	}
}
