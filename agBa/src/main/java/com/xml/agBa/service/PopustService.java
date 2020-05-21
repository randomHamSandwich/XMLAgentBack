package com.xml.agBa.service;

import java.util.List;

import com.xml.agBa.dto.PopustDTO;

public interface PopustService {

	PopustDTO createPopust(PopustDTO popustData);

	List<PopustDTO> getAllPopusti();

}
