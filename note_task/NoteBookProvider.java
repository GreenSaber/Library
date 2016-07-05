package note_task;

public class NoteBookProvider {
	
	private static NoteBook notebook = new NoteBook();
	
	private NoteBookProvider(){
		
	}
	public static NoteBook getNoteBook(){
		return notebook;
	}
}
