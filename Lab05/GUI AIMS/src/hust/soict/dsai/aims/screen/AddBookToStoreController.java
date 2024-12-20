package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddBookToStoreController {
	private Store store;
	
	private Cart cart;
	
	@FXML
    private MenuItem MCartView;
	
	@FXML
    private MenuItem MStoreView;

	@FXML
    private Button btnAddBookToStore;
	
	@FXML
    private TextField AuthorField;

    @FXML
    private TextField CategoryField;

    @FXML
    private TextField CostField;

    @FXML
    private TextField IDField;

    @FXML
    private TextField TitleField;

    
    public AddBookToStoreController(Cart cart, Store store) {
    	super();
    	this.cart= cart;
    	this.store = store;
    }
    
    @FXML
    void StoreViewPressed() {
    	new StoreScreen(store, cart);
    }
    
    @FXML
    void AddBookToStorePressed(ActionEvent event) {
    	 
        // Lấy giá trị từ các TextField
        String idStr = IDField.getText(); // ID
        String title = TitleField.getText(); // Title
        String category = CategoryField.getText(); // Category
        String costStr = CostField.getText(); // Cost
        String author = AuthorField.getText(); // Author

        // Chuyển ID và cost thành kiểu dữ liệu số
        int id = Integer.parseInt(idStr);
        float cost = Float.parseFloat(costStr);

        // Tạo đối tượng Book với các thông tin lấy được
        Book newBook = new Book(id, title, category, cost, author);

        // Thêm sách vào Store
        store.addMedia(newBook);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add Book to Store");
        alert.setHeaderText("thêm thành công " + newBook.getTitle()+ " vào store");
        alert.showAndWait();
        // Thông báo thêm thành công (tuỳ chọn)
        System.out.println("Book added to store: " + newBook.getTitle());
    }
    
    @FXML
    void CartViewPressed() {
    	Platform.runLater(new Runnable() {
            @Override
            public void run() {
                new CartScreen(cart, store); // Tạo mới CartScreen và truyền cart vào
            }
        });
    }
}
