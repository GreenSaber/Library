package com.epam.molotkov;


import java.util.Date;


public class Note {
	private String note;
	private Date date;
	
	public Note(String note, Date date){
		this.note=note;
		this.date=date;
	}
	
	public void setNote(String note){
		this.note=note;
	}
	
	public String getNote(){
		return note;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	public Date getDate(){
		return date;
	}
	
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if (null == obj){
			return false;
		}
		if (this.getClass()!=obj.getClass()){
			return false;
		}
		Note newNote= (Note) obj;
		if (!this.toString().equals(newNote.toString())){
			return false;
		}
		return true;	
	}
	
//	public int hashCode(){
//		
//	}
	
	public String toString(){
		return getClass().getName()+"Note is "+note+""
				+ ""
				+ "\n Date is "+date;
	}		
}