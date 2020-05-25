package com.xml.agBa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;

	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	@ManyToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "idRole"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private Set<User> users;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Long idRole, RoleName roleName, Set<User> users) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.users = users;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
