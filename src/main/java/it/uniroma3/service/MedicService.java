package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Medic;

public interface MedicService {

	public Medic getMedic(Long id);

	public List<Medic> listMedic();

	public void insertMedic(Medic medic);

	public void deleteMedic(Long id);

}