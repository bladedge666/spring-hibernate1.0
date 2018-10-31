package mvc.app.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.app.model.User;
/**
 * 
 * The DAO implementation classes should be the only ones that 
 * have hibernate code / queries
 * 
 * @author srzyl
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private static final Logger logger = Logger.getAnonymousLogger();

	
	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> listUsers() {
		// get users from the db
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createQuery("select * from users").list();

		return listUser;
	}
	
	
	@Transactional
	public void save(User user) {
		System.out.println("Going to save the user!");
		sessionFactory.getCurrentSession().persist(user);
//		System.out.println(">> User " + user.getUsername() + "saved to database successfully!!!");
		logger.info("User saved successfully, User Details=" + user);

	}

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Transactional
	public User findById(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(id));
		logger.info(">>> User loaded successfully, User details = " + user);
		return user;
	}

	@Transactional
	public void removeById(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(id));
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
		logger.info(">>> User deleted successfully, user details = " + user);
	}

	@Transactional
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
		logger.info(">>> User updated successfully, User Details=" + user);
	}

}
