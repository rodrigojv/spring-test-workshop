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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@DataJpaTest
public class UserServiceIntegrationTest {

	// TODO Copiar propiedades de UserServiceTest
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		// TODO Instanciar userService
	}

	@Test
	public void findAllShouldReturnAllUsers() {
		// TODO Implementar
		Assert.fail();
	}

	@Test
	public void getUserShouldReturnUserWithUsername() {
		// TODO Implementar
		Assert.fail();
		
	}

	@Test
	public void getNotExistingUserShouldThrowException() {
		// TODO Implementar
		Assert.fail();
	}
	
	@Test
	public void addMovieToUserWatchListShouldReturnUserWithWatchList() {
		// TODO Implementar
		Assert.fail();
		
	}

	@Test
	public void addPG13MovieToUserUnder13ShouldThrowException() {
		// TODO Implementar
		Assert.fail();
	}
	
	
}
