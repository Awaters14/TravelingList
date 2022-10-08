package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TravelerListDetails;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
public class TravelListDetailHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TravelingList");

	public void insertNewListDetails(TravelerListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<TravelerListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<TravelerListDetails> allDetails = em.createQuery("SELECT d FROM TravelerListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(TravelerListDetails toDelete) {
		// TODOAuto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TravelerListDetails> typedQuery = em
				.createQuery("select detail from TravelerListDetails detail where detail.id = :selectedId", TravelerListDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		TravelerListDetails result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public TravelerListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TravelerListDetails found = em.find(TravelerListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(TravelerListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
