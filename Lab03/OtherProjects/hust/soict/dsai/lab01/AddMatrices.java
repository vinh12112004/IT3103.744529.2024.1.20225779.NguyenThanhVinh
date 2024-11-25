
// Nguyen Thanh Vinh 20225779
import java.util.Scanner;

public class AddMatrices {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nguyen Thanh Vinh - 20225779 - nhap so dong cua ma tran ");
        int a = sc.nextInt();
        System.out.print("Nguyen Thanh Vinh - 20225779 - nhap so cot cua ma tran ");
        int b = sc.nextInt();
        double[][] arr1 = new double[a][b];
        double[][] arr2 = new double[a][b];
        double[][] sum = new double[a][b];
        System.out.println("nhap ma tran 1");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("nhap ma tran 2");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr2[i][j] = sc.nextDouble();
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("tong 2 ma tran");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}