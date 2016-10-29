package py.com.sodep.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import py.com.sodep.Application;
import py.com.sodep.entities.Movie;
import py.com.sodep.enums.ContentRating;
import py.com.sodep.exceptions.MovieNotFoundException;
import py.com.sodep.repository.MovieRepository;
import py.com.sodep.services.MovieService;
import py.com.sodep.services.MovieServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MovieServiceIntegrationTest {

	private MovieService movieService;
	
	@Autowired
	private MovieRepository repo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		this.movieService = new MovieServiceImpl(repo);
	}
	
	@Test
	public void getMovieByTitleShouldReturnMovieAndRating() {
		Movie movie = movieService.getByTitle("Man of Steel Test");
		assertThat(movie).isNotNull();
		assertThat(movie.getTitle()).isEqualTo("Man of Steel Test");
		assertThat(movie.getRating()).isEqualTo(ContentRating.G);
	}
	
	
	@Test
	public void getNotExistingMovieShouldThrowException() {
		// TODO Implementar
		// Copiar de MovieServiceTest
		Assert.fail();
	}
	
}
