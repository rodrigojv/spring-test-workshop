package py.com.sodep.services;

import py.com.sodep.entities.Movie;

public interface MovieService {

	Movie getByTitle(String movieTitle);

}
