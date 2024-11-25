
// Nguyen Thanh Vinh 20225779
//6.2
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nguyen Thanh Vinh - 20225779 - What's your name?");
        String strName = sc.nextLine();
        System.out.println("How old are you?");
        int iAge = sc.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = sc.nextDouble();
        System.out.println("Mr/Mrs. " + strName + ", " + iAge + " year(s) old. Your height is " + dHeight + ".");
        System.exit(0);
    }
}