package com.javafxpro.classes;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;


public class ImageAmodifier {
    protected int longueur;
    protected int largeur;
    protected PixelReader imagePixels;

    public ImageAmodifier(ImageView img) {
        this.largeur = (int) img.getImage().getWidth();//caster en int car ça renvoie un double
        this.longueur = (int) img.getImage().getHeight();
        this.imagePixels = img.getImage().getPixelReader();
    }


    public int getBlueValue(int indiceX, int indiceY) {
        int blue = this.imagePixels.getArgb(indiceX, indiceY);

        return (blue & 0xff);
    }

    public int getGreenValue(int indiceX, int indiceY) {
        int vert = this.imagePixels.getArgb(indiceX, indiceY);
        return ((vert >> 8) & 0xff);
    }

    public int getRedValue(int indiceX, int indiceY) {
        int rouge = this.imagePixels.getArgb(indiceX, indiceY);
        return ((rouge >> 16) & 0xff);
    }

    public int getAlphaValue(int indiceX, int indiceY) {
        int alpha = this.imagePixels.getArgb(indiceX, indiceY);
        return ((alpha >> 24) & 0xff);
    }

    public int limiterAuBorneMax(int nombre, int limit) {
        if (nombre > limit) {
            nombre = limit;
        }
        return nombre;
    }

}
