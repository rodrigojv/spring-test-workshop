package py.com.sodep.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String nombre;
	
	private String apellido;
	
	private Integer age;
	
	@OneToMany
	@JoinTable(
			   name = "user_movies_watchlist", 
			   joinColumns = @JoinColumn(name = "user_id"), 
			   inverseJoinColumns = @JoinColumn(name = "movie_id")
			 )
	private List<Movie> watchList;
	
	public User() {
		
	}
	
	public User(String nombre, String appelido) {
		super();
		this.nombre = nombre;
		this.apellido = appelido;
	}
	
	public User(String username) {
		this.username = username;
	}

	public User(String username, String nombre, String apellido, int age) {
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Movie> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Movie> watchList) {
		this.watchList = watchList;
	}

	

}
