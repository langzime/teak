package im.dadoo.teak.mvc.dao;

import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.util.Util;

import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {

	public PostDao() {
		super(Post.class);
	}
	
	public void delete(Post post) {
		post.setState(Util.STATE_DELETE);
	}
	
}
