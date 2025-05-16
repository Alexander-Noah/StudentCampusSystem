package days05;

import java.util.Scanner;

public class ArrayMaxDemo {
    public static void main(String[] args) {
        int arr[] = new int[20];
        d:
        for (; ; ) {
            switch (menu()) {
                case 1:
                    arr(arr);
                    break;
                case 2:
                    max(arr);
                    break;
                case 3:
                    input(arr);
                    break;
                case 4:
                    seek(arr);
                    break;
                case 5:
                    break d;
            }
        }
    }

    public static void arr(int arr[]) {//遍历数组方法
        int flat = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                break;
            }
            System.out.println(arr[i]);

        }
    }

    public static void max(int arr[]) {//求max数组方法
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.printf("\n");
        System.out.println("max:" + max);
    }

    public static void input(int arr[]) {//输入数值到数组
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数值：");
        s:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0) {
                break s;
            }
        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);//菜单
        System.out.println("1：遍历数组  2：最大值  3:录入数组   4：查找   5：退出");
        int a = sc.nextInt();
        return a;
    }

    public static void seek(int arr[]) {//查找
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        int h = 0;
        System.out.println("请输入一个要查找的数：");
        int a = sc.nextInt();
        s:
        for (int i = 0; i < arr.length; i++) {
            h = i + 1;
            if (arr[i] == a) {
                System.out.println(a + "在数组里的位置是" + h);
                flag = 1;
                break s;
            }

        }
        if (flag == 0) {
            System.out.println(a + "在数组中不存在");
        }
    }
}

