package py.com.sodep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import py.com.sodep.entities.Movie;
import py.com.sodep.enums.ContentRating;
import py.com.sodep.exceptions.MovieNotFoundException;
import py.com.sodep.repository.MovieRepository;
import py.com.sodep.services.MovieService;
import py.com.sodep.services.MovieServiceImpl;

public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepo;
	
	private MovieService movieService;

	private Movie testMovie;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testMovie = new Movie("Man of Steel Mock", ContentRating.G);
		movieService = new MovieServiceImpl(movieRepo);
	}
	
	@Test
	public void getMovieByTitleShouldReturnMovieAndRating() {
		// Arrange
		when(movieRepo.findByTitle("Man of Steel Mock")).thenReturn(testMovie);
		
		// Act
		Movie movie = movieService.getByTitle("Man of Steel Mock");
		
		// Assert
		assertThat(movie.getTitle()).isEqualTo("Man of Steel Mock");
		assertThat(movie.getRating()).isEqualTo(ContentRating.G);
	}
	
	@Test
	public void getNotExistingMovieShouldThrowException() {
		when(movieRepo.findByTitle("Pocahontas")).thenReturn(null);
		this.thrown.expect(MovieNotFoundException.class);
		this.thrown.expectMessage("Movie with title Pocahontas not found");
		
		movieService.getByTitle("Pocahontas");
	}
}
