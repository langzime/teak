package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.model.Link;

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
	
	public void deleteById(int id) {
		this.dao.delete(Link.class, id);
	}
	
	public List<Link> list() {
		return this.dao.query(Link.class, null);
	}
}
