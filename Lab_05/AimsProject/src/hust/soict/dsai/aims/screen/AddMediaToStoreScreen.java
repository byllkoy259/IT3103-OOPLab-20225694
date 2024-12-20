package hust.soict.dsai.aims.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.*;

@SuppressWarnings("serial")
public class AddMediaToStoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public AddMediaToStoreScreen(Store store, Cart cart) {
		super();
		this.setStore(store);
		this.setCart(cart);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreScreen(store, cart);
			}
		});
	}

	JPanel createCenter() {
		return null;
	}

	public Media createMedia() {
		return null;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}