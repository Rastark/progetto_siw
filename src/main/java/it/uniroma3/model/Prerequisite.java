package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="prerequisites")
public class Prerequisite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToMany
	private List<ExamTypology> examTypologies;

	public Prerequisite(String name, String description) {
		this.name=name;
		this.description=description;
	}
	
	public Prerequisite() {}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ExamTypology> getExamTypologies() {
		return examTypologies;
	}

	public void setExamTypologies(List<ExamTypology> examTypologies) {
		this.examTypologies = examTypologies;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((Prerequisite) obj).getName());
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getDescription().hashCode();
	}
}
