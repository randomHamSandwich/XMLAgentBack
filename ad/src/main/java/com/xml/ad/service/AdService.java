package com.xml.ad.service;

import java.util.List;

import com.xml.ad.dto.AdDTO;

public interface AdService {

//	AdDTO createAd(AdDTO adDAO);

	List<AdDTO> getAllAds();

	AdDTO getAdById(Long id);

//	List<AdDTO> search(String city, String startDateTime, String endDateTime);


}
