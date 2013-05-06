package im.dadoo.teak.mvc.service;

import im.dadoo.teak.mvc.dao.CategoryDao;
import im.dadoo.teak.mvc.dao.PageDao;
import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.util.Menu;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MenuService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PageDao pageDao;

	public Menu create() {
		Menu menu = new Menu();
		
		List<Category> categoryMenu = menu.getCategoryMenu();
		
		Category c1 = this.categoryDao.fetchByName("中心公告");
		categoryMenu.add(c1);
		
		Category c2 = this.categoryDao.fetchByName("学术活动");
		categoryMenu.add(c2);
		
		Category c3 = this.categoryDao.fetchByName("学术研究");
		categoryMenu.add(c3);
		
		Category c4 = this.categoryDao.fetchByName("图片新闻");
		categoryMenu.add(c4);
		
		List<Page> pageMenu = menu.getPageMenu();
		
		Page p1 = this.pageDao.fetchByName("中心介绍");
		
		pageMenu.add(p1);
		
		return menu;
		
	}
	
}
