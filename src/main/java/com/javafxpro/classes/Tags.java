package com.javafxpro.classes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;


public class Tags {
    ArrayList<String> images;

    public Tags() {
        this.images = new ArrayList<>();
    }

    public void chercherImageParTag(String tag) {
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader("src/main/resources/Tags.JSON"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray bibliotheque = jsonObject.getAsJsonArray("bibliotheque");
            for (int i = 0; i < bibliotheque.size(); i++) {
                JsonObject image = bibliotheque.get(i).getAsJsonObject();
                JsonArray tags = image.getAsJsonArray("tags");
                for (int j = 0; j < tags.size(); j++) {
                    if (tags.get(j).getAsString().equals(tag)) {
                        String chemin = image.get("nomImage").getAsString();
                        this.images.add(chemin);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getImages() {
        return images;
    }
}

