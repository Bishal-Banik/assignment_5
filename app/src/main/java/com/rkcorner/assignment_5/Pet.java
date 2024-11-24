package com.rkcorner.assignment_5;

import java.util.List;

public class Pet {
    private String breed, type;
    private List<String> names, ages; // Store names and ages as lists
    private int[] images;

    public Pet(List<String> names, String breed, List<String> ages, String type, int[] images) {
        this.names = names;
        this.breed = breed;
        this.ages = ages;
        this.type = type;
        this.images = images;
    }

    public String getName(int index) {
        return names.get(index);
    }

    public String getAge(int index) {
        return ages.get(index);
    }

    public String getBreed() {
        return breed;
    }

    public String getType() {
        return type;
    }

    public int getImage(int index) {
        return images[index];
    }

    public int getImageCount() {
        return images.length;
    }
}