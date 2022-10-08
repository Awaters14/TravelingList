package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
@Entity
@Table(name="traveler")

public class Traveler {
	@Id
	@GeneratedValue
	private int id;
	private String travelersName;
	/**
	 * 
	 */
	public Traveler() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param travelersName
	 */
	public Traveler(int id, String travelersName) {
		super();
		this.id = id;
		this.travelersName = travelersName;
	}
	/**
	 * @param travelersName
	 */
	public Traveler(String travelersName) {
		super();
		this.travelersName = travelersName;
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
	 * @return the travelersName
	 */
	public String getTravelersName() {
		return travelersName;
	}
	/**
	 * @param travelersName the travelersName to set
	 */
	public void setTravelersName(String travelersName) {
		this.travelersName = travelersName;
	}
	
	
	@Override
	public String toString() {
		return "Traveler [id=" + id + ", travelersName=" + travelersName + "]";
	}
	
	
}
