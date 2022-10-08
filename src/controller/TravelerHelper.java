package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Traveler;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
public class TravelerHelper {

static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("TravelingList");
	
	public void insertTraveler(Traveler t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);em.getTransaction().commit();
		em.close();
	}
	
	public List<Traveler> showAllTravelers(){
		EntityManager em = emfactory.createEntityManager();
		List<Traveler> allTravelers = em.createQuery("SELECT t FROM Traveler t").getResultList();
		return allTravelers;
	}
	
	public Traveler findTraveler(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Traveler> typedQuery = em.createQuery("select th from Traveler th where th.travelersName = :selectedName",Traveler.class);
	
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Traveler foundTraveler;
		try{
			foundTraveler = typedQuery.getSingleResult();
		} catch(NoResultException ex) {
			foundTraveler = new Traveler(nameToLookUp);
		}
		em.close();
		return foundTraveler;
	}
}
