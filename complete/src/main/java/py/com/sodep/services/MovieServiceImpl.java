package py.com.sodep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import py.com.sodep.entities.Movie;
import py.com.sodep.exceptions.MovieNotFoundException;
import py.com.sodep.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepo;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	
	@Override
	public Movie getByTitle(String title) {
		Assert.notNull(title, "Title must not be null");
		Movie movie = this.movieRepo.findByTitle(title);
		if (movie == null) {
			throw new MovieNotFoundException(title);
		}
		return movie;
	}

}
