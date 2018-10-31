package mvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.app.model.User;
import mvc.app.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * It is better to autowire a setter
	 * e.g
	 * <code>
	 * @Autowired
	 * public IUserService setUserService(IUserService userService) {
	 * 
	 * }
	 * </code>
	 */
	//Field level
	@Autowired
	private UserService userService;
	/*
	@Autowired
	public void setIUserService(IUserService userService) {
		this.userService = userService;
	}
	*/
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "Hello There";
	}
	
	@RequestMapping("/users") // display all users
	public @ResponseBody String listAllUsers(Model model) {
		List<User> users = userService.listUsers();
		return users.toString();
	}
	
	@RequestMapping("/user/{id}")
	public @ResponseBody String viewUser(@PathVariable("id") int id) {
		return userService.findById(id).toString();
	}
}
