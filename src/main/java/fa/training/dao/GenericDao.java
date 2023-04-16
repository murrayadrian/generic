package fa.training.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import fa.training.entities.Candidate;
import fa.training.utils.HibernateConnection;

public abstract class GenericDao<T extends Object> implements Dao<T>{
	Class<T> generic;
	Candidate candidate = new Candidate();
	public GenericDao(Class<T> generic) {
		this.generic = generic;
	}
	private Session session = HibernateConnection.getSessionFactory().openSession();
	
	@Override
	public void save(T t) {
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	@Override
	public T getById(int id) {
		System.out.println("get id");
		return session.find(generic, id);
	}

	@Override
	public List<T> getAll() {
		String str = String.format("from %s", generic);
		Query<T> query = session.createQuery(str,generic);
		List<T> lists = query.getResultList();
		return lists;
	}

	@Override
	public T updateById(int id) {
		session.beginTransaction();
		T t = session.find(generic, id);
		update(t);
		session.save(t);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return t;
	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		T t = session.find(generic, id);
		session.delete(t);
		session.getTransaction().commit();
	}
	public abstract T update(T t);
}
