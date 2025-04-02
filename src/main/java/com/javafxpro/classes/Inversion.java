package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Inversion extends ImageAmodifier implements Transformation {
    public Inversion(ImageView img) {
        super(img);
    }

    @Override
    public Image transformer() {
        WritableImage imageNeo = new WritableImage(this.largeur, this.longueur);
        for (int x = 0; x < this.largeur; x++) {
            for (int y = 0; y < this.longueur; y++) {
                int blueToRed = getGreenValue(x, y);
                int redToGreen = getRedValue(x, y);
                int greenToBlue = getBlueValue(x, y);
                int returnPixel = (getAlphaValue(x, y) << 24 | redToGreen << 16 | greenToBlue << 8 | blueToRed);
                imageNeo.getPixelWriter().setArgb(x, y, returnPixel);
            }
        }
        return imageNeo;
    }
}