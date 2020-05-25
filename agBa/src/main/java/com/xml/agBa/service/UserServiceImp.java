package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.model.EndUser;
import com.xml.agBa.model.Roles;
import com.xml.agBa.model.User;
import com.xml.agBa.repository.UserRepo;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setIdUser(userDTO.getIdUser());
		user.setEmail(userDTO.getEmail());
		user.setStreet(userDTO.getStreet());

		user = userRepo.save(user);
		return new UserDTO(user);
	}

	@Override
	public List<UserDTO> findAllEndUsers() {

		List<User> users = userRepo.findAllEndUsers();
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User k : users) {
			Object[] r = k.getRoles().toArray();
			Roles role = (Roles)r[0];
			usersDTO.add(new UserDTO(k,role));
		}

		return usersDTO;
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public EndUser save(EndUser endUser) {
		return userRepo.save(endUser);
	}

	@Override
	public UserDTO getUser(Long id) {
		return new UserDTO(userRepo.getOne(id));
	}

}
