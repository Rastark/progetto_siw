package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Admin;

public interface AdminDao {

	public Admin getAdmin(Long id);

	public List<Admin> getAllAdmins();

	public void insertAdmin(Admin admin);

	public void deleteAdmin(Long id);

}