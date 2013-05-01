package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.dao.PageDao;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PageService {

	@Autowired
	private PageDao pageDao;
	
	public void save(String name, String title, String author, String html) {
		Page page = Page.create(name, title, author, html);
		this.pageDao.save(page);
	}
	
	public void save(Page page) {
		this.pageDao.save(page);
	}
	
	public Page fetchById(Long id) {
		return this.pageDao.fetchById(id);
	}
	
	public Page fetchByName(String name) {
		return this.pageDao.fetchByName(name);
	}
	
	public void update(Long id, String name, String title, String author, String html) {
		Page page = this.pageDao.fetchById(id);
		page.setName(name);
		page.setTitle(title);
		page.setAuthor(author);
		page.setHtml(html);
		page.setText(Util.parse(html));
		
		this.pageDao.update(page);
	}
	
	public void update(Page page) {
		this.pageDao.update(page);
	}
	
	public void deleteById(Long id) {
		this.pageDao.deleteById(id);
	}
	
	public List<Page> list() {
		return this.pageDao.list();
	}
	
	public List<Page> list(Integer state) {
		return this.pageDao.list(state);
	}
	
	public Page visit(Long id) {
		Page page = this.pageDao.fetchById(id);
		if (page != null && page.getState() == Util.STATE_NORMAL) {
			page.setClick(page.getClick() + 1);
			return page;
		}
		else {
			return null;
		}
	}
}
