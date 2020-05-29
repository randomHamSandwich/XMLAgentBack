package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.CarModelDTO;
import com.xml.agBa.model.CarModel;
import com.xml.agBa.model.GearboxType;
import com.xml.agBa.repository.CarModelRepo;

@Service
@Transactional(readOnly = true)
public class CarModelServiceImp implements CarModelService{
	
	@Autowired
	private CarModelRepo carModelRepo;

	@Override
	public CarModelDTO findCarModelId(Long id) {
		return new CarModelDTO( carModelRepo.getOne(id));
	}

	@Override
	public List<CarModelDTO> findAll() {
		List<CarModel> carModels = carModelRepo.findAll();
		List<CarModelDTO> carModelDTOs = new ArrayList<CarModelDTO>();
		for (CarModel car : carModels) {
			carModelDTOs.add(new CarModelDTO(car));
		}
		
		return carModelDTOs;
	}

	@Override
	@Transactional
	public CarModelDTO save(CarModelDTO carModelDTO) {
		CarModel carModel = new CarModel(carModelDTO);
		
		return new CarModelDTO(carModel);
	}

	@Override
	@Transactional
	public CarModelDTO update(Long id, CarModelDTO carModelDTO) {
		CarModel old = carModelRepo.getOne(id);
		old.setName(carModelDTO.getName());
		
		old= carModelRepo.save(old);
		
		return new CarModelDTO(old);
	}

	@Override
	@Transactional
	public CarModelDTO add(CarModelDTO carModelDTO) {
		CarModel carModel = new CarModel();
		carModel.setName(carModelDTO.getName());
		
		carModel = carModelRepo.save(carModel);
		
		return new CarModelDTO(carModel);
	}

	@Override
	@Transactional
	public Boolean delete(Long id) {
		CarModel  carModel= carModelRepo.getOne(id);
		carModel.setIsdeleted(true);
		carModel= carModelRepo.save(carModel);
		return true;
	}
	
	

}
