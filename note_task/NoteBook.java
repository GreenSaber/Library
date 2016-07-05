package note_task;

import java.util.ArrayList;

public class NoteBook {

	private ArrayList<Note> array_notes;

	public NoteBook(){
		array_notes = new ArrayList<Note>();
	}
	
	public ArrayList<Note> getNotes(){
		return array_notes;
	}
	
	public void createNote(Note note){
		array_notes.add(note);
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
	private String ans;
	public String toString(){
		
		
		for (int i = 0; i < array_notes.size(); i++){
			 ans +=array_notes.get(i);
		 }
		
		return ans;
	}
	
}

