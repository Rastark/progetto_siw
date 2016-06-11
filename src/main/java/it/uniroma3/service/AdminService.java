package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Admin;

public interface AdminService {

	public Admin getAdmin(Long id);

	public List<Admin> listAdmin();

	public void insertAdmin(Admin admin);

	public void deleteAdmin(Long id);

}