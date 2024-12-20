package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.media.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AddBookToStoreScreenController extends AddMediaToStoreScreenController {
	private Book book;
	private ArrayList<String> authors = new ArrayList<String>();
	private int numPages;

	@FXML
	private TextField tfAuthors;

	@FXML
	private TextField tfNumPages;

	public AddBookToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	public void initialize() {
		tfNumPages.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					numPages = Integer.parseInt(newValue);
				} catch (NumberFormatException e) {
					numPages = 0;
				}
			}

		});

		super.initialize();
	}

	@FXML
	private void addAuthorBtnPressed() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("You can add new author");
		dialog.setContentText("Please enter author name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			authors.add(result.get());
			if (tfAuthors.getText().length() == 0) {
				tfAuthors.setText(result.get());
			} else {
				tfAuthors.setText(tfAuthors.getText() + ", " + result.get());
			}
		}
	}

	@FXML
	protected void addBtnPressed() {
		book = new Book(1, this.title, this.category, this.numPages);
		for (String author : authors) {
			book.addAuthor(author);
		}
		try {
			store.addMedia(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText(book.getTitle() + " has been added to the store");
		alert.showAndWait();
	}
}