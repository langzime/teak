package im.dadoo.teak.mvc.service;

import java.util.List;

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
