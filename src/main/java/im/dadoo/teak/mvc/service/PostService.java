package im.dadoo.teak.mvc.service;

import java.util.ArrayList;
import java.util.List;

import im.dadoo.teak.mvc.dao.CategoryDao;
import im.dadoo.teak.mvc.dao.PostDao;
import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PostService {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void save(String title, String author, String html, String thumbnailPath, Integer categoryId) {
		Category category = this.categoryDao.fetchById(categoryId);
		Post post = Post.create(title, author, html, thumbnailPath, category);
		this.postDao.save(post);
	}
	
	public void save(Post post) {
		this.postDao.save(post);
	}

	public void update(Long id, String title, String author, String html, String thumbnailPath,
			Integer categoryId) {
		Post post = this.postDao.fetchById(id);
		Category category = this.categoryDao.fetchById(categoryId);
		
		post.setTitle(title);
		post.setAuthor(author);
		post.setHtml(html);
		post.setText(Util.parse(html));
		post.setThumbnailPath(thumbnailPath);
		post.setCategory(category);
		
		this.postDao.update(post);
		
	}
	
	public void update(Long id, String title, String author, String html, Integer categoryId) {
		Post post = this.postDao.fetchById(id);
		Category category = this.categoryDao.fetchById(categoryId);
		
		post.setTitle(title);
		post.setAuthor(author);
		post.setHtml(html);
		post.setText(Util.parse(html));
		post.setCategory(category);
		
		this.postDao.update(post);
		
	}
	
	public void update(Post post) {
		this.postDao.update(post);
	}
	
	public void deleteById(long id) {
		this.postDao.deleteById(id);
	}
	
	public List<Post> list() {
		return this.postDao.list();
	}
	
	public List<Post> list(Integer state) {
		return this.postDao.list(state);
	}
	
	public Post fetchById(Long id) {
		return this.postDao.fetchById(id);
	}
	
	public List<Post> listByCategoryId(Integer categoryId) {
		Category category = this.categoryDao.fetchById(categoryId);
		return new ArrayList<Post>(category.getPosts());
	}

	public Post visit(Long id) {
		Post post = this.postDao.fetchById(id);
		if (post != null && post.getState() == Util.STATE_NORMAL) {
			post.setClick(post.getClick() + 1);
			return post;
		}
		else {
			return null;
		}
	}
}
