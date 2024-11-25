package AimsProject.src.hust.soict.dsai.aims.store.Store;
import AimsProject.src.hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    private static final int MAX_STORE_CAPACITY = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_STORE_CAPACITY];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_STORE_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Added DVD: " + dvd.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(String title) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].isMatch(title)) {

                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("Removed DVD: " + title);
                return;
            }
        }
        System.out.println("DVD with title \"" + title + "\" not found in store.");
    }

    public void printStore() {
        System.out.println("***************STORE***************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***********************************");
    }
}
