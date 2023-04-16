package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Interview;

public class InterviewDao2 extends GenericDao<Interview>{
	
	private static Class<Interview> generic;
	private List<Interview> interviewList = new ArrayList<>();
	
	public InterviewDao2() {
		super(generic);
		interviewList.add(new Interview(LocalDate.parse("2020-10-01"),"pass"));
		interviewList.add(new Interview(LocalDate.parse("2022-10-15"),"pass"));
		interviewList.add(new Interview(LocalDate.parse("2020-10-01"),"fail"));
		interviewList.add(new Interview(LocalDate.parse("2022-09-15"),"fail"));
	}

	@Override
	public Interview update(Interview interview) {
		interview.setInterview_result("pass");
		return interview;
	}
	public List<Interview> getInterviewList() {
		return interviewList;
	}
}
