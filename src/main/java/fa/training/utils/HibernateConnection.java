package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;

public class HibernateConnection {
	private static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Candidate.class).addAnnotatedClass(Interview.class).addAnnotatedClass(EntryTest.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
}
