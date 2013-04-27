package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.model.Page;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

	@Autowired
	private Dao dao;
	
	public Page insert(Page page) {
		return this.dao.insert(page);
	}
	
	public Page fetchById(long id) {
		return this.dao.fetch(Page.class, id);
	}
	
	public Page fetchByName(String name) {
		return this.dao.fetch(Page.class, name);
	}
	
	public int update(Page page) {
		return this.dao.update(page);
	}
	
	public void deleteById(long id) {
		this.dao.delete(Page.class, id);
	}
	
	public List<Page> list() {
		return this.dao.query(Page.class, null);
	}
}
