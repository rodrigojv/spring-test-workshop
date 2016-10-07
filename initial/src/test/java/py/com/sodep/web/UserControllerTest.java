package py.com.sodep.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import py.com.sodep.AbstractMockTest;
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
    public void requestingAllUsersShouldReturnArrayAndStatusOk() throws Exception {
    	// TODO Implementar
    	// Hacer un mock usando testUsers()
    	// Controlar content.json igual a testUsers
    	Assert.fail();
    }
    
    @Test
    public void requestingNotExistingUserShouldReturnNotFound() throws Exception {
    	// TODO Implementar
    	// Hacer un mock con excepcion
    	// Controlar respuesta json igual a RestResponse
    	Assert.fail();
    }
    
    @Test
    public void requestingUserByUsernameShouldReturnJsonWithUser() throws Exception {
    	// TODO Implementar
    	// Usar testUser() para el mock
    	Assert.fail();
    }
    
    
}
