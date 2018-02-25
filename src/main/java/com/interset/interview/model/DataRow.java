package com.interset.interview.model;

import java.time.Instant;
import java.util.TimeZone;

public class DataRow {

	private String firstName;
	private String lastName;
	private int siblings;
	private String favouriteFood;
	private TimeZone birthTimezone;
	private Instant birthTimestamp;
	
	public DataRow(String firstName, String lastName, int siblings, String favouriteFood, TimeZone birthTimezone,
			Instant birthTimestamp) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.siblings = siblings;
		this.favouriteFood = favouriteFood;
		this.birthTimezone = birthTimezone;
		this.birthTimestamp = birthTimestamp;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getSiblings() {
		return siblings;
	}
	
	public String getFavouriteFood() {
		return favouriteFood;
	}
	
	public TimeZone getBirthTimezone() {
		return birthTimezone;
	}
	
	public Instant getBirthTimestamp() {
		return birthTimestamp;
	}
}
