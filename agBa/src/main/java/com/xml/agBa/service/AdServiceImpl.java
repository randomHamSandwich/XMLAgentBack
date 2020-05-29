package com.xml.agBa.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.model.Ad;
import com.xml.agBa.repository.AdRepo;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepo adRepo;

	@Override
	public AdDTO createAd(AdDTO adDTO) {
		
		System.out.println("===================================");
		System.out.println("ad service impl");
		System.out.println("===================================");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime startDateDTO = LocalDateTime.parse(adDTO.getStartDate(), formatter);
		LocalDateTime endDateDTO = LocalDateTime.parse(adDTO.getEndDate(), formatter);
		
		Ad newAd = new Ad();
		
		newAd.setStartDate(startDateDTO);
		newAd.setEndDate(endDateDTO);
		newAd.getPriceList().setIdPriceList(adDTO.getPricelist());
		newAd.getCar().setIdCar(adDTO.getCar());
		
		newAd = adRepo.save(newAd);
		
		return new AdDTO(newAd);
		
		
	}

	@Override
	public List<AdDTO> getAllAds() {
		List<Ad> adList = adRepo.findAll();
		List<AdDTO> adDTO = new ArrayList<AdDTO>();
		
		for (Ad temp: adList) {
			adDTO.add(new AdDTO(temp));
		}
		
		return adDTO;
	}

	@Override
	public AdDTO getAdById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
