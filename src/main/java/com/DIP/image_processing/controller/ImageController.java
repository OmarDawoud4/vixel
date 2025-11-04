package com.DIP.image_processing.controller;

import com.DIP.image_processing.service.ImageProcessingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {

    private final ImageProcessingService  imageProcessingService;

    public ImageController(ImageProcessingService imageProcessingService) {
        this.imageProcessingService = imageProcessingService;
    }

    @PostMapping(value = "/filter/invert",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> invertFilter(
            @RequestParam("image") MultipartFile imageFile)throws IOException {

        byte[] invertedimage = imageProcessingService.invertImage(imageFile);
        return ResponseEntity.ok().
                contentType(MediaType.IMAGE_PNG).
                body(invertedimage);


    }

    @PostMapping(value = "/filter/solarize",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity<byte[]> solarizeFilter(
            @RequestParam("image") MultipartFile imageFile)throws IOException {

        byte[] invertedimage = imageProcessingService.solarizeImage(imageFile);
        return ResponseEntity.ok().
                contentType(MediaType.IMAGE_PNG).
                body(invertedimage);


    }

    @PostMapping(value = "/filter/clip",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity<byte[]> clipFilter(
            @RequestParam("image") MultipartFile imageFile)throws IOException {

        byte[] invertedimage = imageProcessingService.clipImage(imageFile);
        return ResponseEntity.ok().
                contentType(MediaType.IMAGE_PNG).
                body(invertedimage);


    }


}
