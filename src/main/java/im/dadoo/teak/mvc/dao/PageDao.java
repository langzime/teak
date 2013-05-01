package im.dadoo.teak.mvc.dao;

import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.mvc.domain.User;
import im.dadoo.teak.util.Util;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PageDao extends BaseDao<Page> {
	
	public PageDao() {
		super(Page.class);
	}
	
	public void delete(Page page) {
		page.setState(Util.STATE_DELETE);
	}
	
	public Page fetchByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Page) session.createCriteria(Page.class)
			.add(Restrictions.like("name", name))
			.uniqueResult();
	}
}
