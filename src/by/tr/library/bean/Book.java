package by.tr.library.bean;

public class Book {
	private String title;
	private int price;
	private String author;

	public Book(){
		this.title = "";
		this.price = 0;
	}

	
	public Book(String title, String author, int price){
		this.title = title;
		this.price = price;
		this.author=author;
	}
	
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	public String tiString(){
		return ("Title : "+title+", Author : "+author+", Price : "+price);
	}
	
	
	

}
