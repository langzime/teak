package im.dadoo.teak.mvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {

	private Class<T> c;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BaseDao() {
		Type type = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)type).getActualTypeArguments();
		this.c = (Class)params[0];
	}
	
	public void save(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(obj);
//		Session session = this.sessionFactory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.save(obj);
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw e;
//		} finally {
//			session.close();
//		}
	}
	
	public void update(T obj) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void delete(T obj) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public T fetchById(Serializable id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			T obj = (T) session.get(this.c, id);
			tx.commit();
			return obj;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public List<T> list() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<T> objs = session.createCriteria(this.c).list();
			tx.commit();
			return objs;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public List<T> listByState(Integer state) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<T> objs = session.createCriteria(this.c)
					.add(Restrictions.eq("state", state))
					.list();
			tx.commit();
			return objs;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}
