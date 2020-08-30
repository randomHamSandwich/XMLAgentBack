package com.xml.agBa.service;

import java.sql.Blob;

import com.xml.agBa.dto.ImageDTO;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.Image;

import java.util.List;

public interface ImageService {
	
	Blob returnImageBlob(String idImage);
	
	ImageDTO createImage(ImageDTO imageDTO);
	
	Image getOne (Long idImage);
	
	List<Image> getAllImagesByIdCar(Car car);
	
	List<Image> getAllImagesByIdCar(Long idCar);
}
