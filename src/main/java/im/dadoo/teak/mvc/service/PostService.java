package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.model.Link;
import im.dadoo.teak.mvc.model.Post;

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
	
	public List<Post> list() {
		return this.dao.query(Post.class, null);
	}
	
	public List<Post> listWithAll(){
		List<Post> list = this.list();
		for (Post post : list) {
			post = this.dao.fetchLinks(post, "category");
		}
		return list;
	}
}
