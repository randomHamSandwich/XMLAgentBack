package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.UserDTO;
import com.xml.agBa.model.EndUser;
import com.xml.agBa.model.RoleName;
import com.xml.agBa.model.Roles;
import com.xml.agBa.model.User;
import com.xml.agBa.repository.EndUserRepo;
import com.xml.agBa.repository.UserRepo;
import com.xml.agBa.security.repository.RolesRepo;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private  RolesRepo rolesRepo;
	
	@Autowired
	private EndUserRepo endUserRepo;

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

	
	/** get get users dto, as users have one role set authority field in userDTO to that role
	 */
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
	public UserDTO getUserDTO(Long id) {
		return new UserDTO(userRepo.getOne(id));
	}

	/** Change end user permissions to:	END_USER, END_USER_FORBIDDEN, END_USER_LIMITED_ACCESS
	 */
	@Override
	@Transactional
	public UserDTO chageUserRole(Long id, String roleName) {
		User user = userRepo.getOne(id);
		Optional<Roles> role = rolesRepo.findByRoleName(RoleName.valueOf(roleName));
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role.get());
		user.setRoles(roles);
		userRepo.save(user);
		
		Object[] r = user.getRoles().toArray();
		Roles roleCasted = (Roles)r[0];
		
		return new UserDTO(user, roleCasted );
	}
	
	@Override
	@Transactional
	public Boolean delete(Long id) {
		User user= userRepo.getOne(id);
		user.setIsdeleted(true);
		user= userRepo.save(user);
		return true;
	}


	@Override
	public User getOne(Long id) {
		
		return userRepo.getOne(id);
	}


	@Override
	public EndUser getEndUserData(Long id) {
		EndUser user = endUserRepo.findById(id).get();
		
		return user;
	}
	
}
