package hust.soict.dsai.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private int numOfDVDs;
    
    // Constructor
    public Cart() {
        numOfDVDs = 0;
    }
    
    // Method to add a new media
    public void addMedia(Media media) throws Exception {
        if (itemsOrdered.contains(media)) {
            throw new Exception("Media is already in the list");
        }
        itemsOrdered.add(media);
        if (media instanceof DigitalVideoDisc) {
            numOfDVDs++;
        }
        System.out.println("Added to cart successful");
    }

    // Method to remove a media
    public void removeMedia(Media media) throws Exception {
        // Search for media
        int indexOfRemoved = itemsOrdered.indexOf(media);

        // If not found
        if (indexOfRemoved == -1) {
            throw new Exception("Not found");
        }

        // Remove
        itemsOrdered.remove(media);
        if (media instanceof DigitalVideoDisc) {
            numOfDVDs--;
        }

        // Notify
        System.out.println("Removed");
    }
    
    // Method to calculate the total cost
    public double totalCost() {
        float cost = 0;
        for (Media media: itemsOrdered) {
            cost += media.getCost();
        }

        return Math.round(cost * 100.0) / 100.0;
    }
    
    // Method to print the list of ordered items of a cart, the price of each item, and the total price
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            media.print();
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    // Method to search for DVDs in the cart by ID and display the search results.
    public boolean searchByID(int id) {
		for (int i = 0; i < numOfDVDs; i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println(itemsOrdered.get(i).toString());
				return true;
			}
		}
		return false;
	}

    // Method to search for DVDs in the cart by title and print the results.
    public boolean searchByTitle(String title) {
		for (int i = 0; i < numOfDVDs; i++) {
			if (itemsOrdered.get(i).getTitle() == title) {
				System.out.println(itemsOrdered.get(i).toString());
				return true;
			}
		}
		return false;
	}
    
    public void empty() {
		this.itemsOrdered.clear();
		numOfDVDs = 0;
	}
    
    public Media searchMedia(String title) {
		for (Media medium : this.itemsOrdered) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}
    
    // Method to sort by title and print
    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE);
        printCart();
    }

    // Method to sort by cost and print
    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST);
        printCart();
    }

    // Getter and Setter
    public int getNumOfDVDs() {
        return numOfDVDs;
    }
    public void setNumOfDVDs(int numOfDVDs) {
        this.numOfDVDs = numOfDVDs;
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	
	public int getLength() {
		return numOfDVDs;
	}

}