package hust.soict.dsai.aims.screen;
	
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddCompactDiscToStoreController {
	@FXML
    private TextField ArtistField;

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
    private Button btnAddCDToStore;
    
    private Store store;
    private Cart cart;
    
    public AddCompactDiscToStoreController(Cart cart, Store store){
    	super();
    	this.cart = cart;
    	this.store = store;
    }

    @FXML
    void AddCDToStorePressed(ActionEvent event) {
    	String idStr = IDField.getText();
        String title = TitleField.getText();
        String category = CategoryField.getText();
        String costStr = CostField.getText();
        String LengthStr = LengthField.getText();
        String Director = DirectorField.getText();
        String Artist = ArtistField.getText();
        
        int id = Integer.parseInt(idStr);
        Float cost = Float.parseFloat(costStr);
        int length = Integer.parseInt(LengthStr);
        
        CompactDisc cd = new CompactDisc(id, title, category, cost, length, Director, Artist);
        store.addMedia(cd);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add CD to Store");
        alert.setHeaderText("thêm thành công " + cd.getTitle()+ " vào store");
        alert.showAndWait();
        // Thông báo thêm thành công (tuỳ chọn)
        System.out.println("CD added to store: " + cd.getTitle());
    }
    

    @FXML
    void CartViewPressed(ActionEvent event) {

    }

    @FXML
    void StoreViewPressed(ActionEvent event) {
    	new StoreScreen(store,cart);
    }

}
