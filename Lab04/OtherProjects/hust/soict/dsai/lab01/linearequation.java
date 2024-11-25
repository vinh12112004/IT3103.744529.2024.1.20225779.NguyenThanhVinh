
// Nguyen Thanh Vinh 20225779
import java.util.Scanner;

public class linearequation {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nguyen Thanh Vinh - 20225779 - nhap a: ");
            int a = sc.nextInt();
            System.out.println("nhap b: ");
            int b = sc.nextInt();
            if (a == 0) {
                if (b == 0) {
                    System.out.println("phuong trinh vo so nghiem");
                } else
                    System.out.println("phuong trinh vo nghiem");
            } else
                System.out.println("phuong trinh co nghiem x=" + (-b / a));
        }
    }
}
