package days03;

import java.util.Scanner;

public class 数组笔记 {
    public static void main(String[] args) {
//        int x[] = new int[10];
//        System.out.println("x=" + x[0]);
        //下标越界
//        int arr[]=new int [10];
//        arr[3]=10;
//        System.out.println(arr[3]);

        //迭代：从头到尾依次执行
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
//        int i = 0;
        for(int i = 0;i < arr.length;i++){
            arr[i++] = sc.nextInt();
        }
        //使用foreach取值
        //变量只能在for的小括号中声明
        //变量中的值每次迭代出来的数据
        //总是从第一个元素到最后一个
        System.out.println("输出：");
        for(int x : arr){
            System.out.println(x);
        }
    }
}
