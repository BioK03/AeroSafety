package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Action;
import metier.Mission;

public class MissionService extends EntityService {
	
	public void insertMission(Mission mission)
	{
		try
		{
			EntityTransaction transaction = startTransaction();
			if(!entityManager.contains(mission))
			{
				transaction.begin();
				entityManager.persist(mission);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e)
		{
			
		}
	}
	
	public Mission find(int id)
	{
		Mission mission = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			mission=entityManager.find(Mission.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e)
		{
			
		}
		return mission;
	}
	
	public List<Mission> search(String word)
	{
		List<Mission> missions = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			missions= (List<Mission>) entityManager.createQuery("SELECT m FROM Mission m WHERE lower(m.wording) like :word ORDER BY m.id").setParameter("word", "%"+word+"%").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return missions;
	}
	
	public List<Mission> findAll()
	{
		List<Mission> missions = null;
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			missions= (List<Mission>) entityManager.createQuery("SELECT m FROM Mission m ORDER BY m.id").getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return missions;
	}
}
