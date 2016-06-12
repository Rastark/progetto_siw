package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="resulttypologies")
public class ResultTypology {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="resultTypology")
	private List<Result> results;
	
	@ManyToMany
	private List<ExamTypology> examTypologies;
	
	public ResultTypology(String name) {
		this.name=name;
	}
	
	public ResultTypology() {}

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

	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((ResultTypology)obj).getName());
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
}
