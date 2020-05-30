package com.xml.agBa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.model.Ad;
import com.xml.agBa.model.Car;
import com.xml.agBa.model.Pricelist;
import com.xml.agBa.repository.AdRepo;
import com.xml.agBa.repository.CarRepo;
import com.xml.agBa.repository.PricelistRepo;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepo adRepo;
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private PricelistRepo pricelistRepo;

	@Override
	public AdDTO createAd(AdDTO adDTO) {
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	    LocalDate sdTemp = LocalDate.parse(adDTO.getStartDate(), DATEFORMATTER);
	    LocalDateTime sdTemo_ldt = LocalDateTime.of(sdTemp, LocalDateTime.now().toLocalTime());
	    
	    LocalDate edTemp = LocalDate.parse(adDTO.getEndDate(), DATEFORMATTER);
	    LocalDateTime edTemo_ldt = LocalDateTime.of(edTemp, LocalDateTime.now().toLocalTime());
	    
	    Long carID = Long.valueOf(adDTO.getCar());
	    Car car = carRepo.findById(carID).get();
	    
	    Long pricelistID = Long.valueOf(adDTO.getPricelist());
	    Pricelist pricelist = pricelistRepo.findById(pricelistID).get();
	    
	    
		Ad newAd = new Ad();
		
		newAd.setStartDate(sdTemo_ldt);
		newAd.setEndDate(edTemo_ldt);
		newAd.setPriceList(pricelist);
		newAd.setCar(car);
	
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
		
		System.out.println("===================================");
		System.out.println("IN HERE, id: " + id);
		System.out.println("===================================");
		
		return new AdDTO(adRepo.getOne(id));
	}

}
