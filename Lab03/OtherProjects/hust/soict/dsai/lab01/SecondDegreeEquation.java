
// Nguyen Thanh Vinh 20225779
import java.util.Scanner;

public class SecondDegreeEquation {
    public static void main(String args[]) {
        System.out.println("Nguyen Thanh Vinh - 20225779 - nhap a, b, c: ");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double delta = b * b - 4 * a * c;
        double result;
        if (a == 0) {
            result = -c / b;
            System.out.println("phuong trinh co nghiem duy nhat la: " + result);
        } else if (delta < 0) {
            System.out.println("phuong trinh vo nghiem");
        } else if (delta == 0) {
            result = -b / (2 * a);
            System.out.println("phuong trinh co nghiem kep la: " + result);
        } else {
            double result1 = (-b + Math.pow(delta, 0.5)) / (2 * a);
            double result2 = (-b - Math.pow(delta, 0.5)) / (2 * a);
            System.out.println("phuong trinh co 2 nghiem la: " + result1 + " va " + result2);
        }
        System.exit(0);
    }
}