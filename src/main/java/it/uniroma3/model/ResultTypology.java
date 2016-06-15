package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="resulttypologies")
public class ResultTypology {

	/* Constructors */
	public ResultTypology() {}
	
	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="resultTypology", cascade = CascadeType.ALL)
	private List<Result> results;
	
	@ManyToMany
	private List<ExamTypology> examTypologies;
	
	/* Getters and setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public List<ExamTypology> getExamTypologies() {
		return examTypologies;
	}

	public void setExamTypologies(List<ExamTypology> examTypologies) {
		this.examTypologies = examTypologies;
	}

	public Long getId() {
		return id;
	}
	
	/* Override */
	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((ResultTypology)obj).getName());
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "ResultTypology [id=" + id + ", name=" + name + ", results=" + results + ", examTypologies="
				+ examTypologies + "]";
	}
}
