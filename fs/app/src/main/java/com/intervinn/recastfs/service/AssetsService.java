package com.intervinn.recastfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intervinn.config.AssetsConfig;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;

@Service
public class AssetsService {
    private final Path ROOT_LOCATION;

    @Autowired
    public AssetsService(AssetsConfig config) {
        if (config.getLocation().trim().length() == 0) {
            throw new RuntimeException("file location cant be empty");
        }

        this.ROOT_LOCATION = Paths.get(config.getLocation());
    }

    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("file upload cant be empty");
            }
    
            Path destination = this.ROOT_LOCATION.resolve(
                Paths.get(file.getOriginalFilename())
                .normalize().toAbsolutePath()
            );
    
            if (destination.getParent().equals(this.ROOT_LOCATION.toAbsolutePath())) {
                throw new RuntimeException("cannot store file outside current directory");
            }
    
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            } 
        } catch (IOException e) {
            throw new RuntimeException("failed to store file");
        }
    }    
}
