package com.xml.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.cars.dto.CarBrandDTO;
import com.xml.cars.model.CarBrand;
import com.xml.cars.repo.CarBrandRepo;

@Service
@Transactional(readOnly = true)
public class CarBrandServiceImp implements CarBrandService {

	@Autowired
	private CarBrandRepo carBrandRepo;

	@Override
	public CarBrandDTO findCarBrandById(Long id) {
		return new CarBrandDTO(carBrandRepo.getOne(id));
	}

	@Override
	public List<CarBrandDTO> findAll() {
		// TODO Auto-generated method stub
		List<CarBrand> carBrands = carBrandRepo.findAll();
		List<CarBrandDTO> carBrandDTOs = new ArrayList<CarBrandDTO>();
		for (CarBrand carBrand : carBrands) {
			carBrandDTOs.add(new CarBrandDTO(carBrand));
		}
		return carBrandDTOs;
	}

	@Override
	@Transactional
	public CarBrandDTO save(CarBrandDTO carBrandDTO) {
		CarBrand carBrand = new CarBrand(carBrandDTO);
		carBrand = carBrandRepo.save(carBrand);

		return new CarBrandDTO(carBrand);
	}

	@Override
	@Transactional
	public CarBrandDTO update(Long id, CarBrandDTO carBrandDTO) {
		CarBrand old = carBrandRepo.getOne(id);
		old.setName(carBrandDTO.getName());

		old = carBrandRepo.save(old);

		return new CarBrandDTO(old);
	}

	@Override
	@Transactional
	public CarBrandDTO add(CarBrandDTO carBrandDTO) {
		CarBrand carBrand = new CarBrand();
		carBrand.setName(carBrandDTO.getName());

		carBrand = carBrandRepo.save(carBrand);

		return new CarBrandDTO(carBrand);
	}

	@Override
	@Transactional
	public Boolean delete(Long id) {
		CarBrand carBrand = carBrandRepo.getOne(id);
		carBrand.setIsdeleted(true);
		carBrand = carBrandRepo.save(carBrand);
		return true;
	}

}
