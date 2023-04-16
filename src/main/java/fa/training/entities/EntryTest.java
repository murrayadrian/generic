package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
public class EntryTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int test_id;
	
	@Column(columnDefinition = "DATE")
	private LocalDate date;
	
	@Range(min = 0,max = 10,message="{entry.range.invalid}")
	private int language_result;
	
	@Range(min = 0,max = 10,message="{entry.range.invalid}")
	private int technical_result;
	
	@Pattern(regexp = "\\bpass|fail\\b",message="{entry.result.invalid}")
	private String result;
	
	private String time;
	private String language_valuator;
	private String technical_valuator;
	private String remark;
	private String entry_test_skill;
	
	@ManyToOne
	private Candidate candidate;
	
	
	public EntryTest() {
	
	}
	
	
	public EntryTest(LocalDate date, String result) {
		this.date = date;
		this.result = result;
	}


	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLanguage_valuator() {
		return language_valuator;
	}
	public void setLanguage_valuator(String language_valuator) {
		this.language_valuator = language_valuator;
	}
	public int getLanguage_result() {
		return language_result;
	}
	public void setLanguage_result(int language_result) {
		this.language_result = language_result;
	}
	public String getTechnical_valuator() {
		return technical_valuator;
	}
	public void setTechnical_valuator(String technical_valuator) {
		this.technical_valuator = technical_valuator;
	}
	public int getTechnical_result() {
		return technical_result;
	}
	public void setTechnical_result(int technical_result) {
		this.technical_result = technical_result;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEntry_test_skill() {
		return entry_test_skill;
	}
	public void setEntry_test_skill(String entry_test_skill) {
		this.entry_test_skill = entry_test_skill;
	}
	public Candidate getCandidateo() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
