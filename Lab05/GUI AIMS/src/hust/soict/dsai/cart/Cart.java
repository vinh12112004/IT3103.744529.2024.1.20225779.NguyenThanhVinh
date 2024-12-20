package hust.soict.dsai.cart;

import java.util.Optional;
import java.util.stream.Collectors;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); // Dùng ObservableList

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Media added to the cart: " + media.getTitle());
        } else {
            System.out.println("Media is already in the cart: " + media.getTitle());
        }
    }

    public ObservableList<Media> getItemsOrdered() {
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


    public ObservableList<Media> searchById(int id) {
        // Lọc các media có ID trùng với tham số id
        return itemsOrdered.stream()
                .filter(media -> media.getId() == id)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));  // Trả về ObservableList
    }



    public ObservableList<Media> searchByTitle(String title) {
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));  // Return ObservableList
    }

    
    public void displaySearchResultById(int id) {
        ObservableList<Media> result = searchById(id);
        if (!result.isEmpty()) {
            System.out.println("Media found with ID " + id + ":");
            result.forEach(media -> System.out.println(media.toString()));
        } else {
            System.out.println("No Media with ID " + id + " found in the cart.");
        }
    }

    public void displaySearchResultByTitle(String title) {
        ObservableList<Media> result = searchByTitle(title);
        if (!result.isEmpty()) {
            System.out.println("Media found with title \"" + title + "\":");
            result.forEach(media -> System.out.println(media.toString()));
        } else {
            System.out.println("No Media with title \"" + title + "\" found in the cart.");
        }
    }

    
    public void placeMedia() {
        if (!itemsOrdered.isEmpty()) {
            itemsOrdered.clear();
            System.out.println("All media have been removed from the cart.");
        } else {
            System.out.println("The cart is already empty.");
        }
    }



    private static Cart instance = null;

    public Cart() {
        // Constructor private để đảm bảo chỉ có một thể hiện của Cart
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

  
}
