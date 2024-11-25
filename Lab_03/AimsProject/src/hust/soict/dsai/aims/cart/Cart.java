package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    // Constructor
    public Cart() {
        setQtyOrdered(0);
    }

    // Getter and Setter
    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    // Method to add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // If cart is full
        if (getQtyOrdered() >= 20) {
            System.out.println("The cart is almost full");
            return;
        }

        // Increase the qtyOrdered
        setQtyOrdered(getQtyOrdered() + 1);

        // Add DVD to Cart
        DigitalVideoDisc[] newItemsOrdered = getItemsOrdered();
        newItemsOrdered[getQtyOrdered() - 1] = disc;
        setItemsOrdered(newItemsOrdered);

        // Notify
        System.out.println("The disc has been added");
    }

    // Method to remove DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        // Search for disc
        int indexOfRemoved = -1;
        DigitalVideoDisc[] newItemsOrdered = getItemsOrdered();
        for (int i = 0; i < getQtyOrdered(); i++) {
            if (newItemsOrdered[i].equals(disc)) {
                indexOfRemoved = i;
                break;
            }
        }

        // If not found
        if (indexOfRemoved == -1) {
            System.out.println("The disc is not found");
            return;
        }

        // Remove DVD from Cart
        for (int i = indexOfRemoved; i < getQtyOrdered() - 1; i++) {
            newItemsOrdered[i] = newItemsOrdered[i + 1];
        }
        setQtyOrdered(getQtyOrdered() - 1);
        newItemsOrdered[getQtyOrdered() - 1] = null;
        setItemsOrdered(newItemsOrdered);

        // Notify
        System.out.println("The disc has been removed");
    }

    // Method to calculate the total cost
    public double totalCost() {
        double cost = 0;
        DigitalVideoDisc[] itemsOrdered = getItemsOrdered();
        for (DigitalVideoDisc disc: itemsOrdered) {
            if (disc != null) {
                cost += disc.getCost();
            }
        }

        return Math.round(cost * 100.0) / 100.0;
    }
    
    // Method to add list new DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc []dvdlist) {
    	// If cart is full
    	if (qtyOrdered + dvdlist.length > 20) {
    		System.out.println("The cart is almost full");
    		return;
    	}
    	
    	// Add to cart
    	System.arraycopy(dvdlist, 0, itemsOrdered, qtyOrdered, dvdlist.length);
    	
    	// Increase the qtyOrdered
        qtyOrdered += dvdlist.length;

        // Notify
        System.out.println("The list has been added");
    }

    // Method to add two new DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        // If cart is full
        if (qtyOrdered >= 19) {
            System.out.println("The cart is almost full");
            return;
        }

        // Increase the qtyOrdered
        qtyOrdered += 2;

        // Add to cart
        itemsOrdered[qtyOrdered - 2] = dvd1;
        itemsOrdered[qtyOrdered - 1] = dvd1;

        // Notify
        System.out.println("The disc has been added");
    }
    
    // Method to print the list of ordered items of a cart, the price of each item, and the total price
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null)
                dvd.printDVD();
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    // Method to search for DVDs in the cart by ID and display the search results.
    public void searchByID(int id) {
        boolean found = false;
        for (DigitalVideoDisc dvd: itemsOrdered) {
            if (dvd != null && dvd.getId() == id) {
                found = true;
                dvd.printDVD();
            }
        }
        if (!found) {
            System.out.println("Not found!");
        }
    }

    // Method to search for DVDs in the cart by title and print the results.
    public void searchByTitle(String title) {
        boolean found = false;
        for (DigitalVideoDisc dvd: itemsOrdered) {
            if (dvd != null && dvd.isMatch(title)) {
                found = true;
                dvd.printDVD();
            }
        }
        if (!found) {
            System.out.println("Not found!");
        }
    }
    
    public String toString() {
        StringBuilder details = new StringBuilder("Cart Details:\n");

        for (int i = 0; i < getQtyOrdered(); i++) { 
            DigitalVideoDisc disc = itemsOrdered[i];
            if (disc != null) { // Kiểm tra null trước khi sử dụng
                details.append("DVD ID: ").append(disc.getId())
                       .append(", Title: ").append(disc.getTitle())
                       .append(", Cost: ").append(disc.getCost()).append("\n");
            }
        }

        return details.toString();
    }
}