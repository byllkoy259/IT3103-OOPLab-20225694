package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.store.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public abstract class AddMediaToStoreScreenController {
	protected Store store;
	protected Cart cart;
	private JFrame stage;

	protected String title;
	protected String category;
	protected float cost;

	@FXML
	protected TextField tfTitle;

	@FXML
	protected TextField tfCategory;

	@FXML
	protected TextField tfCost;

	public AddMediaToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super();
		this.store = store;
		this.cart = cart;
		this.stage = stage;
	}

	@FXML
	public void initialize() {

		tfTitle.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				title = newValue;
			}
		});

		tfCategory.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				category = newValue;
			}
		});

		tfCost.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					Float number = Float.parseFloat(newValue);
					cost = number;
				} catch (NumberFormatException e) {
					cost = 0f;
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	@FXML
	protected void viewStore() {
		new StoreScreen(store, cart);
		stage.hide();
	}

	@SuppressWarnings("deprecation")
	@FXML
	protected void viewCart() {
		new CartScreen(store, cart);
		stage.hide();
	}

	@SuppressWarnings("deprecation")
	@FXML
	protected void addBookToStore() {
		new AddBookToStoreScreen(store, cart);
		stage.hide();
	}

	@SuppressWarnings("deprecation")
	@FXML
	protected void addCDToStore() {
		new AddCDToStoreScreen(store, cart);
		stage.hide();
	}

	@SuppressWarnings("deprecation")
	@FXML
	protected void addDVDToStore() {
		new AddDVDToStoreScreen(store, cart);
		stage.hide();
	}

	@FXML
	protected abstract void addBtnPressed() throws Exception;
}