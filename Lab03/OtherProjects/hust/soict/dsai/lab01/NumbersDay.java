//Nguyen Thanh Vinh 20225779

import java.util.Scanner;

public class NumbersDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nguyen Thanh Vinh - 20225779 - Enter a month (E.g: January, Jan., Jan, or 1); ");
        String imonth = sc.next();
        int month;
        switch (imonth) {
            case "January":
            case "Jan.":
            case "Jan":
            case "1":
                month = 1;
                break;
            case "February":
            case "Feb.":
            case "Feb":
            case "2":
                month = 2;
                break;
            case "March":
            case "Mar.":
            case "Mar":
            case "3":
                month = 3;
                break;
            case "April":
            case "Apr.":
            case "Apr":
            case "4":
                month = 4;
                break;
            case "May":
            case "5":
                month = 5;
                break;
            case "June":
            case "Jun":
            case "6":
                month = 6;
                break;
            case "July":
            case "Jul":
            case "7":
                month = 7;
                break;
            case "August":
            case "Aug.":
            case "Aug":
            case "8":
                month = 8;
                break;
            case "September":
            case "Sept.":
            case "Sep":
            case "9":
                month = 9;
                break;
            case "October":
            case "Oct.":
            case "Oct":
            case "10":
                month = 10;
                break;
            case "November":
            case "Nov.":
            case "Nov":
            case "11":
                month = 11;
                break;
            case "December":
            case "Dec.":
            case "Dec":
            case "12":
                month = 12;
                break;
            default:
                System.out.println("Invalid month!");
                return;
        }
        System.out.println("Enter a year (E.g: 1999): ");
        int year = sc.nextInt();
        if (year <= 0) {
            System.out.println("Invalid year!");
            return;
        }
        if (year % 4 == 0 && month == 2) {
            System.out.println("29 days");
            return;
        } else if (month == 2) {
            System.out.println("28 days");
            return;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 days");
                return;
            default:
                System.out.println("31 days");
                return;
        }
    }
}