package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Action;
import metier.Goal;

public class GoalService extends EntityService {
	
	public void insertGoal(Goal goal)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(goal))
			{
				transaction.begin();
				entityManager.persist(goal);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public List<Goal> search(String word)
	{
		List<Goal> goals = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			goals= (List<Goal>) entityManager.createQuery("SELECT g FROM Goal g WHERE lower(g.wording) like :word ORDER BY g.id").setParameter("word", "%"+word+"%").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return goals;
	}
	
	public Goal find(int id)
	{
		Goal goal = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			goal=entityManager.find(Goal.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e)
		{
			
		}
		return goal;
	}
	
	public List<Goal> findAll()
	{
		List<Goal> goals = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			goals= (List<Goal>) entityManager.createQuery("SELECT g FROM Goal g ORDER BY g.id").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return goals;
	}
}
