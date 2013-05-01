package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.dao.CategoryDao;
import im.dadoo.teak.mvc.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public void create(String name, String description, Integer supId) {
		Category sup = this.categoryDao.fetchById(supId);
		Category category = Category.create(name, description, sup);
		this.categoryDao.save(category);
	}
	
	public void save(Category category) {
		this.categoryDao.save(category);
	}
	
	public void update(Integer id, String name, String description, Integer supId) {
		Category category = this.fetchById(id);
		Category sup = this.fetchById(supId);
		category.setName(name);
		category.setDescription(description);
		category.setSup(sup);
		this.categoryDao.update(category);
	}
	
	public void update(Category category) {
		this.categoryDao.update(category);
	}
	
	public Category fetchById(Integer id) {
		return this.categoryDao.fetchById(id);
	}
	
	public Category fetchByName(String name) {
		return this.categoryDao.fetchByName(name);
	}
	
	public List<Category> list() {
		return this.categoryDao.list();
	}
	
	public List<Category> list(Integer state) {
		return this.categoryDao.list(state);
	}
	
	public void deleteById(Integer id) {
		this.categoryDao.deleteById(id);
	}
}
