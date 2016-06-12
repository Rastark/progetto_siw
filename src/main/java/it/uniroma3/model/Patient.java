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
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String surname;

	@OneToMany(mappedBy="patient")
	private List<Exam> exams;
	
	public Patient(String name, String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	public Patient() {}

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

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Patient patient = (Patient) obj;
		return (this.getName().equals(patient.getName()) && this.getSurname().equals(patient.getSurname()));
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getSurname().hashCode();
	}
	
}
