package im.dadoo.teak.mvc.service;

import im.dadoo.teak.mvc.dao.UserDao;
import im.dadoo.teak.mvc.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void update(User user) {
		this.userDao.update(user);
	}
	
	public User fetchById(Integer id) {
		return this.userDao.fetchById(id);
	}
	
	public User fetchByName(String name) {
		return this.userDao.fetchByName(name);
	}
	
	public boolean signin(String name, String password) {
		User user = this.userDao.fetchByName(name);
		return user.getPassword().equals(password);
	}
}
