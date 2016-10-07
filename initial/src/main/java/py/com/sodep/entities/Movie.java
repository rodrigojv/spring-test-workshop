package py.com.sodep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import py.com.sodep.enums.ContentRating;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String title;
	
	@Enumerated(EnumType.STRING)
	private ContentRating rating;
	
	
	@ManyToOne
	private User user;

	public Movie() {
		
	}
	
	public Movie(String title, ContentRating rating) {
		this.title = title;
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ContentRating getRating() {
		return rating;
	}

	public void setRating(ContentRating rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
