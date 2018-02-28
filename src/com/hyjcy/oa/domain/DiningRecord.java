package com.hyjcy.oa.domain;

public class DiningRecord implements java.io.Serializable {

	private long id;
	private String day;//日期
	private User diner;//用餐人
	private int lunch;//中餐，1为吃，0为不吃
	private int dinner;//晚餐
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public User getDiner() {
		return diner;
	}
	public void setDiner(User diner) {
		this.diner = diner;
	}
	public int getLunch() {
		return lunch;
	}
	public void setLunch(int lunch) {
		this.lunch = lunch;
	}
	public int getDinner() {
		return dinner;
	}
	public void setDinner(int dinner) {
		this.dinner = dinner;
	}
	
	
	
	
}
