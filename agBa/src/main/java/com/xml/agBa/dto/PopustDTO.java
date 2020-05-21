package com.xml.agBa.dto;

import com.xml.agBa.model.Popust;

public class PopustDTO {
	
	private int dani;
	private int popust;
	
	public PopustDTO() {
		
	}
	
	public PopustDTO(int dani, int popust) {
		super();
		this.dani = dani;
		this.popust = popust;
	}

	public PopustDTO(Popust p) {
		this(p.getViseOdXDana(), p.getPopust());
	}

	public int getDani() {
		return dani;
	}

	public void setDani(int dani) {
		this.dani = dani;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
}
