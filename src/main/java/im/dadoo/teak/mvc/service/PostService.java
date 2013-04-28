package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.domain.Link;
import im.dadoo.teak.mvc.domain.Post;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private Dao dao;
	
	public Post insert(Post post) {
		return this.dao.insert(post);
	}
	
	public Post fetchById(long id) {
		return this.dao.fetch(Post.class, id);
	}
	
	public Post fetchByIdWithAll(long id) {
		Post post = this.dao.fetch(Post.class, id);
		this.dao.fetchLinks(post, "category");
		return post;
	}
	
	public int update(Post post) {
		return this.dao.update(post);
	}
	
	public void deleteById(long id) {
		this.dao.delete(Post.class, id);
	}
	
	public List<Post> list(int limit) {
		List<Post> list =  this.dao.query(Post.class, Cnd.where(null).desc("publishTime"));
		return this.limit(list, limit);
	}
	
	public List<Post> list() {
		return this.dao.query(Post.class, Cnd.where(null).desc("publishTime"));
	}
	
	public List<Post> listByCategoryId(int categoryId, int limit) {
		List<Post> list = this.dao.query(Post.class, Cnd.where("categoryId", "=", categoryId).desc("publishTime"));
		return this.limit(list, limit);
	}
	
	public List<Post> listByCategoryId(int categoryId) {
		return this.dao.query(Post.class, Cnd.where("categoryId", "=", categoryId).desc("publishTime"));
	}
	
	public List<Post> listWithAll(){
		List<Post> list = this.list();
		for (Post post : list) {
			post = this.dao.fetchLinks(post, "category");
		}
		return list;
	}
	
	public List<Post> listWithAll(int limit){
		List<Post> list = this.list(limit);
		for (Post post : list) {
			post = this.dao.fetchLinks(post, "category");
		}
		return list;
	}
	
	private List<Post> limit(List<Post> list, int limit) {
		if (list.size() > 10) {
			return list.subList(0, limit);
		}
		else {
			return list;
		}
	}
}
