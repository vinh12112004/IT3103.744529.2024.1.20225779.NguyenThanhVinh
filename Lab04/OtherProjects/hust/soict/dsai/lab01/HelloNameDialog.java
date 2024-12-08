
// Nguyen Thanh Vinh 20225779
import javax.swing.JOptionPane;

public class HelloNameDialog {
    static public void main(String args[]) {
        String name;
        name = JOptionPane.showInputDialog("Nguyen Thanh Vinh - 20225779 - Please enter your name:");
        JOptionPane.showMessageDialog(null, "hi " + name + "!");
        System.exit(0);
    }
}