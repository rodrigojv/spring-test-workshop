package py.com.sodep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import py.com.sodep.entities.Movie;
import py.com.sodep.entities.User;
import py.com.sodep.enums.ContentRating;

public abstract class AbstractMockTest {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	protected List<User> testUsers() {
		return Arrays.asList(testUser());
	}

	protected User testUser() {
		User user = new User("clark", "Clark", "Kent", 33);
		List<Movie> movies = new ArrayList<>();
		movies.addAll(Arrays.asList(testMovie()));
		user.setWatchList(movies);
		return user;
	}

	private Movie testMovie() {
		return new Movie("Man of Steel", ContentRating.G);
	}

	protected String usersAsJson() throws JsonProcessingException {
		return mapToJson(testUsers());
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
	
	protected Object mapToObject(String contentAsString, Class<?> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(contentAsString, clazz);
	}

}