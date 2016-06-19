package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Indicator;
import metier.LearnerAction;

public class LearnerActionService extends EntityService {
	
	public void insertGoal(LearnerAction learnerAction)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(learnerAction))
			{
				transaction.begin();
				entityManager.persist(learnerAction);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public LearnerAction find(int id)
	{
		LearnerAction learnerAction = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			learnerAction=entityManager.find(LearnerAction.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e)
		{
			
		}
		return learnerAction;
	}
	
	public List<LearnerAction> findAll()
	{
		List<LearnerAction> learnerActions = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			learnerActions= (List<LearnerAction>) entityManager.createQuery("SELECT lm FROM LearnerAction lm ORDER BY lm.id").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return learnerActions;
	}
	
	public void delete(int id) {
		delete(find(id));
	}

	public void delete(LearnerAction learnerAction) {
		try {
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			if (!entityManager.contains(learnerAction)) {
				learnerAction = entityManager.merge(learnerAction);
			}
			entityManager.remove(learnerAction);
			transaction.commit();
			entityManager.close();
			emf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
