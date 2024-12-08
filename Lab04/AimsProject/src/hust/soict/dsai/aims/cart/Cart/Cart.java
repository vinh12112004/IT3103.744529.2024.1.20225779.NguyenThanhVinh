package hust.soict.dsai.aims.cart.Cart;
// Nguyen Thanh Vinh - 20225779

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Media added to the cart: " + media.getTitle());
        } else {
            System.out.println("Media is already in the cart: " + media.getTitle());
        }
    }

    public ArrayList<Media> ItemsInCart() {
        return itemsOrdered;
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media removed from the cart: " + media.getTitle());
        } else {
            System.out.println("Media not found in the cart: " + media.getTitle());
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index++ + ". " + media.toString());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void displaySearchResultById(int id) {
        Media result = searchById(id);
        if (result != null) {
            System.out.println("Media found: " + result.toString());
        } else {
            System.out.println("No Media with ID " + id + " found in the cart.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void displaySearchResultByTitle(String title) {
        Media result = searchByTitle(title);
        if (result != null) {
            System.out.println("Media found: " + result.toString());
        } else {
            System.out.println("No Media with title \"" + title + "\" found in the cart.");
        }
    }

}