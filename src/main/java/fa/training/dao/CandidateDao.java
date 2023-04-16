package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.Candidate;
import fa.training.utils.HibernateConnection;

public class CandidateDao implements Dao<Candidate> {
	
	private static String GET_ALL_CANDIDATE = "from Candidate";
	private Session session = HibernateConnection.getSessionFactory().openSession();
	private List<Candidate> candidates;
	
	public CandidateDao() {
		candidates = new ArrayList<>();
		Candidate candidate1 = new Candidate("bac",LocalDate.parse("2000-02-02"),LocalDate.parse("2000-02-02"),"123","bac@gmail.com");
		Candidate candidate2 =new Candidate("duong",LocalDate.parse("2000-02-02"),LocalDate.parse("2000-02-02"),"123","duong@gmail.com");
		Candidate candidate3 =new Candidate("nguyen",LocalDate.parse("2000-02-02"),LocalDate.parse("2000-02-02"),"123","nguyen@gmail.com");
		Candidate candidate4 =new Candidate("vinh",LocalDate.parse("2000-02-02"),LocalDate.parse("2000-02-02"),"123","vinh@gmail.com");
		
		candidate1.setSkill("angular");
		candidate1.setLevel(2);
		candidates.add(candidate1);
		
		candidate2.setForeign_language("japanese");
		candidate2.setSkill("python");
		candidate2.setLevel(2);
		candidates.add(candidate2);
		
		candidate3.setSkill("java");
		candidate3.setForeign_language("japanese");
		candidate3.setLevel(3);
		candidates.add(candidate3);
		
		candidate4.setSkill("java");
		candidate4.setLevel(3);
		candidates.add(candidate4);
		
	}
	@Override
	public void save(Candidate candidate) {
		session.beginTransaction();
		session.save(candidate);
		session.getTransaction().commit();
	}

	@Override
	public Candidate getById(int id) {
		return session.find(Candidate.class, id);
	}

	@Override
	public List<Candidate> getAll() {
		Query<Candidate> query = session.createQuery(GET_ALL_CANDIDATE,Candidate.class);
		List<Candidate> lists = query.getResultList();
		return lists;
	}

	@Override
	public Candidate updateById(int id) {
		session.beginTransaction();
		Candidate candidate = session.find(Candidate.class, id);
		candidate.setAllocation_status(1);
		session.save(candidate);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return candidate;
	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		Candidate candidate = session.find(Candidate.class, id);
		session.delete(candidate);
		session.getTransaction().commit();
	}
	public List<Candidate> getCandidates() {
		return candidates;
	}
	
}
