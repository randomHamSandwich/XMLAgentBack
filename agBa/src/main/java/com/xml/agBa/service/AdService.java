package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.AdDTO;
import com.xml.agBa.dto.CarDTO;

public interface AdService {

	AdDTO createAd(AdDTO adDAO);

	List<AdDTO> getAllAds();

	AdDTO getAdById(Long id);

	List<AdDTO> search(String city, String startDateTime, String endDateTime);


}
