package im.dadoo.teak.mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Post;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private Dao dao;
	
	@Autowired
	private PostService pos;
	
	public int insert(Category c) {
		this.dao.insert(c);
		return c.getId();
	}
	
	public int update(Category c) {
		return this.dao.update(c);
	}
	
	public Category fetchById(int id) {
		return this.dao.fetch(Category.class, id);
	}
	
	public Category fetchByUrlWithSubs(String url) {
		Category c = this.dao.fetch(Category.class, url);
		this.dao.fetchLinks(c, "subCategories");
		return c;
	}
	
	public Category fetchByUrlWithAll(String url) {
		Category c = this.dao.fetch(Category.class, url);
		this.dao.fetchLinks(c, "subCategories");
		c.setPosts(this.pos.listByCategoryId(c.getId()));
		return c;
	}
	
	public Category fetchByUrlWithAll(String url, int limit) {
		Category c = this.dao.fetch(Category.class, url);
		this.dao.fetchLinks(c, "subCategories");
		c.setPosts(this.pos.listByCategoryId(c.getId(), limit));
		return c;
	}
	
	public Category fetchByUrl(String url) {
		return this.dao.fetch(Category.class, url);
	}
	
	public Category fetchByIdWithSubs(int id) {
		Category c = this.dao.fetch(Category.class, id);
		this.dao.fetchLinks(c, "subCategories");
		return c;
	}
	
	public Category fetchByIdWithAll(int id) {
		Category c = this.dao.fetch(Category.class, id);
		this.dao.fetchLinks(c, "subCategories");
		c.setPosts(this.pos.listByCategoryId(id));
		return c;
	}
	
	public Category fetchByIdWithAll(int id, int limit) {
		Category c = this.dao.fetch(Category.class, id);
		this.dao.fetchLinks(c, "subCategories");
		c.setPosts(this.pos.listByCategoryId(id, limit));
		return c;
	}
	
	public List<Category> list() {
		return this.dao.query(Category.class, null);
	}
	
	public List<Category> listWithSubCategories() {
		List<Category> categories = this.list();
		for (Category c : categories) {
			this.dao.fetchLinks(c, "subCategories");
		}
		return categories;
	}
	
	public List<Category> listWithAll() {
		List<Category> categories = this.list();
		for (Category c : categories) {
			c.setPosts(this.pos.listByCategoryId(c.getId()));
			this.dao.fetchLinks(c, "subCategories");
		}
		return categories;
	}
	
	public List<Category> treeWithSubCategories() {
		List<Category> categories = this.list();
		for (Category c : categories) {
			this.dao.fetchLinks(c, "subCategories");
		}
		//只留顶层的类别
		List<Category> result = new ArrayList<Category>();
		for (Category c : categories) {
			if (c.getSupId() == 0) {
				result.add(c);
			}
		}
		return result;
	}
	
	public List<Category> treeWithAll() {
		List<Category> categories = this.list();
		for (Category c : categories) {
			c.setPosts(this.pos.listByCategoryId(c.getId()));
			this.dao.fetchLinks(c, "subCategories");
		}
		//只留顶层的类别
		List<Category> result = new ArrayList<Category>();
		for (Category c : categories) {
			if (c.getSupId() == 0) {
				result.add(c);
			}
		}
		return result;
	}
	
	//会删除该类别下的所有文章，慎用
	public void deleteById(int id) {
		this.dao.clear(Post.class, Cnd.where("categoryId", "=", id));
		this.dao.delete(Category.class, id);
	}
}
