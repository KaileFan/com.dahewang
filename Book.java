package µÚ¶þÌâ;

import java.io.Serializable;

public class Book implements Serializable {
 
	private String bookName;

	private double bookPrice;

	private String author;

	
	@Override
	public String toString() {
		return bookName + "\t\t" + bookPrice + "\t\t" + author;
	}
	
	public Book() {
		
	}

	public Book(String bookName, double bookPrice, String author) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
