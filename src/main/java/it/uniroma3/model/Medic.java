package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="medics")
public class Medic {

	/* Constructors */
	public Medic() {}
	
	/* Parameters */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String name;

	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String surname;

	@NotBlank
	@Pattern(regexp="^[a-zA-Z]+(\\s?[a-zA-Z])*$", message="max 1 whitespace between words and only letters allowed")
	@Column(nullable=false)
	private String specialization;

	@OneToMany(mappedBy="medic")
	private List<Exam> exams;

	/* Getters and setters */
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	/* Overrides */
	@Override
	public boolean equals(Object obj) {
		Medic medic = (Medic) obj;
		return (this.getName().equals(medic.getName()) && this.getSurname().equals(medic.getSurname()) && this.getSpecialization().equals(medic.getSpecialization()));
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getSurname().hashCode() + this.getSpecialization().hashCode();
	}

	@Override
	public String toString() {
		return "Medic [id=" + id + ", name=" + name + ", surname=" + surname + ", specialization=" + specialization
				+ ", exams=" + exams + "]";
	}
}
