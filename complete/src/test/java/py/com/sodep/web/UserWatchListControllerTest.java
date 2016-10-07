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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.entities.User;
import py.com.sodep.enums.ContentRating;
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
		User user = this.testUser();
		user.setAge(8);
		when(userService.addToWatchList("clark", "Conjuro")).thenThrow(new UserNotAllowedToWatchException(8, ContentRating.PG_13.value()));
		
		mvc.perform(post("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON).content("Conjuro"))
			.andDo(print())
			.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void requestingAddMovieToWatchListShouldReturnAccepted() throws Exception {
		User user = this.testUser();
		when(userService.addToWatchList("clark", "Man of Steel")).thenReturn(user);
		
		mvc.perform(post("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON).content("Man of Steel"))
			.andDo(print())
			.andExpect(status().isAccepted());
	}
	
	@Test
	public void requestingUserWatchListShouldReturnJsonArray() throws Exception {
		User user = this.testUser();
		when(userService.getWatchList("clark")).thenReturn(user.getWatchList());
		
		mvc.perform(get("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(content().json(mapToJson(user.getWatchList())));
	}
	
	
	

}
