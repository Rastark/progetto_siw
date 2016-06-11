package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Results")
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String value;
	
	@ManyToOne
	private Exam exam;
	
	@ManyToOne
	private ResultTypology resultTypology;
	
	public Result(String value) {
		this.value=value;
	}

	public Result() {}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ResultTypology getResultTypology() {
		return resultTypology;
	}

	public void setResultTypology(ResultTypology resultTypology) {
		this.resultTypology = resultTypology;
	}

	public Long getId() {
		return id;
	}

}
