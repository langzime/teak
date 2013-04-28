package im.dadoo.teak.mvc.domain;

public class User {

	private Integer id;
	private String name;
	private String password;
	private Long signinDatetime;
	private Integer state;

	public User() {}
	
	public static User create(String name, String password) {
		User user = new User();
		user.name = name;
		user.password = password;
		user.signinDatetime = System.currentTimeMillis();
		user.state = 0;
		return user;
	}

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSigninDatetime() {
		return signinDatetime;
	}

	public void setSigninDatetime(Long signinDatetime) {
		this.signinDatetime = signinDatetime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
