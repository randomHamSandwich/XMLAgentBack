package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.UserRequestDTO;
import com.xml.agBa.model.UserRequest;
import com.xml.agBa.repository.UserRepo;
import com.xml.agBa.repository.UserRequestRepo;

@Service
@Transactional()
public class UserRequestServiceImp implements UserRequestService{
	
	@Autowired
	private UserRequestRepo userRequestRepo ;

	@Override
	public UserRequestDTO findUserRequestById(Long id) {
		
		return new UserRequestDTO(userRequestRepo.findById(id).get());
	}

	@Override
	public List<UserRequestDTO> findAllByUserId(Long userId) {
		List<UserRequest> list = userRequestRepo.findAllByUserId(userId);
		List<UserRequestDTO> listDTO = new ArrayList<UserRequestDTO>();
		for (UserRequest userRequest : list) {
			listDTO.add(new UserRequestDTO(userRequest));
		}
		return listDTO ;
	}

	@Override
	public UserRequestDTO save(UserRequestDTO userRequestDTO) {
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

}
