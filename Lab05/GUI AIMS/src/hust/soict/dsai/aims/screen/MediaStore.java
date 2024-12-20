package hust.soict.dsai.aims.screen;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        // Thiết lập giao diện chính
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tạo nút Play và thêm ActionListener
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            playButton.addActionListener(new PlayButtonListener());
            this.add(playButton);
        }

        // Tạo nút "Add to Cart" và thêm ActionListener
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCartButton.addActionListener(new AddToCartButtonListener());
        this.add(addToCartButton);

        // Thêm thông tin tiêu đề và giá
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());

        // Thêm border và kiểu hiển thị
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Lớp xử lý khi nhấn nút Play
     */
    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(null, 
                        "Playing: " + media.toString(), 
                        "Play Media", 
                        JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Error: Unable to play media - " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                    "This media cannot be played!", 
                    "Information", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    
    /**
     * Lớp xử lý khi nhấn nút "Add to Cart"
     */
    private class AddToCartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cart.addMedia(media);

            JOptionPane.showMessageDialog(null, 
                media.getTitle() + " has been added to the cart.", 
                "Cart", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
