package mvc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author srzyl
 *
 */
@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
	@Column(name="username")
	private String username;
	
//	@Column(name="password") not needed if same name
    private String password;
	
	@Column(name="email")
    private String email;
 
    // getters and setters are removed for brevity
    public User() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
    
    
}