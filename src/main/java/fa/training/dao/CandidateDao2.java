package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fa.training.entities.Candidate;

public class CandidateDao2 extends GenericDao<Candidate> {
	
	private static Class<Candidate> generic;
	private List<Candidate> candidates;
	
	public CandidateDao2() {
		super(generic);
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
	public Candidate update(Candidate candidate) {
		candidate.setAllocation_status(1);
		return candidate;
		
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}
}
