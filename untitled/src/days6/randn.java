package days6;

import java.util.Arrays;

import java.util.Random;

public class randn {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = 50;//数组长度
        int b = 100;//随机数范围
        int arr[] = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(b);
        }
        for (int v = 0; v < arr.length - 1; v++) {
            for (int j = 0; j < arr.length - 1 - v; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr) + "");
    }
}
