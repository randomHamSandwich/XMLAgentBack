package com.xml.agBa.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.xml.agBa.model.FileDB;
import com.xml.agBa.dto.CarDTO;

public interface FilesStorageService {
	
  public CarDTO store(MultipartFile file) throws IOException;

  public FileDB getFile(String id);

  public Stream<FileDB> getAllFiles();
}
