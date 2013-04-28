package im.dadoo.teak.mvc.dao;

import java.util.List;

import im.dadoo.teak.mvc.domain.Link;

import org.springframework.stereotype.Repository;

@Repository
public class LinkDao extends BaseDao<Link> {

	public LinkDao() {
		super(Link.class);
	}

	@Override
	public List<Link> list(Integer state) {
		throw new UnsupportedOperationException();
	}
}
