package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
@Entity
public class TravelerListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String tripsName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Traveler traveler;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<TravelList> listOfPlaces;
	/**
	 * 
	 */
	public TravelerListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param tripsName
	 * @param tripDate
	 * @param traveler
	 * @param listOfItems
	 */
	public TravelerListDetails(int id, String tripsName, LocalDate tripDate, Traveler traveler,
			List<TravelList> listOfPlaces) {
		super();
		this.id = id;
		this.tripsName = tripsName;
		this.tripDate = tripDate;
		this.traveler = traveler;
		this.listOfPlaces = listOfPlaces;
	}
	/**
	 * @param tripsName
	 * @param tripDate
	 * @param traveler
	 * @param listOfPlaces
	 */
	public TravelerListDetails(String tripsName, LocalDate tripDate, Traveler traveler, List<TravelList> listOfPlaces) {
		super();
		this.tripsName = tripsName;
		this.tripDate = tripDate;
		this.traveler = traveler;
		this.listOfPlaces = listOfPlaces;
	}
	/**
	 * @param tripsName
	 * @param tripDate
	 * @param traveler
	 */
	public TravelerListDetails(String tripsName, LocalDate tripDate, Traveler traveler) {
		super();
		this.tripsName = tripsName;
		this.tripDate = tripDate;
		this.traveler = traveler;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tripsName
	 */
	public String getTripsName() {
		return tripsName;
	}
	/**
	 * @param tripsName the tripsName to set
	 */
	public void setTripsName(String tripsName) {
		this.tripsName = tripsName;
	}
	/**
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	/**
	 * @return the traveler
	 */
	public Traveler getTraveler() {
		return traveler;
	}
	/**
	 * @param traveler the traveler to set
	 */
	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}
	/**
	 * @return the listOfPlaces
	 */
	public List<TravelList> getListOfPlaces() {
		return listOfPlaces;
	}
	/**
	 * @param listOfPlaces the listOfPlaces to set
	 */
	public void setListOfPlaces(List<TravelList> listOfPlaces) {
		this.listOfPlaces = listOfPlaces;
	}
	@Override
	public String toString() {
		return "TravelerListDetails [id=" + id + ", tripsName=" + tripsName + ", tripDate=" + tripDate + ", traveler="
				+ traveler + ", listOfPlaces=" + listOfPlaces + "]";
	}
	
	
	

}
