package im.dadoo.teak.mvc.dao;

import im.dadoo.teak.mvc.domain.User;
import im.dadoo.teak.util.Util;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User>{

	public UserDao() {
		super(User.class);
	}
	
	@Override
	public void delete(User user) {
		user.setState(1);
	}
	
	public User fetchByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.createCriteria(User.class)
			.add(Restrictions.like("name", name))
			.add(Restrictions.eq("state", Util.STATE_NORMAL))
			.uniqueResult();
	}
}
