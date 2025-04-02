package com.javafxpro.controller;

import com.javafxpro.classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ImageController implements Initializable {
    @FXML
    private final FileChooser charger = new FileChooser();
    public String[] tags = {"animal", "paysage", "soleil", "ciel", "couleur", "transport"};
    @FXML
    private ImageView putImage;
    @FXML
    private ChoiceBox<String> choixTags = new ChoiceBox<>();
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choixTags.getItems().addAll(tags);
    }

    public void chargement() {
        charger.setTitle("choisis le fichier");
        charger.setInitialDirectory(new File("src/main/resources"));
        charger.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier Image", "*.jpg"));
        File file = charger.showOpenDialog(new Stage());
        try {
            String path = file.toURI().toString();
            System.out.println(path);
            Image imageModifier = new Image(path);
            putImage.setImage(imageModifier);
        } catch (Exception e) {
            System.out.println("fichier invalide ou annulé");
        }
    }

    @FXML
    public void noirEtBlanc() {
        putImage.setImage(new BlackNWhite(putImage).transformer());
    }

    @FXML
    public void SepiaFilter() {
        putImage.setImage(new Sepia(putImage).transformer());
    }

    @FXML
    public void SobelFilter() {
        putImage.setImage(new Sobel(putImage).transformer());
    }

    @FXML
    public void rotationGauche() {
        putImage.setImage(new RotationGauche(putImage).transformer());
    }

    @FXML
    public void rotationDroite() {
        putImage.setImage(new RotationDroite(putImage).transformer());
    }

    @FXML
    public void symetrieHorizontal() {
        putImage.setImage(new SymetrieH(putImage).transformer());
    }

    @FXML
    public void symetrieVertical() {
        putImage.setImage(new SymetrieV(putImage).transformer());
    }

    @FXML
    public void Inverser() {
        putImage.setImage(new Inversion(putImage).transformer());
    }

    @FXML
    public void chercher() {
        listView.getItems().clear();
        Tags listChemins = new Tags();
        listChemins.chercherImageParTag(choixTags.getValue());
        ArrayList<String> listes = listChemins.getImages();
        listView.getItems().addAll(listes);
    }

    @FXML
    public void ouvrirImageAvecTags() {
        try {
            String fichier = listView.getSelectionModel().getSelectedItem();
            Image imageTags = new Image(fichier);
            putImage.setImage(imageTags);
        } catch (Exception e) {
            System.out.println("Vous avez cliqué sur une liste vide");
        }

    }


}