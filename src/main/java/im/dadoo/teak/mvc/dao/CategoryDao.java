package im.dadoo.teak.mvc.dao;

import java.util.List;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.util.Util;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> {

	public CategoryDao() {
		super(Category.class);
	}
	
	public Category fetchByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Category) session.createCriteria(Category.class)
			.add(Restrictions.like("name", name))
			.uniqueResult();
	}
	
	public void delete(Category category) {
		category.setState(Util.STATE_DELETE);
		for (Category sub : category.getSubs()) {
			sub.setState(Util.STATE_DELETE);
		}
	}
	
	public List<Category> listWithoutSup(Integer state) {
		Session session = this.sessionFactory.getCurrentSession();
		if (state == null) {
			return session.createCriteria(Category.class).add(Restrictions.isNull("sup")).list();
		}
		else {
			return session.createCriteria(Category.class)
					.add(Restrictions.isNull("sup"))
					.add(Restrictions.eq("state", state))
					.list();
		}
	}
}
