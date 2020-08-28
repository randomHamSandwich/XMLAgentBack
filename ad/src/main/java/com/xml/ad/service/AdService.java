package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.AdDTO;
import com.xml.ad.model.Ad;

public interface AdService {

	AdDTO createAd(AdDTO adDAO);
	List<AdDTO> getAllAds();
	List<Ad> getActiveAdsByUser(Long id);
	List<Ad> getActiveAds();
	AdDTO getAdById(Long id);
	//List<AdDTO> search(String city, String startDateTime, String endDateTime);
	Boolean deleteAd(Long id);
	Ad updateAd(Long adId, AdDTO adDTO);
}
