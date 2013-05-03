package im.dadoo.teak.mvc.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<T> {

	private Class<T> c;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public BaseDao(Class<T> c) {
		this.c = c;
	}
	
	public void save(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(obj);
	}
	
	public void update(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(obj);
	}
	
	public void delete(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(obj);
	}
	
	public void deleteById(Serializable id) {
		this.delete(this.fetchById(id));
	}
	
	public T fetchById(Serializable id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (T) session.get(this.c, id);
	}
	
	public List<T> list() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(this.c).list();
	}
	
	public List<T> list(Integer state) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createCriteria(this.c)	
									.add(Restrictions.eq("state", state))
									.list();
	}
	
}
