package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.Interview;
import fa.training.utils.HibernateConnection;

public class InterviewDao implements Dao<Interview>{
	
	private Session session = HibernateConnection.getSessionFactory().openSession();
	private List<Interview> interviewList = new ArrayList<>();
	
	public InterviewDao() {
		interviewList.add(new Interview(LocalDate.parse("2020-10-01"),"pass"));
		interviewList.add(new Interview(LocalDate.parse("2022-10-15"),"pass"));
		interviewList.add(new Interview(LocalDate.parse("2020-10-01"),"fail"));
		interviewList.add(new Interview(LocalDate.parse("2022-09-15"),"fail"));
	}
	@Override
	public void save(Interview interview) {
		session.beginTransaction();
		session.save(interview);
		session.getTransaction().commit();
	}

	@Override
	public Interview getById(int id) {
		return session.find(Interview.class, id);
	}

	@Override
	public List<Interview> getAll() {
		Query<Interview> query = session.createQuery("from Interview",Interview.class);
		List<Interview> lists = query.getResultList();
		return lists;
	}

	@Override
	public Interview updateById(int id) {
		session.beginTransaction();
		Interview interview = session.find(Interview.class, id);
		interview.setInterview_result("pass");
		session.save(interview);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return interview;
	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		Interview interview = session.find(Interview.class, id);
		session.delete(interview);
		session.getTransaction().commit();
	}
	public List<Interview> getInterviewList() {
		return interviewList;
	}
	
}
