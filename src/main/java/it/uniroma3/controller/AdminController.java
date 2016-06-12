package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import it.uniroma3.model.Admin;
import it.uniroma3.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@ModelAttribute("admin")
	public Admin createAdmin() {
		return new Admin();
	}
	
	@RequestMapping("/listadmin")
	public String listAdmin(Model model) {
		model.addAttribute("adminList", adminService.listAdmin());
		return "admin";
	}	
}
