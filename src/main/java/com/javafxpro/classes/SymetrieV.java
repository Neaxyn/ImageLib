package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class SymetrieV extends ImageAmodifier implements Transformation {
    public SymetrieV(ImageView img) {
        super(img);
    }

    @Override
    public Image transformer() {
        WritableImage imageFlip = new WritableImage(this.largeur, this.longueur);
        for (int x = 0; x < this.largeur; x++) {
            for (int y = 0; y < this.longueur; y++) {
                int movedPix = imagePixels.getArgb(x, this.longueur - y - 1);
                imageFlip.getPixelWriter().setArgb(x, y, movedPix);
            }
        }
        return imageFlip;
    }
}
