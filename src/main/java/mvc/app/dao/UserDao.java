package mvc.app.dao;

import java.util.List;

import mvc.app.model.User;

public interface UserDao {

	public List<User> listUsers();
	public void save(User user); //Post
	public User findById(int id); // GET
	public void update(User user);
	public void removeById(int id);
}
