package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.UserRequestDTO;


public interface UserRequestService {
	
	UserRequestDTO findUserRequestById(Long id);

	List<UserRequestDTO> findAllByUserId(Long idUser);
	
	UserRequestDTO save(UserRequestDTO userRequestDTO);

	Boolean delete(Long id);

}
