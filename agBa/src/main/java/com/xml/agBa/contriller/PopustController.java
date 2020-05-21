package com.xml.agBa.contriller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agBa.dto.PopustDTO;
import com.xml.agBa.service.PopustService;

@CrossOrigin(origins = "*")
@RestController
public class PopustController {

	@Autowired
	private PopustService popustService;

	@PostMapping(value = "/create")
	public ResponseEntity<PopustDTO> createPopust(@RequestBody PopustDTO popustData) {
		//System.out.println("kreiranje popusta: " + popustData.getDani() + " , " + popustData.getPopust());
		PopustDTO noviPopust = popustService.createPopust(popustData);
		
		return new ResponseEntity<>(noviPopust, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/popusti")
	public ResponseEntity<List<PopustDTO>> getAllPopusti() {
		List<PopustDTO> popustiList = popustService.getAllPopusti();
		
		return new ResponseEntity<>(popustiList, HttpStatus.OK);
	}
	
}
