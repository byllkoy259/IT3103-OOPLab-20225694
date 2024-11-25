package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		
		// Create a new cart
        Cart anOrder = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        System.out.println(anOrder.toString());

        // Print number of DVD in cart
        System.out.print("Number of DVD is: ");
        System.out.println(DigitalVideoDisc.getNbDigitalVideoDiscs());
        
        // Print id of dvd3
        System.out.print("Id of dvd3 is: ");
        System.out.println(dvd3.getId());
        
        // Print total cost
        System.out.print("Total Cost is: " + anOrder.totalCost());
	}
}
