package py.com.sodep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Assert;
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

	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Before
	public void setup() {
		// Crea las implementaciones de interfaces anotadas con @Mock
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getMovieByTitleShouldReturnMovieAndRating() {
		// TODO Implementar
		Assert.fail();
	}
	
	@Test
	public void getNotExistingMovieShouldThrowException() {
		// TODO Implementar
		Assert.fail();
	}
}
