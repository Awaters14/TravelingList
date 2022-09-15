package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Sep 14, 2022  
*/
@Entity
@Table(name="places")
public class TravelList {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	
	/**
	 * 
	 */
	public TravelList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param state
	 * @param city
	 */
	public TravelList(String country, String state, String city) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	public String returnTravelDetails(){
		
		return this.country + ' ' + this.state + "-" + this.city;
	}
	
}
