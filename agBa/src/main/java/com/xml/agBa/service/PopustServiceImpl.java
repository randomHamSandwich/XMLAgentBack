package com.xml.agBa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agBa.dto.PopustDTO;
import com.xml.agBa.model.Popust;
import com.xml.agBa.repository.DiscountRepo;

@Service
public class PopustServiceImpl implements PopustService {
	
	@Autowired
	private DiscountRepo popustRepo;
	
	@Override
	public PopustDTO createPopust(PopustDTO popustData) {
		Popust popust = new Popust();
		popust.setViseOdXDana(popustData.getDani());
		popust.setPopust(popustData.getPopust());
		
		popust = popustRepo.save(popust);
		return new PopustDTO(popust);
	}
	
	public List<PopustDTO> getAllPopusti() {
		List<Popust> popusti = popustRepo.findAll();
		List<PopustDTO> popustiList = new ArrayList<>();
		
		for (Popust p: popusti) {
			popustiList.add(new PopustDTO(p));
		}
		
		return popustiList;
	}
}
