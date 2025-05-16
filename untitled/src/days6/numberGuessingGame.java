package days6;

import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int a = 100;
        n:
        for (; ; ) {
            System.out.println("请输入数值（1~100）");
            int number2 = rand.nextInt(a);
            s:
            for (; ; ) {
                int number1 = sc.nextInt();
                if (number1 < number2) {
                    System.out.println("小了");
                    continue s;
                } else if (number1 == number2) {
                    System.out.println("恭喜你！猜对了");
                    break;
                } else if (number1 > number2) {
                    System.out.println("大了");
                    continue s;
                }
            }
            System.out.println("1:继续，2：退出");
            int number3 = sc.nextInt();
            if (number3 == 2) {
                break n;
            }
        }
    }
}
