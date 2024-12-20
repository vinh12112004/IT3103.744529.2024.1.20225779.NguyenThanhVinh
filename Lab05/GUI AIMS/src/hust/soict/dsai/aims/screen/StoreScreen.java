package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.cart.Cart;

public class StoreScreen extends JFrame {
    

    // Tạo phần NORTH (Menu + Header)
    JPanel createNORTH() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo menu bar với các menu và sự kiện
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");

        smUpdateStore.add(addBookMenuItem);
        smUpdateStore.add(addCDMenuItem);
        smUpdateStore.add(addDVDMenuItem);

        menu.add(smUpdateStore);

        JMenuItem viewStoreMenuItem = new JMenuItem("View store");
        menu.add(viewStoreMenuItem);

        JMenuItem viewCartMenuItem = new JMenuItem("View cart");
        menu.add(viewCartMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        // Thêm ActionListener cho menu items
        addBookMenuItem.addActionListener(new BookView());
        addCDMenuItem.addActionListener(new CDView());
        addDVDMenuItem.addActionListener(new DVDView());
        viewStoreMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "View store clicked."));
        viewCartMenuItem.addActionListener(new CartView());

        return menuBar;
    }

    // Tạo Header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        
     // Trong StoreScreen, cập nhật sự kiện cho nút "View Cart"
        cartButton.addActionListener(new CartView());


        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Tạo phần trung tâm
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 5, 5));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        
        // Kiểm tra nếu không có sản phẩm
        if (mediaInStore == null || mediaInStore.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The store has no items.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
                MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
                center.add(cell);
            }
        }

        return center;
    }
    
    private class CartView implements ActionListener{
    	@Override 
    	public void actionPerformed(ActionEvent e) {
    		
                // Đóng cửa sổ hiện tại của StoreScreen
                dispose();

                // Mở CartScreen mới với đối tượng cart hiện tại
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new CartScreen(cart,store); // Tạo mới CartScreen và truyền cart vào
                    }
                });
            
    	}
    }
    
    private class CDView implements ActionListener{
    	@Override 
    	public void actionPerformed(ActionEvent e) {
    		
                // Đóng cửa sổ hiện tại của StoreScreen
                dispose();

                // Mở CartScreen mới với đối tượng cart hiện tại
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AddCompactDiscToStoreScreen(cart,store); // Tạo mới CartScreen và truyền cart vào
                    }
                });
            
    	}
    }
    private class DVDView implements ActionListener{
    	@Override 
    	public void actionPerformed(ActionEvent e) {
    		
                // Đóng cửa sổ hiện tại của StoreScreen
                dispose();

                // Mở CartScreen mới với đối tượng cart hiện tại
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new addDVDToStoreScreen(cart,store); // Tạo mới CartScreen và truyền cart vào
                    }
                });
            
    	}
    }
    
    private class BookView implements ActionListener{
    	@Override 
    	public void actionPerformed(ActionEvent e) {
    		
                // Đóng cửa sổ hiện tại của StoreScreen
                dispose();

                // Mở CartScreen mới với đối tượng cart hiện tại
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AddBookToStoreScreen(cart,store); // Tạo mới CartScreen và truyền cart vào
                    }
                });
            
    	}
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNORTH(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Cart cart;
    private Store store;

    public static void main(String[] args) {
    	Store store = new Store();
		Cart cart = new Cart();
        store.addMedia(new Book(1, "sportbook2vn","the thao", 1000));
        store.addMedia(new CompactDisc(2, "999 doa hoa hong","nhac vang",999,180, "remix","Ly Hai"));
        store.addMedia(new DigitalVideoDisc(3, "sieu nhan gao","hanh dong", 750));
        store.addMedia(new Book(4, "Java Programming", "Education", 29.99f, "Herbert Schildt"));
        store.addMedia(new CompactDisc(5, "The Best of The Beatles", "Music", 15.99f, 70, "George Martin", "The Beatles"));
        store.addMedia(new DigitalVideoDisc(6, "The Matrix", "Action", 19.99f, 136, "Lana Wachowski"));
        new StoreScreen(store,cart);
    }
}
