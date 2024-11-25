package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore;

    // Constructor
    public Store() {
        this.qtyInStore = 0;
    }

    // Add DVD to store
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full, cannot add more DVDs.");
            return;
        }
        itemsInStore[qtyInStore] = disc;
        qtyInStore++;
        System.out.println("The DVD has been added to the store: " + disc.getTitle());
    }

    // Remove DVD from store
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].equals(disc)) {
                found = true;
                // Move the following elements up
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Delete last element
                qtyInStore--;
                System.out.println("The DVD has been removed from the store: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD was not found in the store.");
        }
    }

    // Print a list of DVDs currently available in the store
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] != null) {
                itemsInStore[i].printDVD();
            }
        }
        System.out.println("**************************************************");
    }
}
