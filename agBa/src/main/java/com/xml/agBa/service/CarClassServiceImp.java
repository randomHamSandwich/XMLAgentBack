package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.CarClassDTO;
import com.xml.agBa.model.CarClass;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.repository.CarClassRepo;

@Service
@Transactional(readOnly = true)
public class CarClassServiceImp implements CarClassService {

	@Autowired
	private CarClassRepo carClassRepo;

	@Override
	public CarClassDTO findCarClassById(Long id) {
		return new CarClassDTO(carClassRepo.getOne(id));
	}

	@Override
	public List<CarClassDTO> findAll() {
		List<CarClass> carClass = carClassRepo.findAll();
		List<CarClassDTO> carClassDTOs = new ArrayList<CarClassDTO>();
		for (CarClass cc : carClass) {
			carClassDTOs.add(new CarClassDTO(cc));
		}

		return carClassDTOs;
	}

	@Override
	@Transactional
	public CarClassDTO save(CarClassDTO carClassDTO) {
		CarClass carClass = new CarClass(carClassDTO);
		carClass = carClassRepo.save(carClass);

		return new CarClassDTO(carClass);
	}

	@Override
	@Transactional
	public CarClassDTO update(Long id, CarClassDTO carClassDTO) {
		CarClass old = carClassRepo.getOne(id);
		old.setName(carClassDTO.getName());

		old = carClassRepo.save(old);

		return new CarClassDTO(old);
	}

	@Override
	@Transactional
	public CarClassDTO add(CarClassDTO carClassDTO) {
		CarClass carClass = new CarClass();
		carClass.setName(carClassDTO.getName());

		carClass = carClassRepo.save(carClass);

		return new CarClassDTO(carClass);

	}

	@Override
	@Transactional
	public Boolean delete(Long id) {
		CarClass carClass = carClassRepo.getOne(id);
		carClass.setIsdeleted(true);
		carClass = carClassRepo.save(carClass);
		return true;
	}

}
