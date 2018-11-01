package mvc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
@Transactional
public class UserDaoImpl implements IUserDao {
	private static final Logger logger = Logger.getAnonymousLogger();

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> listUsers() {
		// get users from the db
//		@SuppressWarnings("unchecked")
//		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createQuery("from users").list();
//		return listUser;
		
		
		/**
		 * The example below uses jdbcTemplate. However, the same effect can be obtained using Hibernate queries
		 */
		return jdbcTemplate.query("select * from users", new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("user_id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				
				return u;
			}
		});

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
//		User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(id));
		User user = jdbcTemplate.queryForObject("select * from users where user_id=?", new Object[] {id}, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				return user;
			}
		});
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
