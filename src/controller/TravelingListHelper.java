package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TravelList;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Sep 14, 2022  
*/
public class TravelingListHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TravelingList");
	
	public void insertPlace(TravelList tl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(tl);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePlace(TravelList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TravelList> typedQuery = em.createQuery("select tl from TravelList tl where tl.country = :selectedCountry and tl.state = :selectedStore and tl.city = :selectedCity", TravelList.class);
		
		//Substitute parameter with actual data from the toDelete the place
		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedStore", toDelete.getState());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new place item
		TravelList result = typedQuery.getSingleResult();
		
		//remove the place
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TravelList> searchForPlaceByCountry(String countryName){
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
				
		TypedQuery<TravelList> typedQuery = em.createQuery("select tl from TravelList tl where tl.country = :selectedCountry", TravelList.class);
		typedQuery.setParameter("selectedCountry", countryName);
				
		List<TravelList> foundCountry = typedQuery.getResultList();
				
		em.close();
		return foundCountry;
				
	}
	
	public List<TravelList> searchForPlaceByState(String stateName) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<TravelList> typedQuery = em.createQuery("select tl from TravelList tl where tl.state = :selectedState", TravelList.class);
		typedQuery.setParameter("selectedState", stateName);
		
		List<TravelList> foundState = typedQuery.getResultList();
		
		em.close();
		return foundState;
	}
	public List<TravelList> searchForPlaceByCity(String cityName) {
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<TravelList> typedQuery = em.createQuery("select tl from TravelList tl where tl.city = :selectedCity", TravelList.class);
		typedQuery.setParameter("selectedCity", cityName);
		
		List<TravelList> foundCity = typedQuery.getResultList();
		
		em.close();
		return foundCity;
	}
	
	public TravelList searchForPlaceById(int idToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TravelList found = em.find(TravelList.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updatePlace(TravelList toEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
		}
	
	public List<TravelList> showAllPlaces(){
		EntityManager em = emfactory.createEntityManager();
		List<TravelList> allItems = em.createQuery("SELECT i FROM TravelList i").getResultList();
		return allItems;
	}
}
