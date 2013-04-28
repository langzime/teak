package im.dadoo.teak.mvc.service;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.util.Menu;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
	
	private Menu menu;
	
	@Autowired
	private CategoryService cs;
	
	@Autowired
	private PageService pas;

	@PostConstruct
	public void init() {
		this.menu = new Menu();
		
		List<Category> categoryMenu = this.menu.getCategoryMenu();
		
		Category c1 = this.cs.fetchByUrlWithSubs("notice");
		categoryMenu.add(c1);
		
		Category c2 = this.cs.fetchByUrlWithSubs("activity");
		categoryMenu.add(c2);
		
		Category c3 = this.cs.fetchByUrlWithSubs("research");
		categoryMenu.add(c3);
		
		List<Page> pageMenu = this.menu.getPageMenu();
		
		Page p1 = this.pas.fetchByName("introduction");
		pageMenu.add(p1);
		
	}
	
	public void refresh() {
		List<Category> categoryMenu = this.menu.getCategoryMenu();
		for (Category c : categoryMenu) {
			c = this.cs.fetchByIdWithSubs(c.getId());
		}
		
		List<Page> pageMenu = this.menu.getPageMenu();
		for (Page p : pageMenu) {
			p = this.pas.fetchById(p.getId());
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
