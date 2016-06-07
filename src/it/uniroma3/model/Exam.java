package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Exams")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private ExamTypology et;
	
	@ManyToOne
	private Medic medic;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date prenotationDate;
	
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	@Column(nullable=false, unique=true)
	private String code;
	
	
	public Exam(ExamTypology et, Date prenotationDate, Date visitDate, Long id) {
		this.et = et;
		this.prenotationDate = prenotationDate;
		this.visitDate = visitDate;
		this.id = id;
	}
	
	public Exam(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamTypology getEt() {
		return et;
	}

	public void setEt(ExamTypology et) {
		this.et = et;
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
}
