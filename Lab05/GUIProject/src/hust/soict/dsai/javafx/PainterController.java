package hust.soict.dsai.javafx;

import java.awt.event.KeyEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	Color penColor = Color.WHITE;
	@FXML
    private Pane drawingAreaPane;

	@FXML
    private ToggleGroup tool;
	
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, penColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void Pen(ActionEvent event) {
    	penColor = Color.BLACK;
    }
    @FXML
    void Eraser(ActionEvent event) {
    	penColor = Color.WHITE;
    }
    
    
}
