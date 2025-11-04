package com.DIP.image_processing.service.filters;

import java.awt.image.BufferedImage;

public class InvertFilter implements ImageFilter {

    @Override
    public BufferedImage apply(BufferedImage inputImage) {
        BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                int rgb = inputImage.getRGB(x, y);
                output.setRGB(x, y, ~rgb);
            }
        }
        return output;
    }
}
