package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Sepia extends ImageAmodifier implements Transformation {
    public Sepia(ImageView img) {
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
                int NeoBleu = (int) (rouge * 0.272 + vert * 0.534 + bleu * 0.131);
                int NeoVert = (int) (rouge * 0.349 + vert * 0.686 + bleu * 0.168);
                int NeoRouge = (int) (rouge * 0.393 + vert * 0.769 + bleu * 0.189);
                NeoBleu = limiterAuBorneMax(NeoBleu, 255);
                NeoVert = limiterAuBorneMax(NeoVert, 255);
                NeoRouge = limiterAuBorneMax(NeoRouge, 255);
                int returnPixel = ((getAlphaValue(x, y) << 24) | (NeoRouge << 16) | (NeoVert << 8) | NeoBleu);
                imageNeo.getPixelWriter().setArgb(x, y, returnPixel);
            }
        }
        return imageNeo;
    }
}
