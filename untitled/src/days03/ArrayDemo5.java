package days03;

import java.util.Scanner;

public class ArrayDemo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j] + "在数组的第" + (j + 1) + "个位置");

        }
    }
}