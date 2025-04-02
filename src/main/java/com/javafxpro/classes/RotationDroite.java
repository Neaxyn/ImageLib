package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class RotationDroite extends ImageAmodifier implements Transformation {
    public RotationDroite(ImageView img) {
        super(img);
    }

    @Override
    public Image transformer() {
        WritableImage imageFlip = new WritableImage(this.longueur, this.largeur);
        for (int x = 0; x < this.longueur; x++) {
            for (int y = 0; y < this.largeur; y++) {
                int movedPix = imagePixels.getArgb(y, x);
                imageFlip.getPixelWriter().setArgb(this.longueur - x - 1, y, movedPix);
            }
        }
        return imageFlip;
    }

}
