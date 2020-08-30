package com.xml.agBa.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agBa.dto.ImageDTO;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.Image;
import com.xml.agBa.repository.CarRepo;
import com.xml.agBa.repository.ImageRepo;

@Service
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepo imageRepo;
	
	@Autowired
	private CarRepo carRepo;
	
	@Override
	public Blob returnImageBlob(String idImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ImageDTO createImage(ImageDTO imageDTO) {
		Image newImage = new Image();
		newImage.setCar(carRepo.getOne(imageDTO.getCar()));
		newImage.setImageLoc(imageDTO.getImageLoc());
		newImage.setName(imageDTO.getName());
		newImage.setImageData(imageDTO.getImageData());
		newImage = imageRepo.save(newImage);
		
		return new ImageDTO(newImage);
	}

	@Override
	public Image getOne(Long idImage) {
		return imageRepo.getOne(idImage);
	}

	@Override
	public List<Image> getAllImagesByIdCar(Car car) {
		List<Image> images = imageRepo.getAllImagesByIdCar(car.getIdCar());
		return images;
	}

	@Override
	public List<Image> getAllImagesByIdCar(Long idCar) {
		List<Image> images = imageRepo.getAllImagesByIdCar(idCar);
		return images;
	}
	
	
}
