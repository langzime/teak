package im.dadoo.teak.util;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.model.Page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

public class Menu {

	private List<Category> categoryMenu;
	
	private List<Page> pageMenu;

	public Menu() {
		this.categoryMenu = new ArrayList<Category>();
		this.pageMenu = new ArrayList<Page>();
	}
	
	public List<Category> getCategoryMenu() {
		return categoryMenu;
	}

	public void setCategoryMenu(List<Category> categoryMenu) {
		this.categoryMenu = categoryMenu;
	}

	public List<Page> getPageMenu() {
		return pageMenu;
	}

	public void setPageMenu(List<Page> pageMenu) {
		this.pageMenu = pageMenu;
	}

}
