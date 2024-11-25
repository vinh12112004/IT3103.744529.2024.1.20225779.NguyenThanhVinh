package AimsProject.src.hust.soict.dsai.aims.cart.Cart;
// Nguyen Thanh Vinh - 20225779

import AimsProject.src.hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("them thanh cong");
        } else
            System.out.println("gio hang day ko them duoc");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("them thanh cong " + dvdList[i].getTitle());
            } else
                System.out.println("gio hang day ko them duoc");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("them thanh cong " + dvd1.getTitle());
        } else
            System.out.println("gio hang day ko them duoc");

        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("them thanh cong " + dvd2.getTitle());
        } else
            System.out.println("gio hang day ko them duoc");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("xoa thanh cong");
                return;
            }
        }
        System.out.println("dia ko co de xoa");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + "DVD - " + itemsOrdered[i].toString());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        return null;
    }

    public void displaySearchResultById(int id) {
        DigitalVideoDisc result = searchById(id);
        if (result != null) {
            System.out.println("DVD found: " + result.toString());
        } else {
            System.out.println("No DVD with ID " + id + " found in the cart.");
        }
    }

    public DigitalVideoDisc searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                return itemsOrdered[i];
            }
        }
        return null;
    }

    public void displaySearchResultByTitle(String title) {
        DigitalVideoDisc result = searchByTitle(title);
        if (result != null) {
            System.out.println("DVD found: " + result.toString());
        } else {
            System.out.println("No DVD with title \"" + title + "\" found in the cart.");
        }
    }

}