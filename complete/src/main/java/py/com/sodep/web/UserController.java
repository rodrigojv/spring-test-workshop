package py.com.sodep.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import py.com.sodep.entities.User;
import py.com.sodep.exceptions.UserNameNotFoundException;
import py.com.sodep.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestResponse handleUserNotFound(UserNameNotFoundException ex) {
		return new RestResponse(false, ex.getMessage());
	}
	
}
