/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package py.com.sodep.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;
import py.com.sodep.exceptions.MovieAlreadyInWatchlistException;
import py.com.sodep.exceptions.UserNotAllowedToWatchException;
import py.com.sodep.services.UserService;

public class UserWatchListControllerTest extends AbstractMockTest {
	
	protected MockMvc mvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserWatchListController controller;
	
	@Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }
	
	@Test
	public void requestingAddPG13MovieToUserUnder13ShouldReturnError() throws Exception {
		// TODO Implementar
		// Usar testUser() para el mock y ponerle una edad menor a 13
		// Usar post().content() para pasarle el titulo de la pelicula
		User user = testUser();
		user.setAge(8);
		Movie testMovie = testMovie();
		UserNotAllowedToWatchException expectedException = new UserNotAllowedToWatchException(user.getAge(), testMovie.getRating().name());
		RestResponse expectedResponse = new RestResponse(false, expectedException.getMessage());
		
		when(userService.addToWatchList(user.getUsername(), testMovie.getTitle())).thenThrow(expectedException);
		
		mvc.perform(
				post("/users/" + user.getUsername() + "/watchlist")
				.accept(MediaType.APPLICATION_JSON)
				.content(testMovie.getTitle())
				)
			.andDo(print())
			.andExpect(status().isUnprocessableEntity());
			//.andExpect(content().json(mapToJson(new RestResponse(false, testMovie.getTitle()))));
			
	}
	
	@Test
	public void requestingAddMovieToWatchListShouldReturnAccepted() throws Exception {
		// TODO Implementar
		// User testUser() para el mock
		// Preguntar por status ACCEPTED
		Assert.fail();
	}
	
	@Test
	public void requestingAddMovieTwiceShouldReturnError() throws Exception {
		User user = testUser();
		Movie testMovie = testMovie();
		when(userService.addToWatchList(user.getUsername(), testMovie.getTitle())).thenThrow(new MovieAlreadyInWatchlistException(user.getUsername(), testMovie.getTitle()));
		
		mvc.perform(post("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON).content(testMovie.getTitle()))
		.andDo(print())
		.andExpect(status().isUnprocessableEntity());
		
		
	}
	
	
	

}
