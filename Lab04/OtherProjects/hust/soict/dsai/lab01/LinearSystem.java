
// Nguyen Thanh Vinh 20225779
import java.util.Scanner;

public class LinearSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nguyen Thanh Vinh - 20225779 - nhap a11: ");
        double a11 = sc.nextDouble();
        System.out.print("nhap a12: ");
        double a12 = sc.nextDouble();
        System.out.print("nhap b1: ");
        double b1 = sc.nextDouble();
        System.out.print("nhap a21: ");
        double a21 = sc.nextDouble();
        System.out.print("nhap a22: ");
        double a22 = sc.nextDouble();
        System.out.print("nhap b2: ");
        double b2 = sc.nextDouble();
        double det = a11 * a22 - a12 * a21;
        double det1 = b1 * a22 - b2 * a12;
        double det2 = a11 * b2 - a21 * b1;
        if (det == 0) {
            if ((a11 / a21) == (b1 / b2)) {
                System.out.println("he phuong trinh vo so nghiem");
            } else
                System.out.println("he phuong trinh vo nghiem");
        } else {
            System.out.println("x1 = " + (det1 / det) + "\nx2 = " + (det2 / det));
        }

    }
}
