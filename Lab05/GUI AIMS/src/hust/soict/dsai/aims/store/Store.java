package hust.soict.dsai.aims.store;



import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added media: " + media.getTitle());
        } else {
            System.out.println("Media is already in the store: " + media.getTitle());
        }
    }

    public void removeMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsInStore.remove(media);
                System.out.println("Removed media: " + title);
                return;
            }
        }
        System.out.println("Media with title \"" + title + "\" not found in the store.");
    }

    public void printStore() {
        System.out.println("***************STORE***************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            int index = 1;
            for (Media media : itemsInStore) {
                System.out.println(index++ + ". " + media.toString());
            }
        }
        System.out.println("***********************************");
    }
    
    
    // public void printStore() {
    //     System.out.println("***************STORE***************");
    //     int index = 1;
    //     for (Media media : itemsInStore) {
    //         System.out.println(index++ + ". " + media.toString());
    //     }
    //     System.out.println("***********************************");
    // }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}

