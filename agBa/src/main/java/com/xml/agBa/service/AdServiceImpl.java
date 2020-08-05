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
import com.xml.agBa.model.EndUser;
import com.xml.agBa.model.Pricelist;
import com.xml.agBa.repository.AdRepo;
import com.xml.agBa.repository.CarRepo;
import com.xml.agBa.repository.EndUserRepo;
import com.xml.agBa.repository.PricelistRepo;
import com.xml.agBa.util.DateChecker;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepo adRepo;
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private PricelistRepo pricelistRepo;
	
	@Autowired
	private EndUserRepo endUserRepo;

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
	    
	    EndUser user = (EndUser) endUserRepo.findById(adDTO.getUser()).get();
	    
		Ad newAd = new Ad();
		
		newAd.setStartDate(sdTemo_ldt);
		newAd.setEndDate(edTemo_ldt);
		newAd.setPriceList(pricelist);
		newAd.setCar(car);
		newAd.setEndUser(user);
	
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
		return new AdDTO(adRepo.getOne(id));
	}

	@Override
	public List<AdDTO> search(String city, String startDateTime, String endDateTime) {
		
		String startDateTimeRemoveT =startDateTime.replace("T", "-");
		String endDateTimeRemoveT =endDateTime.replace("T", "-");
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
		
		LocalDateTime startLocalDateTime= LocalDateTime.parse(startDateTimeRemoveT, formater);
		LocalDateTime endLocalDateTime= LocalDateTime.parse(endDateTimeRemoveT, formater);
		
		List<Ad> adsCity = new ArrayList<Ad>();
		List<Ad> ads = adRepo.findAll();
//		is car from that city
		for (Ad ad : ads) {
			if(ad.getCar().getCity().toLowerCase().equals(city.toLowerCase())) {
				adsCity.add(ad);
			}
			
		}
//		if start is after end swap them
		if(startLocalDateTime.isAfter(endLocalDateTime)) {
			LocalDateTime startTemp = startLocalDateTime;
			startLocalDateTime = endLocalDateTime;
			endLocalDateTime = startTemp;
		}
		
		System.out.println("************** all cars in the city");
		for (Ad ad : adsCity) {
			System.out.println(" id" +ad.getCar().getIdCar()+ " ---- city" + ad.getCar().getCity());
		}
		
		
//		ads that have cars form that city and time(specified my end user) is within limits of that add
		List<AdDTO> adsDTO = new ArrayList<AdDTO>();
		for (Ad ad : adsCity) {
			if(DateChecker.isBetween(ad.getStartDate(), ad.getEndDate(), startLocalDateTime)) {
				System.out.println("111111111111 true" );
				if(DateChecker.isBetween(ad.getStartDate(), ad.getEndDate(), endLocalDateTime)) {
					adsDTO.add(new AdDTO(ad));
					System.out.println("22222222 true");
				}else {System.out.println("111111111111 false");}
			}else {System.out.println("222222222 false");}
	
		}
		
		
		
		return adsDTO;
	}

}
