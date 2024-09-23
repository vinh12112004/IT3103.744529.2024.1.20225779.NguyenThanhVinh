
import javax.swing.JOptionPane;

public class HelloNameDialog {
    static public void main(String args[]){
        String name;
        name = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "hi " + name + "!");
        System.exit(0);
    }
}
