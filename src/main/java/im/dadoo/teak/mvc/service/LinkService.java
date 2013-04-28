package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.domain.Link;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

	@Autowired
	private Dao dao;
	
	public Link insert(Link link) {
		return this.dao.insert(link);
	}
	
	public Link fetchById(int id) {
		return this.dao.fetch(Link.class, id);
	}
	
	public void deleteById(int id) {
		this.dao.delete(Link.class, id);
	}
	
	public List<Link> list() {
		return this.dao.query(Link.class, null);
	}
	
	public int update(Link link) {
		return this.dao.update(link);
	}
}
