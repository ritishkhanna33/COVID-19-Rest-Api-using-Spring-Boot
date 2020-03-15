package com.corona.tracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locationstats {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String state;
    private String country;
    private int latesttotalcases;
    
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalCases() {
		return latesttotalcases;
	}
	public void setLatestTotalCases(int latestTotalCases) {
		this.latesttotalcases = latestTotalCases;
	}
	@Override
	public String toString() {
		return "LocationStats [id=" + id + ", state=" + state + ", country=" + country + ", latestTotalCases="
				+ latesttotalcases + "]";
	}
	

}
