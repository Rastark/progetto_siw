package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Medic;

public interface MedicDao {

	public Medic getMedic(String name, String surname);

	public List<Medic> getAllMedics();

	public void insertMedic(Medic medic);

	public void deleteMedic(Long id);

}