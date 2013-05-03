package im.dadoo.teak.mvc.dao;

import java.io.Serializable;
import java.util.List;

import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.util.Util;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {

	public PostDao() {
		super(Post.class);
	}
	
	@Override
	public void delete(Post post) {
		post.setState(Util.STATE_DELETE);
	}
	
	@Override
	public List<Post> list() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(Post.class)
				.addOrder(Order.desc("id")).list();
	}
	
	@Override
	public List<Post> list(Integer state) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(Post.class)
									.addOrder(Order.desc("id"))
									.add(Restrictions.eq("state", state))
									.list();
	}
}
