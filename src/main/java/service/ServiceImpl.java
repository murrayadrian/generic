package service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.dao.CandidateDao2;
import fa.training.dao.EntryTestDao;
import fa.training.dao.EntryTestDao2;
import fa.training.dao.InterviewDao;
import fa.training.dao.InterviewDao2;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;
import fa.training.utils.HibernateConnection;

public class ServiceImpl implements Service {
	
	private static String SELECT_ANGULAR_CANDIDATE = "from Candidate c where c.skill = 'angular' AND c.level = 2";
	
	private static String SELECT_ALL_JAPANESE_CANDIDATE = "from Candidate c where c.foreign_language = 'japanese'"
														+ " and skill = 'python'";
	
	private static String SELECT_ALL_JAVA_CANDIDATE = "from Candidate c JOIN c.entryTest e ON "
													+ "c.candidate_id = e.candidate.candidate_id AND e.date = '2020-10-01'";
	
	private static String SELECT_PASSED_CANDIDATE = "from Candidate c JOIN Interview i ON "
													+ "c.candidate_id = i.candidate.candidate_id AND i.date = '2020-10-15'";
	
	private static String POOR_CANDIDATE = "from Candidate c where c.phone IS NULL and c.email IS NULL and c.cv IS NULL";
	
	private static Session session = HibernateConnection.getSessionFactory().openSession();
	
	private static CandidateDao2 candidateDao = new CandidateDao2();
	private static InterviewDao interviewDao = new InterviewDao();
	private static EntryTestDao entryDao = new EntryTestDao();
	
	
	
	public static void insertTable() {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}	
		Candidate candidate1 = candidateDao.getCandidates().get(0);
		EntryTest entry1 = entryDao.getEntryList().get(0);
		Interview interview1 = interviewDao.getInterviewList().get(0);
		Interview interview15 = interviewDao.getInterviewList().get(1);
		
		candidate1.addCandidate(entry1, interview1);
		
		Candidate candidate2 = candidateDao.getCandidates().get(1);
		candidate2.addCandidate(entry1, interview1);
		
		Candidate candidate3 = candidateDao.getCandidates().get(2);
		candidate3.addCandidate(entry1, interview1);
		
		Candidate candidate4 = candidateDao.getCandidates().get(3);
		candidate4.addCandidate(entry1, interview15);
		
		session.save(candidate1);
		session.save(entry1);
		session.save(interview1);
		session.save(candidate2);
		session.save(candidate3);
		session.save(candidate4);
		session.getTransaction().commit();

		
		System.out.println("insert successfully...");
	}
	
	@Override
	public Candidate findAngularCandidate() {
		Query<Candidate> query = session.createQuery(SELECT_ANGULAR_CANDIDATE,Candidate.class);
		Candidate candidate = query.getSingleResult();
		return candidate;
	}

	@Override
	public List<Candidate> findJapaneseCandidate() {
		Query<Candidate> query = session.createQuery(SELECT_ALL_JAPANESE_CANDIDATE,Candidate.class);
		List<Candidate> candidates = query.getResultList();
		return candidates;
	}

	@Override
	public List<Candidate> findJavaCandidate() {
		List<Candidate> candidateList = new ArrayList<>();
		Query<Object[]> query = session.createQuery(SELECT_ALL_JAVA_CANDIDATE,Object[].class);
		List<Object[]> candidates = query.list();
		for(Object[] candidate : candidates) {
			candidateList.add((Candidate)candidate[0]);
		}
		return candidateList;
	}

	@Override
	public List<Candidate> findPassedCandidate() {
		List<Candidate> candidateList = new ArrayList<>();
		Query<Object[]> query = session.createQuery(SELECT_PASSED_CANDIDATE,Object[].class);
		List<Object[]> candidates = query.list();
		for(Object[] candidate : candidates) {
			candidateList.add((Candidate)candidate[0]);
		}
		return candidateList;
	}

	@Override
	public Candidate updateRemark() {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		Query<Candidate> query = session.createQuery(POOR_CANDIDATE,Candidate.class);
		Candidate candidate = query.uniqueResult();
		if(candidate != null) {
			candidate.setRemark("poor");
			session.getTransaction().commit();
			return candidate;
		}
		else {
			return null;
		}
		
	}
	
	public Candidate getCandidateById(int id) {
		return candidateDao.getById(id);
	}
	public List<Candidate> getAllCandidate() {
		return candidateDao.getAll();
	}
	public Candidate updateCandidateById(int id) {
		return candidateDao.updateById(id);
	}
	public void deleteCandidateById(int id) {
		candidateDao.deleteById(id);
	}
	/////////////////////////////////////////////
	public Interview getInterviewById(int id) {
		return interviewDao.getById(id);
	}
	public List<Interview> getAllInterview(){
		return interviewDao.getAll();
	}
	public Interview updateInterviewById(int id) {
		return interviewDao.updateById(id);
	}
	public void deleteInterviewById(int id) {
		interviewDao.deleteById(id);
	}
	//////////////////////////////////////////////
	public EntryTest getEntryTestById(int id) {
		return entryDao.getById(id);
	}
	public List<EntryTest> getAllEntryTest(){
		return entryDao.getAll();
	}
	public EntryTest updateEntryTestById(int id) {
		return entryDao.updateById(id);
	}
	public void deleteEntryTestById(int id) {
		entryDao.deleteById(id);
	}
	
}
