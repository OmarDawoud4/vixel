package com.DIP.image_processing.service.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ClipFilter implements ImageFilter {

    @Override
    public BufferedImage apply(BufferedImage inputImage) {
        BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                Color c = new Color(inputImage.getRGB(x, y));
                int r = Math.max(50, c.getRed());
                int g = Math.max(50, c.getGreen());
                int b = Math.max(50, c.getBlue());
                output.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return output;
    }
}
