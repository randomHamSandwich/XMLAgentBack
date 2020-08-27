package com.xml.agBa.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idImage;
		@Column
		private String name;
		@Column
		private String imageLoc;
		
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "id_car", nullable = true)
		private Car car;
		
		@Column
		private byte[] imageData;

		public Image(Long idImage, String name, String imageLoc, Car car, byte[] imageData) {
			super();
			this.idImage = idImage;
			this.name = name;
			this.imageLoc = imageLoc;
			this.car = car;
			this.imageData = imageData;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public Car getCar() {
			return car;
		}

		public void setCar(Car car) {
			this.car = car;
		}

		public Image() {
			super();
			// TODO Auto-generated constructor stub
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

}
