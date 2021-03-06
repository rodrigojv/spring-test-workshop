package py.com.sodep.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
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
		// Arrange
		MvcResult andReturn = mvc.perform(post("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON).content("Man of Steel"))
		.andDo(print())
		.andReturn();
		
		User user = (User) mapToObject(andReturn.getResponse().getContentAsString(), User.class);
		
		mvc.perform(get("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(content().json(mapToJson(user.getWatchList())));
	}


	@Test
	public void requestingAddingPG13RatedMovieToUserUnder13ShouldReturnError() throws Exception {
		
		mvc.perform(post("/users/kevin/watchlist").accept(MediaType.APPLICATION_JSON).content("Conjuro"))
			.andDo(print())
			.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void requestingAddMovieToWatchListShouldReturnAccepted() throws Exception {
		
		mvc.perform(post("/users/clark/watchlist").accept(MediaType.APPLICATION_JSON).content("Man of Steel"))
			.andDo(print())
			.andExpect(status().isAccepted());
	}

}
