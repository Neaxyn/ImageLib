package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class RotationGauche extends ImageAmodifier implements Transformation {
    public RotationGauche(ImageView img) {
        super(img);
    }

    @Override
    public Image transformer() {
        WritableImage imageFlip = new WritableImage(this.longueur, this.largeur);
        for (int x = 0; x < this.longueur; x++) {
            for (int y = 0; y < this.largeur; y++) {
                int movedPix = imagePixels.getArgb(y, x);
                imageFlip.getPixelWriter().setArgb(x, this.largeur - y - 1, movedPix);
            }
        }
        return imageFlip;
    }


}
