package com.intervinn.recastfs.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/assets")
@CrossOrigin(origins="*")
public class AssetsController {
    @GetMapping("/")
    public String getString() {
        return "hola amigos";
    }

    @GetMapping("/")
    public ResponseEntity<Resource> getAsset() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity createAsset(@RequestParam("file") MultipartFile file) {
        
        return ResponseEntity.ok().build();
    }
}
