package com.epam.countries;

public class Country {
	private int id;
	private String name;
	private String capital;
	private String population;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setCapital(String capital){
		this.capital=capital;
	}
	
	public void setPopulation(String population){
		this.population=population;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCapital(){
		return capital;
	}
	
	public String getPopulation(){
		return population;
	}	
}