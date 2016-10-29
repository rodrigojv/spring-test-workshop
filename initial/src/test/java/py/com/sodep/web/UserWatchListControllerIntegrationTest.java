package py.com.sodep.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.Application;
import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;
import py.com.sodep.exceptions.MovieAlreadyInWatchlistException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class UserWatchListControllerIntegrationTest extends AbstractMockTest {
	
	protected MockMvc mvc;

	@Autowired
	private WebApplicationContext webContext;
	
	@Before
    public void setUp() {
    	mvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void requestingUserWatchListShouldReturnJsonArray() throws Exception {
		// TODO Implementar
		// Hacer request para agregar pelicula a un user
		// Obtener el resultado de la peticion
		// Obtener el watchlist del usuario y comparar con el resultado de la primera peticion
		Assert.fail();
	}
	
	@Test
	public void requestingAddMovieTwiceShouldReturnError() throws Exception {
		User user = testUser();
		Movie testMovie = testMovie();
		
		mvc.perform(post("/users/clarktest/watchlist").accept(MediaType.APPLICATION_JSON).content("Man of Steel Test"))
		.andDo(print())
		.andReturn();
		
		
		mvc.perform(post("/users/clarktest/watchlist").accept(MediaType.APPLICATION_JSON).content("Man of Steel Test"))
		.andDo(print())
		.andExpect(status().isUnprocessableEntity());
		
		
	}
}
