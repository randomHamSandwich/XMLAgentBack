package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.model.User;
import com.xml.agBa.model.EndUser;
import com.xml.agBa.repository.UserRepo;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo korisnikRepo;

	@Override
	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setIdUser(userDTO.getIdUser());
		user.setEmail(userDTO.getEmail());
		user.setStreet(userDTO.getStreet());

		user = korisnikRepo.save(user);
		return new UserDTO(user);
	}

	@Override
	public List<UserDTO> findAllKorisnik() {

		List<User> korisnici = korisnikRepo.findAll();
		List<UserDTO> KorisniksDTO = new ArrayList<>();
		for (User k : korisnici) {
			KorisniksDTO.add(new UserDTO(k));
		}

		return KorisniksDTO;
	}

	@Override
	@Transactional
	public User save(User korisnik) {
		return korisnikRepo.save(korisnik);
	}

	@Override
	@Transactional
	public EndUser save(EndUser krajnjiKorisnik) {
		return korisnikRepo.save(krajnjiKorisnik);
	}

	@Override
	public UserDTO getUser(Long id) {
		return new UserDTO(korisnikRepo.getOne(id));
	}

}
