package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class BlackNWhite extends ImageAmodifier implements Transformation {
    public BlackNWhite(ImageView img) {
        super(img);
    }

    @Override
    public Image transformer() {
        WritableImage imageNeo = new WritableImage(this.largeur, this.longueur);
        for (int x = 0; x < this.largeur; x++) {
            for (int y = 0; y < this.longueur; y++) {
                int rouge = getRedValue(x, y);
                int vert = getGreenValue(x, y);
                int bleu = getBlueValue(x, y);
                int gris = (rouge + vert + bleu) / 3;
                int returnPixel = (getAlphaValue(x, y) << 24 | (gris << 16) | (gris << 8) | gris);
                imageNeo.getPixelWriter().setArgb(x, y, returnPixel);
            }
        }
        return imageNeo;
    }
}
