package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.store.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class AddBookToStoreScreen extends AddMediaToStoreScreen{
	// Constructor
    public AddBookToStoreScreen(Store store, Cart cart) {
    	super(store, cart);

		JFrame frame = this;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add book to store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("addBookToStore.fxml"));
					AddBookToStoreScreenController controller = new AddBookToStoreScreenController(store, cart, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
	}

	public static void main(String[] args) {
		new AddBookToStoreScreen(new Store(), new Cart());
	}

	@Override
	JPanel createCenter() {
		return null;
	}

	@Override
	public Media createMedia() {
		return null;
	}
}