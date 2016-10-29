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

package py.com.sodep.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import py.com.sodep.Application;
import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;
import py.com.sodep.enums.ContentRating;
import py.com.sodep.exceptions.MovieAlreadyInWatchlistException;
import py.com.sodep.exceptions.UserNameNotFoundException;
import py.com.sodep.exceptions.UserNotAllowedToWatchException;
import py.com.sodep.repository.MovieRepository;
import py.com.sodep.repository.UserRepository;
import py.com.sodep.services.MovieService;
import py.com.sodep.services.MovieServiceImpl;
import py.com.sodep.services.UserService;
import py.com.sodep.services.UserServiceImpl;

/**
 * Tests for {@link UserService}.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class UserServiceIntegrationTest {

	// TODO Copiar propiedades de UserServiceTest
	@Autowired
	private UserService userService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
	}

	@Test
	public void findAllShouldReturnAllUsers() {
		List<User> users = userService.findAll();
		assertThat(users).isNotEmpty();
		assertThat(users).filteredOn(u -> u.getUsername().equals("clarktest")).hasSize(1);
	}

	@Test
	public void getUserShouldReturnUserWithUsername() {
		User user = userService.getUser("clarktest");
		assertThat(user).isNotNull();
		assertThat(user).isEqualToComparingOnlyGivenFields(new User("clarktest"), "username");
	}

	@Test
	public void getNotExistingUserShouldThrowException() {
		thrown.expect(UserNameNotFoundException.class);
		thrown.expectMessage("User with username batman does not exist");
		userService.getUser("batman");
	}
	
	@Test
	public void addMovieToUserWatchListShouldReturnUserWithWatchList() {
		User user = userService.addToWatchList("clarktest", "Man of Steel Test");
		assertThat(user.getWatchList()).isNotEmpty();
		assertThat(user.getWatchList()).hasSize(1);
	}

	@Test
	public void addPG13MovieToUserUnder13ShouldThrowException() {
		thrown.expect(UserNotAllowedToWatchException.class);
		thrown.expectMessage("User with age " + 8 + ", are not allowed to watch movies with rating " + ContentRating.PG_13);
		userService.addToWatchList("kevintest", "Conjuro Test");
	}
	
	
}
