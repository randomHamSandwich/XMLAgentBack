package com.xml.ad.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.ad.dto.AdDTO;
import com.xml.ad.model.Ad;
import com.xml.ad.model.Pricelist;
import com.xml.ad.repo.AdRepo;
import com.xml.ad.repo.PricelistRepo;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepo adRepo;
	
//	@Autowired
//	private CarRepo carRepo;
	
	@Autowired
	private PricelistRepo pricelistRepo;

	@Override
	public AdDTO createAd(AdDTO adDTO) {
		String startDateTimeRemoveT = adDTO.getStartDate().replace("T", "-");
		String endDateTimeRemoveT = adDTO.getEndDate().replace("T", "-");
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
		
		LocalDateTime startLocalDateTime= LocalDateTime.parse(startDateTimeRemoveT, formater);
		LocalDateTime endLocalDateTime= LocalDateTime.parse(endDateTimeRemoveT, formater);
		
	  /* 
	    Long carID = Long.valueOf(adDTO.getCar());
	    Car car = carRepo.findById(carID).get();
	  */ 
	    
	    Long pricelistID = Long.valueOf(adDTO.getPricelistId());
	    Pricelist pricelist = pricelistRepo.findById(pricelistID).get();
	    
	  /*
	    EndUser user = (EndUser) endUserRepo.findById(adDTO.getUser()).get();
	    Integer endUserAds = user.getAdsNumber();
	    endUserAds = endUserAds + 1;
	  */
	    
	    
		Ad newAd = new Ad();
		
		newAd.setStartDate(startLocalDateTime);
		newAd.setEndDate(endLocalDateTime);
		newAd.setPriceList(pricelist);
		//newAd.setCar(car);
		newAd.setIdUser(adDTO.getUserId());
		newAd.setActive(true);
	
		newAd = adRepo.save(newAd);
		
		/*user.setAdsNumber(endUserAds);
		endUserRepo.save(user);
		
		car.setAdvertised(true);
		carRepo.save(car);*/
		
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

/*	
	@Override
	public List<Ad> getActiveAdsByUser(Long id) {
		List<Ad> ads = adRepo.findActiveByUser(id);
		
		return ads;
	}
*/
	
	@Override
	public List<Ad> getActiveAds() {
		List<Ad> ads = adRepo.findActiveAds();
		
		return ads;
	}	

	@Override
	public Boolean deleteAd(Long id) {
		Ad ad = adRepo.findById(id).get();
		ad.setActive(false);
		ad = adRepo.save(ad);
		
	/*	
		Car car = ad.getCar();
		car.setAdvertised(false);
		carRepo.save(car);
		
		EndUser endUser = ad.getEndUser();
		Integer adsNumber = endUser.getAdsNumber();
		adsNumber = adsNumber - 1;
		endUser.setAdsNumber(adsNumber);
		endUserRepo.save(endUser);
	*/	
		return true;
	}

	@Override
	public Ad updateAd(Long adId, AdDTO adDTO) {
		Ad ad = adRepo.findById(adId).get();
		Pricelist pricelist = pricelistRepo.findById(adDTO.getPricelistId()).get();
		
		String startDateTimeRemoveT =adDTO.getStartDate().replace("T", "-");
		String endDateTimeRemoveT =adDTO.getEndDate().replace("T", "-");
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
		
		LocalDateTime startLocalDateTime= LocalDateTime.parse(startDateTimeRemoveT, formater);
		LocalDateTime endLocalDateTime= LocalDateTime.parse(endDateTimeRemoveT, formater);
		
		ad.setStartDate(startLocalDateTime);
		ad.setEndDate(endLocalDateTime);
		ad.setPriceList(pricelist);
		
		ad = adRepo.save(ad);
		return ad;
	}

	@Override
	public List<Ad> getActiveAdsByUser(Long id) {
		List<Ad> activeAds = adRepo.findActiveByUser(id);
		
		return activeAds;
	}

//	@Override
//	public List<AdDTO> search(String city, String startDateTime, String endDateTime) {
//		
//		String startDateTimeRemoveT =startDateTime.replace("T", "-");
//		String endDateTimeRemoveT =endDateTime.replace("T", "-");
//		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
//		
//		LocalDateTime startLocalDateTime= LocalDateTime.parse(startDateTimeRemoveT, formater);
//		LocalDateTime endLocalDateTime= LocalDateTime.parse(endDateTimeRemoveT, formater);
//		
//		List<Ad> adsCity = new ArrayList<Ad>();
//		List<Ad> ads = adRepo.findAll();
////		is car from that city
//		for (Ad ad : ads) {
//			if(ad.getCar().getCity().toLowerCase().equals(city.toLowerCase())) {
//				adsCity.add(ad);
//			}
//			
//		}
////		if start is after end swap them
//		if(startLocalDateTime.isAfter(endLocalDateTime)) {
//			LocalDateTime startTemp = startLocalDateTime;
//			startLocalDateTime = endLocalDateTime;
//			endLocalDateTime = startTemp;
//		}
//		
//		System.out.println("************** all cars in the city");
//		for (Ad ad : adsCity) {
//			System.out.println(" id" +ad.getCar().getIdCar()+ " ---- city" + ad.getCar().getCity());
//		}
//		
//		
////		ads that have cars form that city and time(specified my end user) is within limits of that add
//		List<AdDTO> adsDTO = new ArrayList<AdDTO>();
//		for (Ad ad : adsCity) {
//			if(DateChecker.isBetween(ad.getStartDate(), ad.getEndDate(), startLocalDateTime)) {
//				System.out.println("111111111111 true" );
//				if(DateChecker.isBetween(ad.getStartDate(), ad.getEndDate(), endLocalDateTime)) {
//					adsDTO.add(new AdDTO(ad));
//					System.out.println("22222222 true");
//				}else {System.out.println("111111111111 false");}
//			}else {System.out.println("222222222 false");}
//	
//		}
//		
//		
//		
//		return adsDTO;
//	}

}
