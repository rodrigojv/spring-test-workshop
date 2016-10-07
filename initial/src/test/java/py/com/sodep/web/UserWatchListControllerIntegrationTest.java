package py.com.sodep.web;

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
		// TODO Implementar
		// Hacer request para agregar pelicula a un user
		// Obtener el resultado de la peticion
		// Obtener el watchlist del usuario y comparar con el resultado de la primera peticion
		Assert.fail();
	}
}
