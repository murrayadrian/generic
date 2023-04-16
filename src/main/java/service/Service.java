package service;

import java.util.List;

import fa.training.entities.Candidate;

public interface Service {
	
	Candidate findAngularCandidate();
	
	List<Candidate> findJapaneseCandidate();
	
	List<Candidate> findJavaCandidate();
	
	List<Candidate> findPassedCandidate();
	
	Candidate updateRemark();
}
