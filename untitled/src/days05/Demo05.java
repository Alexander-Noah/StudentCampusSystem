package days05;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        int n;
        // 定义求和变量sum，并赋初值0
        int sum = 0;
        // 定义变量i,并赋初值0
        int i = 0;
        //创建Scanner对象
        Scanner input = new Scanner(System.in);
        // 请在Begin-End间编写代码
        /********** Begin **********/
        // 获取输入值n
        n = input.nextInt();
        do {

            sum = sum + i;
            i++;

        }
        // 在while后判断条件，当i不小于n时退出循环
        while (i < n);
        // 输出平均值，保留两位小数
          double avg = (double) sum / n;
        // System.out.println(String.pormat("%.2f",sum));
        System.out.printf("%.2f", avg);
        /********** End **********/

    }

}
