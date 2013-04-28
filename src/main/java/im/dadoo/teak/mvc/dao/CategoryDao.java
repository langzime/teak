package im.dadoo.teak.mvc.dao;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.util.Util;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> {

	public CategoryDao() {
		super(Category.class);
	}
	
	public void delete(Category category) {
		category.setState(Util.STATE_DELETE);
		for (Category sub : category.getSubs()) {
			sub.setState(Util.STATE_DELETE);
		}
	}
}
