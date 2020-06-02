package com.xml.agBa.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Images{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idImage;
		@Column
		private String name;
		@Column
		private String imageLoc;
		
		public Images(Long idImage, String name, String imageLoc) {
			super();
			this.idImage = idImage;
			this.name = name;
			this.imageLoc = imageLoc;
		}

		public Images() {
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
