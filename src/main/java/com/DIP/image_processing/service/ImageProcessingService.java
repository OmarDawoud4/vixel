package com.DIP.image_processing.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ImageProcessingService {

    public byte[] invertImage(final MultipartFile imageFile)throws IOException {

        BufferedImage originalImage= ImageIO.read(imageFile.getInputStream());
        BufferedImage invertedImage = new BufferedImage(originalImage.getWidth(),
                originalImage.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        for(int x = 0; x < originalImage.getWidth(); x++){
            for(int y = 0; y < originalImage.getHeight(); y++){
                int rgb =originalImage.getRGB(x, y);
                invertedImage.setRGB(x, y, ~rgb);
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(invertedImage, "png", out);
        return out.toByteArray();
    }
}
