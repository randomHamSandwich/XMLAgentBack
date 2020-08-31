package com.xml.cars.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.xml.cars.model.FileDB;
import com.xml.cars.dto.CarDTO;

public interface FilesStorageService {
	
  public CarDTO store(MultipartFile file) throws IOException;

  public FileDB getFile(String id);

  public Stream<FileDB> getAllFiles();
}
