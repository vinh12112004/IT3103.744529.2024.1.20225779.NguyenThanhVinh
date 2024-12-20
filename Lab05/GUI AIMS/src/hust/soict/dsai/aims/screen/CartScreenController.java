package hust.soict.dsai.aims.screen;



import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {
	private Store store;
	
	private Cart cart;
	
	@FXML
    private MenuItem MStoreView;
	
	
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
	
	
	
	@FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartScreenController(Cart cart, Store store) {
    	super();
    	this.cart= cart;
    	this.store = store;
    }
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private Label totalcost;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private void initialize() {
        System.out.println("Initializing the Cart Screen...");
        
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        if (this.cart != null) {
            System.out.println("Setting items to table...");
            tblMedia.setItems(this.cart.getItemsOrdered());
            setlabeltotalcost();
        } else {
            System.out.println("Cart is null");
        }
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        	new ChangeListener<Media>() {
        		
        		@Override
        		public void changed(ObservableValue<? extends Media> observable ,Media oldValue, Media newValue) {
        			if(newValue!=null) {
        				updateButtonBar(newValue);
        				setlabeltotalcost();
        			}
        		}
        	}
        );
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
        		@Override
        		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		showFilteredMedia(newValue);
        		}}
        		);
        
        setlabeltotalcost();

        
    }
    
    void setlabeltotalcost() {
    	totalcost.setText(cart.totalCost() +" $");
    }
    
    @FXML
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}else btnPlay.setVisible(false);
    }
    
    @FXML
    void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        tblMedia.setItems(cart.getItemsOrdered());
        setlabeltotalcost();
    }

    @FXML
    private void showFilteredMedia(String searchQuery) {
        ObservableList<Media> filteredMedia;

        // Nếu searchQuery là null hoặc chuỗi rỗng, trả về tất cả phần tử trong giỏ hàng
        if (searchQuery == null || searchQuery.isEmpty()) {
            filteredMedia = cart.getItemsOrdered();  // Lấy tất cả các phần tử trong giỏ hàng
        } else if (radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(searchQuery);  // Chuyển searchQuery thành số nguyên
                filteredMedia = cart.searchById(id);  // Lấy kết quả tìm kiếm theo ID
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
                return;  // Nếu không thể chuyển đổi thành số, không làm gì cả
            }
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredMedia = cart.searchByTitle(searchQuery);  // Lấy kết quả tìm kiếm theo Title
        } else {
            return;  // Nếu không có bộ lọc nào được chọn, không làm gì cả
        }

        // Cập nhật TableView với các kết quả tìm kiếm
        tblMedia.setItems(filteredMedia);
    }

    @FXML
    void PlaceOrderPressed() {
    	cart.placeMedia();
    	tblMedia.setItems(cart.getItemsOrdered());
        setlabeltotalcost();
    }
    
    
    @FXML
    public void playButtonPressed() {
        Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        
        // Nếu không có media nào được chọn
        if (media == null) {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("No Media Selected");
                alert.setHeaderText("No media has been selected.");
                alert.setContentText("Please select a media item from the table to view its details.");
                alert.showAndWait();
            });
            return;
        }

        // Hiển thị thông tin media
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Play Media");
            alert.setHeaderText(media.toString());
            alert.showAndWait();
        });
    }

    @FXML
    void StoreViewPressed() {
    	new StoreScreen(store, cart);
    }
    
    

}
