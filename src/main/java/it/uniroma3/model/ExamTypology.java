package it.uniroma3.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.engine.internal.Collections;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQuery(name= "findAllExamTypology", query="SELECT t FROM ExamTypology t")
@Table(name="examtypologies")
public class ExamTypology {

	/* Constructors */
	public ExamTypology() {}

	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	private String name;

	@NotBlank
	@Column(unique=true)
	private String code;

	@Column(length=2000)
	private String description;

	@NotBlank
	@Pattern(regexp="[0-9]", message="must be a number")
	private String cost;

	@OneToMany(mappedBy = "examTypology", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Exam> exams;

	@ManyToMany
	@JoinTable(
		      name="prerequisite_examtypology",
		      joinColumns=@JoinColumn(name="prerequisite_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="examtypology_id", referencedColumnName="id"))
	private Collection<Prerequisite> prerequisites = new HashSet<Prerequisite>();

	@ManyToMany(mappedBy="examTypologies")
	private Set<ResultTypology> resultTypologies = new HashSet<ResultTypology>();

	/* Getters and Setters */
	public long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Collection<Prerequisite> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Set<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public Collection<ResultTypology> getResultTypologies() {
		return resultTypologies;
	}

	public void setResultTypologies(Set<ResultTypology> resultTypologies) {
		this.resultTypologies = resultTypologies;
	}

	/* Overrides */
	public boolean equals(Object o) {
		ExamTypology type = (ExamTypology)o;
		return this.getCode().equals(type.getCode());
	}

	public int hashCode() {
		return this.code.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam Typology");
		sb.append("{id=").append(id);
		sb.append("name=").append(name);
		sb.append("cost=").append(cost);
		sb.append("description=").append(description);
		sb.append(", code=").append(code);
		sb.append("}\n");
		return sb.toString();
	}
}
