package com.epam.molotkov;

import java.util.ArrayList;

public class NoteBook {

	private ArrayList<Note> arrayNotes;

	public NoteBook(){
		arrayNotes = new ArrayList<Note>();
	}
	
	public ArrayList<Note> getNotes(){
		return arrayNotes;
	}
	
	public void createNote(Note note){
		arrayNotes.add(note);
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
		NoteBook newNoteBook= (NoteBook) obj;
		if (!this.toString().equals(newNoteBook.toString())){
			return false;
		}
		return true;	
	}
	
//	public int hashCode(){
//	
//}
	
	public String toString(){
		String ans="NoteBook : ";
		
		for (int i = 0; i < arrayNotes.size(); i++){
			 ans +=arrayNotes.get(i);
		 }
		
		return getClass().getName()+ans;
	}
	
}
