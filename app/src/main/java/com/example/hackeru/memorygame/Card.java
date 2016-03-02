package com.example.hackeru.memorygame;

/**
 * Created by hackeru on 29/02/2016.
 */
public class Card {
    private int imageId;
    private static int currentlyShown;

    public Card(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static int getCurrentlyShown() {
        return currentlyShown;
    }

    public static void addCurrentlyShown() {
        if(currentlyShown < 2)
            Card.currentlyShown++;
    }
    public static void clearCurrentlyShown(){
        currentlyShown = 0;
    }

//    @Override
//    public boolean equals(Object card) {
//        return imageId == ((Card) card).getImageId();
//    }
}
