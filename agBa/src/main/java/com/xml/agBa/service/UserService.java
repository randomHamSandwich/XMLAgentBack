package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.model.User;
import com.xml.agBa.model.EndUser;

public interface UserService {
	UserDTO saveUser(UserDTO korisnikDTO);

	List<UserDTO> findAllEndUsers();

	UserDTO getUserDTO(Long id);
	
	UserDTO chageUserRole(Long id, String role);

	User save(User korisnik);

	EndUser save(EndUser krajnjiKorisnik);

	Boolean delete(Long id);

	User getOne(Long id);
	
	EndUser getEndUserData(Long id);

}