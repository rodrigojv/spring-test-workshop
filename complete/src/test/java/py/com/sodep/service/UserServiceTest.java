package py.com.sodep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;
import py.com.sodep.enums.ContentRating;
import py.com.sodep.exceptions.MovieAlreadyInWatchlistException;
import py.com.sodep.exceptions.UserNameNotFoundException;
import py.com.sodep.exceptions.UserNotAllowedToWatchException;
import py.com.sodep.repository.UserRepository;
import py.com.sodep.services.MovieService;
import py.com.sodep.services.UserService;
import py.com.sodep.services.UserServiceImpl;

public class UserServiceTest extends AbstractMockTest {

	@Mock
	private MovieService movieService;

	@Mock
	private UserRepository userRepo;

	private UserService userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.userService = new UserServiceImpl(userRepo, movieService);
	}

	@Test
	public void findAllShouldReturnAllUsers() {
		when(userRepo.findAll()).thenReturn(testUsers());

		List<User> users = userService.findAll();

		assertThat(users.size()).isEqualTo(1);
		assertThat(users.get(0).getUsername()).isEqualTo("clark");
	}

	@Test
	public void getUserShouldReturnUserWithUsername() {

		when(userRepo.findByUsername("clark")).thenReturn(testUser());

		User user = userService.getUser("clark");

		assertThat(user).isNotNull();
		assertThat(user.getUsername()).isEqualTo("clark");
	}

	@Test
	public void getNotExistingUserShouldThrowException() {

		when(userRepo.findByUsername("batman")).thenReturn(null);
		this.thrown.expect(UserNameNotFoundException.class);

		userService.getUser("batman");
	}
	
	@Test
	public void addMovieToUserWatchListShouldReturnUserWithWatchList() {
		Movie movie = new Movie("The notebook", ContentRating.PG);
		User user = testUser();
		
		when(userRepo.findByUsername("clark")).thenReturn(user);
		when(movieService.getByTitle("The notebook")).thenReturn(movie);
		when(userRepo.save(user)).thenReturn(user);
		
		//act
		User savedUser = userService.addToWatchList("clark", movie.getTitle());
		
		assertThat(savedUser.getWatchList().size()).isEqualTo(2);
		assertThat(savedUser.getWatchList().get(1).getTitle()).isEqualTo("The notebook");
		
	}

	@Test
	public void addPG13MovieToUserUnder13ShouldThrowException() {
		Movie movie = new Movie("Conjuro", ContentRating.PG_13);
		User user = testUser();
		user.setAge(8);
		
		when(userRepo.findByUsername("clark")).thenReturn(user);
		when(movieService.getByTitle("Conjuro")).thenReturn(movie);
		this.thrown.expect(UserNotAllowedToWatchException.class);
		
		//act
		userService.addToWatchList("clark", movie.getTitle());
		
	}
	
	@Test
	public void addMovieTwiceToUserWatchlistShouldThrowException() {
		Movie movie = new Movie("Man of Steel", ContentRating.G);
		User user = testUser();
		user.setWatchList(new ArrayList<>());
		
		when(userRepo.findByUsername("clark")).thenReturn(user);
		when(movieService.getByTitle("Man of Steel")).thenReturn(movie);
		this.thrown.expect(MovieAlreadyInWatchlistException.class);
		
		//act
		userService.addToWatchList("clark", movie.getTitle());
		
	    userService.addToWatchList("clark", movie.getTitle());
		
	}
	
}
