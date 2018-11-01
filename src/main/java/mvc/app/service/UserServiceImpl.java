package mvc.app.service;

import java.util.List;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.app.dao.IUserDao;
import mvc.app.model.User;
/**
 * 
 * The service implementation class is an abstraction over the dao classes
 * have hibernate code / queries
 * 
 * @author srzyl
 *
 */

@Service("userService")
public class UserServiceImpl implements IUserService{

	private IUserDao userDao;

	/**
	 * 
	 * Can use setUserDao for Dependency injection (via autowiring) too
	 * @param userDao
	 */
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	/**
	 * 
	 * Why use @Transactinoal in the Service layer?
	 * Ans: Multiple Daos might be used in this layer. So, to prevent inconsistency
	 * https://stackoverflow.com/questions/3886909/where-should-transactional-be-place-service-layer-or-dao
	 */
	
	
	@Transactional
	public List<User> listUsers() {
		return userDao.listUsers();
	}
	
	
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Transactional
	public void removeById(int id) {
		userDao.removeById(id);
	}

	@Transactional
	public void update(User user) {
		userDao.update(user);
	}

}
