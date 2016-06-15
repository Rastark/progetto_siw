package it.uniroma3.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="prerequisites")
public class Prerequisite {
	
	/* Constructors */
	public Prerequisite() {}
	
	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]+(\\s?[a-zA-Z0-9])*$", message="max 1 whitespace between words and alphanumeric chars allowed")
	@Column(nullable=false, unique=true)
	private String name;
	
	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String description;
	
	@ManyToMany(mappedBy="prerequisites")
	private Collection<ExamTypology> examTypologies;

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

	public Collection<ExamTypology> getExamTypologies() {
		return examTypologies;
	}

	public void setExamTypologies(List<ExamTypology> examTypologies) {
		this.examTypologies = examTypologies;
	}
	
	/* Overrides */
	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((Prerequisite) obj).getName());
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getDescription().hashCode();
	}

	@Override
	public String toString() {
		return "Prerequisite [id=" + id + ", name=" + name + ", description=" + description + ", examTypologies="
				+ examTypologies + "]";
	}
}
