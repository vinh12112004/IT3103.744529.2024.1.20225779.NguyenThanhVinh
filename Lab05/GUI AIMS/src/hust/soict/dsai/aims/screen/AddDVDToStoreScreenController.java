package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddDVDToStoreScreenController {
	@FXML
    private TextField CategoryField;

    @FXML
    private TextField CostField;

    @FXML
    private TextField DirectorField;

    @FXML
    private TextField IDField;

    @FXML
    private TextField LengthField;

    @FXML
    private MenuItem MCartView;

    @FXML
    private MenuItem MStoreView;

    @FXML
    private TextField TitleField;

    @FXML
    private Button btnAddDVDToStore;
    
    private Store store;
    private Cart cart;

    @FXML
    void AddDVDToStorePressed(ActionEvent event) {
    	String idStr = IDField.getText();
        String title = TitleField.getText();
        String category = CategoryField.getText();
        String costStr = CostField.getText();
        String LengthStr = LengthField.getText();
        String Director = DirectorField.getText();
        
        int id = Integer.parseInt(idStr);
        Float cost = Float.parseFloat(costStr);
        int length = Integer.parseInt(LengthStr);
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, Director);
        store.addMedia(dvd);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add DVD to Store");
        alert.setHeaderText("thêm thành công " + dvd.getTitle()+ " vào store");
        alert.showAndWait();
        // Thông báo thêm thành công (tuỳ chọn)
        System.out.println("DVD added to store: " + dvd.getTitle());
    }
    
    public AddDVDToStoreScreenController(Cart cart,Store store) {
    	super();
    	this.store = store;
    	this.cart = cart;
    }
    @FXML
    void CartViewPressed(ActionEvent event) {

    }

    @FXML
    void StoreViewPressed(ActionEvent event) {
    	new StoreScreen(store,cart);
    }
}
