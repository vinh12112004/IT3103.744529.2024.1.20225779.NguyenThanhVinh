package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends JFrame {
		private Cart cart;
		
		private Store store;
		
		public AddBookToStoreScreen(Cart cart, Store store) {
			super();
			
			this.cart = cart;
			this.store = store;
			
			JFXPanel fxPanel = new JFXPanel();
			this.add(fxPanel);
			
			this.setTitle("AddBook");
			this.setVisible(true);
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addBookScreen.fxml"));
						AddBookToStoreController controller = new AddBookToStoreController(cart,store);
						loader.setController(controller);
						Parent root = loader.load();
						fxPanel.setScene(new Scene(root));
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
}





