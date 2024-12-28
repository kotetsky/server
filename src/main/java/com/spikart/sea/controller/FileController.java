package com.spikart.sea.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.spikart.sea.config.Constants.UPLOAD_PATH;

@RestController
@RequestMapping("/api/file")
public class FileController {


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("uploadedFile") MultipartFile multipartFile) {
        try {
            // Створюємо папку, якщо її ще немає
            File uploadDir = new File(UPLOAD_PATH); // /opt/tomcat/sea_backend/uploads
            if (!uploadDir.exists()) {
                boolean isDirCreated = uploadDir.mkdir();
                if (!isDirCreated) {
                    return new ResponseEntity<>("Directory can not be created", HttpStatus.INTERNAL_SERVER_ERROR);
                } else System.out.println("Directory created");
            }

            // Зберігаємо файл
            String uploadedFilePath = UPLOAD_PATH + "/" + multipartFile.getOriginalFilename(); //
            File savedFile = new File(uploadedFilePath);
            if (savedFile.exists()) {
                if (false) multipartFile.transferTo(savedFile);
                return new ResponseEntity<>("savedFile already exists", HttpStatus.INTERNAL_SERVER_ERROR);
            } else  {
                multipartFile.transferTo(savedFile);
                System.out.println("File uploaded " + uploadedFilePath);
            }

            // Повертаємо шлях до файлу
            return new ResponseEntity<>("File uploaded: /" + uploadedFilePath, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload this file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
