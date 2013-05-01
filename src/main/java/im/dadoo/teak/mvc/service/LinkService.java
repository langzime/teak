package im.dadoo.teak.mvc.service;

import java.util.List;

import im.dadoo.teak.mvc.dao.LinkDao;
import im.dadoo.teak.mvc.domain.Link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class LinkService {

	@Autowired
	private LinkDao linkDao;
	
	public void save(String name, String url, String description) {
		Link link = Link.create(name, url, description);
		this.linkDao.save(link);
	}
	public void save(Link link) {
		this.linkDao.save(link);
	}
	
	public void update(Integer id, String name, String url, String description) {
		Link link = this.linkDao.fetchById(id);
		link.setName(name);
		link.setUrl(url);
		link.setDescription(description);
		this.linkDao.update(link);
	}
	
	public void update(Link link) {
		this.linkDao.update(link);
	}
	
	public Link fetchById(Integer id) {
		return this.linkDao.fetchById(id);
	}
	
	public void deleteById(Integer id) {
		this.linkDao.deleteById(id);
	}
	
	public List<Link> list() {
		return this.linkDao.list();
	}

}
