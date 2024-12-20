package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {	
	@FXML
    private Pane drawingAreaPane;
	
	@FXML
    private ToggleGroup identical;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color inkColor = Color.BLACK;
    	if (eraserButton.isSelected()) {
    		inkColor = Color.WHITE;
    	}
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    private RadioButton penButton;
       
    @FXML
    private RadioButton eraserButton;
}
