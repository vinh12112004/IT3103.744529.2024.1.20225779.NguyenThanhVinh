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

public class CartScreen extends JFrame {
	private Cart cart;
	
	private Store store;
	
	public CartScreen(Cart cart, Store store) {
		super();
		
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart,store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
//	public static void main(String[] args) {
//	    
//	        Cart cart = new Cart();
//	        Book spb2vn = new Book(1, "sportbook2vn","the thao", 1000);
//	        CompactDisc doahoahong = new CompactDisc(2, "999 doa hoa hong","nhac vang",999,180, "remix","Ly Hai" );
//	        DigitalVideoDisc sieunhangao = new DigitalVideoDisc(3, "sieu nhan gao","hanh dong", 750);
//	        cart.addMedia(spb2vn);
//	        cart.addMedia(doahoahong);
//	        cart.addMedia(sieunhangao);
//	        new CartScreen(cart);
//	        
//	}

}	


