module Lab06 {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires javafx.base;

	opens hust.soict.dsai.aims.screen to javafx.fxml;
	opens hust.soict.dsai.aims.media to javafx.base;


}
