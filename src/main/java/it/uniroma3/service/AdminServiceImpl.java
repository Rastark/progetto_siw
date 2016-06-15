package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.AdminDao;
import it.uniroma3.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.AdminService#getAdmin(java.lang.Long)
	 */
	@Override
	public Admin getAdmin(Long id) {
		return this.adminDao.getAdmin(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.AdminService#listAdmin()
	 */
	@Override
	public List<Admin> listAdmin() {
		return this.adminDao.getAllAdmins();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.AdminService#insertAdmin(it.uniroma3.model.Admin)
	 */
	@Override
	@Transactional
	public void insertAdmin(Admin admin) {
		this.adminDao.insertAdmin(admin);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.AdminService#deleteAdmin(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteAdmin(Long id) {
		this.adminDao.deleteAdmin(id);
	}

}
