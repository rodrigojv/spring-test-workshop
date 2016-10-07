package py.com.sodep.services;

import java.util.List;

import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;

public interface UserService {

	List<User> findAll();

	void addToWatchList(String username, String movieTitle);
	
	List<Movie> getWatchList(String username);

	User getUser(String username);
}
