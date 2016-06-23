package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.InscriptionAction;

public class InscriptionActionService extends EntityService {
	
	public void insertInscriptionAction(InscriptionAction inscriptionAction)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(inscriptionAction))
			{
				transaction.begin();
				entityManager.persist(inscriptionAction);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public void delete(int id)
	{
		deleteObjects(getCascade(id));
	}
	
	public InscriptionAction find(int id)
	{
		InscriptionAction inscriptionAction = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			inscriptionAction=entityManager.find(InscriptionAction.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e)
		{
			
		}
		return inscriptionAction;
	}
	
	@SuppressWarnings("unchecked")
	public List<InscriptionAction> findAll()
	{
		List<InscriptionAction> inscriptionActions = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			inscriptionActions= (List<InscriptionAction>) entityManager.createQuery("SELECT ia FROM Inscription__Action ia ORDER BY ia.id").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return inscriptionActions;
	}
	
	public List<Object> getCascade(int id) {
		InscriptionAction ia=find(id);
		ArrayList<Object> returns = new ArrayList<>();
		returns.add(ia);
		return returns;
	}
}
