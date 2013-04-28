package im.dadoo.teak.mvc.dao;

import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.util.Util;

import org.springframework.stereotype.Repository;

@Repository
public class PageDao extends BaseDao<Page> {
	
	public PageDao() {
		super(Page.class);
	}
	
	public void delete(Page page) {
		page.setState(Util.STATE_DELETE);
	}
}
