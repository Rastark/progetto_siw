package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Exams")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date prenotationDate;
	
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	@Column(nullable=false, unique=true)
	private String code;

	@ManyToOne
	private ExamTypology examTypology;
	
	@ManyToOne
	private Medic medic;
	
	@ManyToOne
	private Patient patient;
	
	@OneToMany(mappedBy="exam")
	private List<Result> results;
	
	public Exam(ExamTypology et, Date prenotationDate, Date visitDate, String code) {
		this.examTypology = et;
		this.prenotationDate = prenotationDate;
		this.visitDate = visitDate;
		this.code = code;
	}
	
	public Exam(){}
	
	public Long getId() {
		return id;
	}

	public ExamTypology getEt() {
		return examTypology;
	}

	public void setEt(ExamTypology et) {
		this.examTypology = et;
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
	
	@Override
	public boolean equals(Object obj) {
		return this.getCode().equals(((Exam)obj).getCode());
	}
	
	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}
}
