package com.DIP.image_processing.service;

import com.DIP.image_processing.service.filters.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageProcessingService {

    private final InvertFilter invertFilter = new InvertFilter();
    private final SolarizeFilter solarizeFilter = new SolarizeFilter();
    private final ClipFilter clipFilter = new ClipFilter();

    public byte[] applyFilter(MultipartFile imageFile, String filterType) throws IOException {
        BufferedImage input = ImageIO.read(imageFile.getInputStream());
        BufferedImage output;

        switch (filterType.toLowerCase()) {
            case "invert" -> output = invertFilter.apply(input);
            case "solarize" -> output = solarizeFilter.apply(input);
            case "clip" -> output = clipFilter.apply(input);
            default -> throw new IllegalArgumentException("Unknown filter: " + filterType);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(output, "png", out);
        return out.toByteArray();
    }
}
