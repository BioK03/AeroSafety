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
	
	public void delete(List<Object> objects) {
		try {
			EntityTransaction transaction = startTransaction(); // a tester, si probleme -> faire une transaction par delete
			transaction.begin();
			Object object;
			while(!objects.isEmpty())
			{
				object = objects.get(0);
				if (!entityManager.contains(object)) 
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
			transaction.commit();
			entityManager.close();
			emf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
