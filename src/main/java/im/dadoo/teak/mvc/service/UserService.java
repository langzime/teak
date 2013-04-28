package im.dadoo.teak.mvc.service;

import im.dadoo.teak.mvc.domain.User;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private Dao dao;
	
	public int update(User user) {
		return this.dao.update(user);
	}
	
	public User fetchById(int id) {
		return this.dao.fetch(User.class, id);
	}
	
	public User fetchByUsername(String username) {
		return this.dao.fetch(User.class, username);
	}
}
