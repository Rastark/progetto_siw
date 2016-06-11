package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.AdminDao;
import it.uniroma3.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public Admin getAdmin(Long id) {
		return this.adminDao.getAdmin(id);
	}
	
	public List<Admin> listAdmin() {
		return this.adminDao.getAllAdmins();
	}
	
	public void insertAdmin(Admin admin) {
		this.adminDao.insertAdmin(admin);
	}
	
	public void deleteAdmin(Long id) {
		this.adminDao.deleteAdmin(id);
	}

}
