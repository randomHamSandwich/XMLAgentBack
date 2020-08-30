package com.xml.agBa.dto;

import java.sql.Blob;

import com.xml.agBa.model.Car;
import com.xml.agBa.model.Image;

public class ImageDTO {
 
	private Long idImage;
	private String name;
	private String imageLoc;
	private Long car;
	private byte[] imageData;
	
	public ImageDTO() {
		super();
	}
	
	public ImageDTO(Long idImage, String name, String imageLoc, Car car, byte[] imageData) {
		super();
		this.idImage = idImage;
		this.name = name;
		this.imageLoc = imageLoc;
		this.car = car.getIdCar();
		this.imageData = imageData;
	}
	
	public ImageDTO(Image images) {
		this(images.getIdImage(), images.getName(), images.getImageLoc(), images.getCar(), images.getImageData());
	}

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

	public Long getCar() {
		return car;
	}

	public void setCar(Long car) {
		this.car = car;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
}
