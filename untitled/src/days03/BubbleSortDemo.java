package days03;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //动态创建数组
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int z = 0; z < arr.length; z++) {
            for (int j = 0; j < arr.length - 1 - z; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
