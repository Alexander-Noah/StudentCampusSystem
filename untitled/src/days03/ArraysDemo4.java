package days03;

import java.util.Scanner;

public class ArraysDemo4 {
    public static void main(String[] args) {
        //求sum=a+aa+aaa+aaaa+aa…a的值
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入数字的值:");
        int a = reader.nextInt();
        System.out.print("请输入循环次数:");
        int x = reader.nextInt();
        int b = a, sum = a;
        for (int i = 1; i < x; i++) {
            a = a * 10 + b;
            sum += a;
        }
        System.out.println("结果为:" + sum);
    }
}
