package it.uniroma3.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

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
	private float cost;

	@OneToMany(mappedBy = "examTypology")
	private List<Exam> exams;

	@ManyToMany(mappedBy="examTypologies")
	private List<Prerequisite> prerequisites;

	@ManyToMany(mappedBy="examTypologies")
	private List<ResultTypology> resultTypologies;

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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Prerequisite> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public List<ResultTypology> getResultTypologies() {
		return resultTypologies;
	}

	public void setResultTypologies(List<ResultTypology> resultTypologies) {
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
