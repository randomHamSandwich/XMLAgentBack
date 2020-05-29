package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.AdDTO;


public interface AdService {

	AdDTO createAd(AdDTO adDAO);
	List<AdDTO> getAllAds();
	AdDTO getAdById(Long id);
}
