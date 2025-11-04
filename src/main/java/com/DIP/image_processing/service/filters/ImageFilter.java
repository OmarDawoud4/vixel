package com.DIP.image_processing.service.filters;

import java.awt.image.BufferedImage;

public interface ImageFilter {
    BufferedImage apply(BufferedImage inputImage);
}
