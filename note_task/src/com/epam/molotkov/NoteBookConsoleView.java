package com.epam.molotkov;


public class NoteBookConsoleView {

public void print(Note note){	
			System.out.println("Note is "+note.toString());
	}	
	
public void print(Note ... array_notes){
	System.out.println("Notes: ");
	for (Note note : array_notes){
		System.out.println(note.toString());
	}
}
public void print(NoteBook noteBook){
	System.out.println("NoteBook: "+noteBook);
}
}