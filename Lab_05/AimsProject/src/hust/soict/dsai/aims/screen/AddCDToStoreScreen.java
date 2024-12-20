package hust.soict.dsai.aims.screen;

import java.io.IOException;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.store.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AddCDToStoreScreen extends AddMediaToStoreScreen {
	public AddCDToStoreScreen(Store store, Cart cart) {
		super(store, cart);

		JFrame frame = this;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add CD to store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("addCDToStore.fxml"));
					AddCDToStoreScreenController controller = new AddCDToStoreScreenController(store, cart, frame);
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
		new AddCDToStoreScreen(new Store(), new Cart());
	}
}