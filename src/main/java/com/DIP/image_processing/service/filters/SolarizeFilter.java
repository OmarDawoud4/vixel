package com.DIP.image_processing.service.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SolarizeFilter implements ImageFilter {

    @Override
    public BufferedImage apply(BufferedImage inputImage) {
        BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < inputImage.getWidth(); x++) {
            for (int y = 0; y < inputImage.getHeight(); y++) {
                Color c = new Color(inputImage.getRGB(x, y));
                int r = solarizeComponent(c.getRed());
                int g = solarizeComponent(c.getGreen());
                int b = solarizeComponent(c.getBlue());
                output.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return output;
    }

    private int solarizeComponent(int value) {
        return value < 128 ? 255 - value : value;
    }
}
