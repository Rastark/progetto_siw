package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exams")
public class Exam {

	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date prenotationDate;
	
	@NotNull
	@Future
	@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message="coglione")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]{10}$", message="the code must be an alphanumeric string of 10 chars")
	@Column(nullable=false, unique=true)
	private String code;

	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private ExamTypology examTypology;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Medic medic;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Patient patient;
	
	@OneToMany(mappedBy="exam", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Result> results;
	
	/* Getters and setters */
	public Long getId() {
		return id;
	}

	public Date getPrenotationDate() {
		return prenotationDate;
	}

	public void setPrenotationDate(Date prenotationDate) {
		this.prenotationDate = prenotationDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ExamTypology getExamTypology() {
		return examTypology;
	}

	public void setExamTypology(ExamTypology examTypology) {
		this.examTypology = examTypology;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	
	/* Overrides */
	@Override
	public boolean equals(Object obj) {
		return this.getCode().equals(((Exam)obj).getCode());
	}
	
	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", prenotationDate=" + prenotationDate + ", visitDate=" + visitDate + ", code=" + code
				+ ", examTypology=" + examTypology + ", medic=" + medic + ", patient=" + patient + ", results="
				+ results + "]";
	}
}
