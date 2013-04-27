package im.dadoo.teak.mvc.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_user")
public class User {

	@Id
	private int id;
	
	@Name
	private String username;
	
	@Column
	private String password;
	
	@Column
	private long signinDateTime;

	
	public User() {}
	
	public User(String username, String password, long signinDateTime) {
		this.username = username;
		this.password = password;
		this.signinDateTime = signinDateTime;
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
	
	public long getSigninDateTime() {
		return signinDateTime;
	}

	public void setSigninDateTime(long signinDateTime) {
		this.signinDateTime = signinDateTime;
	}
}
