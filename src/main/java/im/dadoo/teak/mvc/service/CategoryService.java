package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.dao.CategoryDao;
import im.dadoo.teak.mvc.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(Category category) {
		this.categoryDao.save(category);
	}
	
	public void update(Category category) {
		this.categoryDao.update(category);
	}
	
	public Category fetchById(Integer id) {
		return this.categoryDao.fetchById(id);
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
