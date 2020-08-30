package com.xml.agBa.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xml.agBa.dto.CarDTO;
import com.xml.agBa.model.FileDB;
import com.xml.agBa.repository.FileDBRepository;


@Service
public class FilesStorageServiceImpl implements FilesStorageService{

  @Autowired
  private FileDBRepository fileDBRepository;
  
  @Autowired
  private CarService carService;

  @Override
  public CarDTO store(MultipartFile file) throws IOException {
	  
//	  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//	  FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

    return carService.editCar(Long.parseLong(file.getOriginalFilename()), file.getBytes());
  }

  @Override
  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  @Override
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }

}

