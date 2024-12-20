package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/javafx/Painter.fxml"));
		
		Scene scene = new Scene(root);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.show();
	}
	@Override
    public void init() throws Exception {
        // Dùng nếu cần thực hiện các thao tác khởi tạo trước khi hiển thị giao diện
        System.out.println("Application is initializing...");
    }

    @Override
    public void stop() throws Exception {
        // Dùng nếu cần làm sạch tài nguyên hoặc xử lý logic khi ứng dụng tắt
        System.out.println("Application is stopping...");
    }
	public static void main(String[] args) {
		launch(args);
	}
}
