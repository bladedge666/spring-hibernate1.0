package mvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.app.model.User;
import mvc.app.service.IUserService;

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
	private IUserService userService;
	/*
	@Autowired
	public void setIUserService(IUserService userService) {
		this.userService = userService;
	}
	*/
	
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping("/users") // display all users
	public String listAllUsers(Model model) {
		List<User> users = userService.listUsers();
		model.addAttribute("users", users);
		System.out.println(">>> Extracted the following users: " + users);
		return "/users";
	}
	
	@RequestMapping("/user/{id}")
	public @ResponseBody String viewUser(@PathVariable("id") int id) {
		System.out.println(">>> Id from view: " + id);
		return userService.findById(id).toString();
	}
	
	@RequestMapping(value="/user/{id}/delete", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		System.out.println(">>>Delete request for user with id: " + id);
		
		userService.removeById(id);
		return "redirect:/users";
	}
	
}
