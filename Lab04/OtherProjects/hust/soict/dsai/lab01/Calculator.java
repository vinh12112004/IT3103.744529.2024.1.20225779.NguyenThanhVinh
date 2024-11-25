
// Nguyen Thanh Vinh 20225779
import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Nguyen Thanh Vinh - 20225779- Nhập a");
        String strNum2 = JOptionPane.showInputDialog("Nhập b");

        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
    }
}
