package com.epam.movies;

public class Movie {
	private int id;
	private String name;
	private String country;
	private String date;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setCountry(String country){
		this.country=country;
	}
	
	public void setDate(String date){
		this.date=date;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getDate(){
		return date;
	}	
}
