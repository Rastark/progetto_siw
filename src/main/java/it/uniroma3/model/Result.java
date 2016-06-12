package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="results")
public class Result {

	/* Constructors */
	public Result() {}
	
	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String value;
	
	@ManyToOne
	private Exam exam;
	
	@ManyToOne
	private ResultTypology resultTypology;

	/* Getters and setters */
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
	
	/* Overrides */
	@Override
	public boolean equals(Object obj) {
		return this.getValue().equals(((Result)obj).getValue());
	}
	
	@Override
	public int hashCode() {
		return this.getValue().hashCode();
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", value=" + value + ", exam=" + exam + ", resultTypology=" + resultTypology + "]";
	}
}
