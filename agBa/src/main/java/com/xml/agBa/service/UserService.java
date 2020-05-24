package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.model.User;
import com.xml.agBa.model.EndUser;

public interface UserService {

	UserDTO saveUser(UserDTO korisnikDTO);

	List<UserDTO> findAllKorisnik();

	UserDTO getUser(Long id);

	User save(User korisnik);

	EndUser save(EndUser krajnjiKorisnik);

}