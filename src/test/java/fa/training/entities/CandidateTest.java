package fa.training.entities;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import fa.training.utils.HibernateConnection;
import service.ServiceImpl;

class CandidateTest {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static ServiceImpl service = new ServiceImpl();
	
	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateConnection.getSessionFactory();
		System.out.println("session factory is created");
//		ServiceImpl.insertTable();
	}
	@AfterAll
	public static void tearDown() {
		if(sessionFactory != null) sessionFactory.close();
		System.out.println("SessionFactory is destroyed");
	}
	////////////////////////////////////////////////////////////////////
	
	@Test
//	@Disabled
	void findAngularCandidate() {
		Candidate candidate = service.findAngularCandidate();
		Assertions.assertEquals("angular", candidate.getSkill());
	}
	@Test
//	@Disabled
	void findJapaneseCandidate() {
		List<Candidate> candidates = service.findJapaneseCandidate();
		Candidate candidate = candidates.get(0);
		Assertions.assertEquals("japanese",candidate.getForeign_language());
	}
	
	@Test
//	@Disabled
	void findJavaCandidate() {
		List<Candidate> candidates = service.findJavaCandidate();
		Candidate candidate = candidates.get(0);
		Assertions.assertEquals("java",candidate.getSkill());
	}
	
	@Test
//	@Disabled
	void findPassedCandidate() {
		List<Candidate> candidates = service.findJavaCandidate();
		Assertions.assertFalse(candidates.isEmpty());
	}
	
	@Test
//	@Disabled
	void updateRemark() {
		Candidate candidate = service.updateRemark();
		Assertions.assertNull(candidate);
	}
	/////////////////////////////////////////////////////////////
	
	@Test
//	@Disabled
	void getCandidateById() {
		System.out.println("geting candidate...");
		Integer id = 1;
		Candidate candidate  = service.getCandidateById(id);
		assertEquals("bac",candidate.getFull_name());
	}
	
	@Test
//	@Disabled
	void getAllCandidate() {
		System.out.println("geting all candidate...");
		List<Candidate> candidateList = service.getAllCandidate();
		Assertions.assertFalse(candidateList.isEmpty());
	}
	
	@Test
//	@Disabled
	void updateById() {
		System.out.println("updating candidate");
		Candidate candidate = service.updateCandidateById(1);
		assertEquals(1,candidate.getAllocation_status());
	}
	
	@Test
	@Disabled
	void deleteCandidate() {
		System.out.println("deleting candidate...");
		Integer id = 4;
		service.deleteCandidateById(id);
		Candidate deletedCandidate = service.getCandidateById(id);
		Assertions.assertNull(deletedCandidate);
	}
	/////////////////////////////////////////////////////////////////
	@Test
	void getInterviewById() {
		System.out.println("getting interview...");
		Integer id = 1;
		Interview interview = service.getInterviewById(id);
		Assertions.assertEquals("pass", interview.getRemark());
	}
	
	@Test
	void getAllInterview() {
		System.out.println("geting all interview...");
		List<Interview> interviewList = service.getAllInterview();
		Assertions.assertFalse(interviewList.isEmpty());
	}
	
	@Test
	void updateInterviewById() {
		System.out.println("updating interview");
		Interview interview = service.updateInterviewById(1);
		Assertions.assertEquals("pass",interview.getInterview_result());
	}
	
	@Test
	@Disabled
	void deleteInterviewById() {
		System.out.println("deleting interview");
		Integer id = 4;
		service.deleteInterviewById(id);
		Interview deletedInterview = service.getInterviewById(id);
		Assertions.assertNull(deletedInterview);
	}
	/////////////////////////////////////////////////////////////////
	@Test
	void getEntryTestById() {
		System.out.println("getting entrytest...");
		Integer id = 1;
		EntryTest entry = service.getEntryTestById(id);
		Assertions.assertEquals("pass", entry.getResult());
	}
	
	@Test
	void getAllEntryTest() {
		System.out.println("geting all entrytest...");
		List<EntryTest> entryList = service.getAllEntryTest();
		Assertions.assertFalse(entryList.isEmpty());
	}
	
	@Test
	void updateEntryTestById() {
		System.out.println("updating entrytest");
		EntryTest entry = service.updateEntryTestById(1);
		Assertions.assertEquals("ok",entry.getTechnical_valuator());
	}
	
	@Test
	@Disabled
	void deleteEntryTestById() {
		System.out.println("deleting entrytest");
		Integer id = 4;
		service.deleteEntryTestById(id);
		EntryTest deletedEntry = service.getEntryTestById(id);
		Assertions.assertNull(deletedEntry);
	}
	///////////////////////////////////////////////////////
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("session is created");
	}
	
	@AfterEach
	public void closeSession() {
		if(session != null) session.close();
		System.out.println("session is closed\n");
	}

}
