package com.epam.library.domain;
import java.io.Serializable;

/**
 * Created by Marija.
 */
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int bookID;
	private String title;
	private String brief;
	private int publishYear;
	private String authorName;
	
	public Book() {}

	public Book(int bookID, String title, String brief, int publishYear, String authorName) {		
		this.bookID = bookID;
		this.title = title;
		this.brief = brief;
		this.publishYear = publishYear;
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", brief=" + brief + ", publishYear=" + publishYear
				+ ", authorName=" + authorName + "]";
	}

	public int getBookID() {
		return bookID;
	}
	public String getTitle() {
		return title;
	}
	public String getBrief() {
		return brief;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public String getAuthorName() {
		return authorName;
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + bookID;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + publishYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	//ignore bookID when comparing two books
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (publishYear != other.publishYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}