package py.com.sodep.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import py.com.sodep.AbstractMockTest;
import py.com.sodep.entities.User;
import py.com.sodep.exceptions.UserNameNotFoundException;
import py.com.sodep.services.UserService;

public class UserControllerTest extends AbstractMockTest {
	
	protected MockMvc mvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;
	
	@Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
    	mvc = MockMvcBuilders.standaloneSetup(this.userController).build();
	}
    
    @Test
    public void getAllUsersShouldReturnJsonArrayAndStatusOk() throws Exception {
    	List<User> testUsers = testUsers();
    	when(userService.findAll()).thenReturn(testUsers);
    	
    	mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
    	.andDo(print())
    	.andExpect(status().isOk())
    	.andExpect(content().json(mapToJson(testUsers)));
    }
    
    @Test
    public void getUserWhenRequestingShouldReturnJsonWithUser() throws Exception {
    	User user = testUser();
    	when(userService.getUser(user.getUsername())).thenReturn(user);
    	
    	mvc.perform(get("/users/clark").accept(MediaType.APPLICATION_JSON))
    	.andDo(print())
    	.andExpect(status().isOk())
    	.andExpect(content().json(mapToJson(user)));
    }
    
    @Test
    public void getNotExistingUserWhenRequestingShouldReturnNotFound() throws Exception {
    	UserNameNotFoundException ex = new UserNameNotFoundException("batman");
    	when(userService.getUser("batman")).thenThrow(ex);
    	
    	mvc.perform(get("/users/batman").accept(MediaType.APPLICATION_JSON))
    	.andDo(print())
    	.andExpect(status().isNotFound())
    	.andExpect(content().json(mapToJson(new RestResponse(false, ex.getMessage()))));
    }
}
