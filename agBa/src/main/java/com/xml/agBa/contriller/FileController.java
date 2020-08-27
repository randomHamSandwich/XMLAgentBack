package com.xml.agBa.contriller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.message.response.ResponseFile;
import com.xml.agBa.message.response.ResponseMessage;
import com.xml.agBa.model.FileDB;
import com.xml.agBa.model.FileInfo;
import com.xml.agBa.service.FilesStorageService;
import com.xml.agBa.service.CarService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api")
public class FileController {

	  @Autowired
	  private FilesStorageService storageService;
	  
	  @Autowired
	  private CarService carService;

	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	storageService.store(file);

	    	message = "Uploaded the file successfully: " + file.getOriginalFilename();
	    	return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } 	catch (Exception e) {
	    	message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//	    FileDB fileDB = storageService.getFile(id);
		  CarDTO carDTO = new CarDTO(carService.getOne(Long.parseLong(id)));
		  FileDB fileDB = new FileDB(carDTO.getCarBrand()+carDTO.getCarModel(), "slika", carDTO.getPhoto());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	}