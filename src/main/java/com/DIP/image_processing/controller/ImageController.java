package com.DIP.image_processing.controller;

import com.DIP.image_processing.service.ImageProcessingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {

    private final ImageProcessingService imageService;

    public ImageController(ImageProcessingService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(
            value = "/filter/{type}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity<byte[]> applyFilter(
            @PathVariable("type") String type,
            @RequestParam("image") MultipartFile imageFile
    ) throws IOException {
        byte[] processed = imageService.applyFilter(imageFile, type);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(processed);
    }
}
