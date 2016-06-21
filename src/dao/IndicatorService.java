package dao;

import java.util.*;
import javax.persistence.EntityTransaction;

import metier.Indicator;

public class IndicatorService extends EntityService {

	public void insertIndicator(Indicator indicator) {
		try {
			EntityTransaction transaction = startTransaction();
			if (!entityManager.contains(indicator)) {
				transaction.begin();
				entityManager.persist(indicator);
				entityManager.flush();
				transaction.commit();
			}
			entityManager.close();
		} catch (Exception e) {

		}
	}

	public Indicator find(int id) {
		Indicator indicator = null;
		try {
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			indicator = entityManager.find(Indicator.class, id);
			entityManager.close();
			emf.close();
		} catch (Exception e) {

		}
		return indicator;
	}

	@SuppressWarnings("unchecked")
	public List<Indicator> findAll() {
		List<Indicator> indicators = null;
		try {
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			indicators = (List<Indicator>) entityManager.createQuery("SELECT i FROM Indicator i ORDER BY i.id")
					.getResultList();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return indicators;
	}

	public List<Object> getCascade(int id) {
		Indicator i=find(id);
		ArrayList<Object> returns = new ArrayList<>();
		returns.add(i);
		return returns;
	}
	
	@SuppressWarnings("unchecked")
	public List<Indicator> getNoLinkObjects() {
		List<Indicator> indicators = null;
		try {
			EntityTransaction transaction = startTransaction();
			transaction.begin();
			indicators = (List<Indicator>) entityManager.createQuery("SELECT i FROM Indicator i WHERE fk_action = null ORDER BY i.id")
					.getResultList();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return indicators;
	}
}
