package it.uniroma3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="admin")
@NamedQuery(name = "findAllAdmins", query = "SELECT a from Admin a")
public class Admin {
	
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
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotBlank
	@Pattern(regexp="^[a-ZA-Z0-9]$", message="password must be alphanumeric and between 6 to 12 chars")
	@Length(min=6, max=12)
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(mappedBy="admins")
	private Set<Role> roles = new HashSet<Role>();
	
	/* Getters and Setters */	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}

	/* Overrides */
	@Override
	public boolean equals(Object obj) {
		return this.getEmail().equals(((Admin)obj).getEmail());
	}
	
	@Override
	public int hashCode() {
		return this.getEmail().hashCode();
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
}
