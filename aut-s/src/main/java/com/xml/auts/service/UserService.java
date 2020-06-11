package com.xml.auts.service;

import java.util.List;

import com.xml.auts.dto.UserDTO;
import com.xml.auts.model.EndUser;
import com.xml.auts.model.User;

public interface UserService {
	
	

	UserDTO saveUser(UserDTO korisnikDTO);

	List<UserDTO> findAllEndUsers();

	UserDTO getUserDTO(Long id);
	
	UserDTO chageUserRole(Long id, String role);

	User save(User korisnik);

	EndUser save(EndUser krajnjiKorisnik);

	Boolean delete(Long id);

	User getOne(Long id);

}