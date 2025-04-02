package com.javafxpro.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Sobel extends ImageAmodifier implements Transformation {

    public Sobel(ImageView img) {
        super(img);
    }


    @Override
    public Image transformer() {
        int[][] Matrice1 = {
                {-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}
        };
        int[][] Matrice2 = {
                {-1, -2, -1},
                {0, 0, 0},
                {1, 2, 1}
        };
        WritableImage imageNeo = new WritableImage(this.largeur, this.longueur);
        for (int x = 1; x < this.largeur - 1; x++) {// 1 afin de ne pas toucher le bords et de renvoyer une erreur
            for (int y = 1; y < this.longueur - 1; y++) {
                int redX = 0;
                int blueX = 0;
                int greenX = 0;

                int redY = 0;
                int blueY = 0;
                int greenY = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int pixelY = y + j;
                        int pixelX = x + i;
                        redX += getRedValue(pixelX, pixelY) * Matrice1[i + 1][j + 1];//+1 car on obtient un indice -1 au premier iteration
                        greenX += getGreenValue(pixelX, pixelY) * Matrice1[i + 1][j + 1];
                        blueX += getBlueValue(pixelX, pixelY) * Matrice1[i + 1][j + 1];

                        redY += getRedValue(pixelX, pixelY) * Matrice2[i + 1][j + 1];
                        greenY += getGreenValue(pixelX, pixelY) * Matrice2[i + 1][j + 1];
                        blueY += getBlueValue(pixelX, pixelY) * Matrice2[i + 1][j + 1];
                    }
                }
                int norme = (int) Math.sqrt(redX * redX + greenX * greenX + blueX * blueX + redY * redY + greenY * greenY + blueY * blueY);
                int returnPixels = (getAlphaValue(x, y) << 24 | (norme << 16) | (norme << 8) | norme);
                imageNeo.getPixelWriter().setArgb(x, y, returnPixels);
            }
        }
        return imageNeo;
    }
}
