package fa.training.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidate_id;
	
	@NotNull(message = "{candidate.name.invalid}")
	private String full_name;
	
	@NotNull(message = "{candidate.birthdate.invalid}")
	@Column(columnDefinition = "DATE")
	private LocalDate date_of_birth;
	
	@NotNull(message = "{candidate.year.invalid}")
	@Column(columnDefinition = "DATE")
	private LocalDate graduation_year;
	
	@NotNull(message = "{candidate.phone.invalid}")
	private String phone;
	
	@NotNull(message = "{candidate.email.invalid}")
	private String email;
	
	@Range(min = 1, max = 7, message = "{candidate.level.invalid}")
	private int level;
	@Range(min = 0, max = 1, message = "{candidate.gender.invalid}")
	private int gender;
	
	private String skill;
	private String foreign_language;
	private String cv;
	private int allocation_status;
	private String remark;
	
	@OneToMany(mappedBy="candidate")
	private Set<Interview> interview = new HashSet<>();
	@OneToMany(mappedBy="candidate")
	private Set<EntryTest> entryTest = new HashSet<>();

	
	public Candidate() {
		
	}
	
	public Candidate(String full_name, LocalDate date_of_birth, LocalDate graduation_year, String phone, String email) {
		this.full_name = full_name;
		this.date_of_birth = date_of_birth;
		this.graduation_year = graduation_year;
		this.phone = phone;
		this.email = email;
	}


	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public LocalDate getGraduation_year() {
		return graduation_year;
	}
	public void setGraduation_year(LocalDate graduation_year) {
		this.graduation_year = graduation_year;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getForeign_language() {
		return foreign_language;
	}
	public void setForeign_language(String foreign_language) {
		this.foreign_language = foreign_language;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public int getAllocation_status() {
		return allocation_status;
	}
	public void setAllocation_status(int allocation_status) {
		this.allocation_status = allocation_status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Interview> getInterview() {
		return interview;
	}
	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}
	public Set<EntryTest> getEntryTest() {
		return entryTest;
	}
	public void setEntryTest(Set<EntryTest> entryTest) {
		this.entryTest = entryTest;
	}
	
	public void addCandidate(EntryTest entry,Interview interview) {
		this.entryTest.add(entry);
		this.interview.add(interview);
		entry.setCandidate(this);
		interview.setCandidate(this);
	}
	
}
