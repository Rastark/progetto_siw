package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private ExamTypology et;
	
	@Temporal(TemporalType.DATE)
	private Date prenotationDate;
	
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	@Column(nullable=false)
	private String code;
	
	
	public Exam(ExamTypology et, Date prenotationDate, Date visitDate, Long id) {
		this.et = et;
		this.prenotationDate = prenotationDate;
		this.visitDate = visitDate;
		this.id = id;
	}
	
	public Exam(){}
}
