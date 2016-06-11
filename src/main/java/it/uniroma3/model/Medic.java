package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Medics")
public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private String surname;

	@Column(nullable=false)
	private String specialization;

	@OneToMany(mappedBy="medic")
	private List<Exam> exams;

	public Medic(String name, String surname, String specialization) {
		this.name=name;
		this.surname=surname;
		this.specialization=specialization;
	}

	public Medic() {}

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

	@Override
	public boolean equals(Object obj) {
		Medic medic = (Medic) obj;
		return (this.getName().equals(medic.getName()) && this.getSurname().equals(medic.getSurname()) && this.getSpecialization().equals(medic.getSpecialization()));
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getSurname().hashCode() + this.getSpecialization().hashCode();
	}
}
