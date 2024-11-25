
// Nguyen Thanh Vinh 20225779
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String args[]) {
        System.out.print("Nguyen Thanh Vinh - 20225779 - Nhap do dai mang ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]=");
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        double avarage = (double) sum / n;
        Arrays.sort(arr);
        System.out.print("mang sau khi sap xep:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println("\ntong cac phan tu trong mang: " + sum);
        System.out.println("trung binh cong cac ptu trong mang: " + avarage);
    }
}