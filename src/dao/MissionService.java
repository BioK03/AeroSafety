package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Action;
import metier.Inscription;
import metier.Learner;
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
			System.err.println(e.getMessage());
		}
	}
	
	public void delete(int id)
	{
		deleteObjects(getCascade(id));
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
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	
	/**
	public void delete(int id) {
		delete(find(id));
	}

	public void delete(Mission miss) {
		try {
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			
			//suppression dans la table mission
			if (!entityManager.contains(miss)) {
				miss = entityManager.merge(miss);
			}
			entityManager.remove(miss);
			transaction.commit();
			entityManager.close();
			emf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	public List<Object> getCascade(int id) {
		Mission m=find(id);
		ArrayList<Object> returns = new ArrayList<>();
		for(Inscription i : m.getInscriptions())
		{
			returns.addAll(i.getInscriptionActions());
		}
		returns.addAll(m.getInscriptions());
		returns.add(m);
		return returns;
	}
	
	public List<Mission> getMissionsByUser(int id) {
		List<Mission> missions = null;
		LearnerService lService = new LearnerService();
		try 
		{
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			missions= (List<Mission>) entityManager.createQuery("SELECT m FROM Mission m, Inscription i WHERE i.mission = m AND i.learner=:learner").setParameter("learner", lService.find(id)).getResultList();
			entityManager.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return missions;
	}
}
