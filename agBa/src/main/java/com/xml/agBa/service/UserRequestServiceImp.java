package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.UserRequestDTO;
import com.xml.agBa.model.StatusUserRequest;
import com.xml.agBa.model.UserRequest;
import com.xml.agBa.repository.AdRepo;
import com.xml.agBa.repository.UserRepo;
import com.xml.agBa.repository.UserRequestRepo;
import com.xml.agBa.util.DateChecker;

@Service
@Transactional()
public class UserRequestServiceImp implements UserRequestService{
	
	@Autowired
	private UserRequestRepo userRequestRepo ;
	
	@Autowired
	private AdRepo adReop;
	
	@Autowired
	private UserService userService;

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
//	TODO add start and end time
	public UserRequestDTO save(UserRequestDTO userRequestDTO) {
		UserRequest newUr = new UserRequest();
		newUr.setAd(adReop.getOne(userRequestDTO.getAdId()));
		newUr.setEndUser(userService.getEndUserData(userRequestDTO.getAdId()));
		newUr.setPriceDay(newUr.getAd().getPriceList().getPriceForOneDay());
		newUr.setStatusUserRequest(StatusUserRequest.PENDING);
		newUr.setUUID(userRequestDTO.getId());
		
		newUr.setStartDate(DateChecker.convertTimeForDb(userRequestDTO.getStartDate()) );
		newUr.setEndDate(DateChecker.convertTimeForDb(userRequestDTO.getEndDate()));
		
		
		
		newUr = userRequestRepo.save(newUr);
		
		
		
		return new UserRequestDTO(newUr);
		
	}

	@Override
	public Boolean delete(Long id) {
		return null;
	}

}
