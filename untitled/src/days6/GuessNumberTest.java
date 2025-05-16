package days6;
//一、需求
//        1、使用面向对象的方法实现猜数字的功能，从控制台输入一个数的生成范围，系统根据范围生成一个随机整数，再从控制台接收整
//        数录入，判断与生成的整数是否相等，如果小于生成的数，提示“太小了”，如果大于生成的数，提示“太大了”，反复执行录入直至相
//        等为止，输出使用了多少次猜中。
//        二、要求
//        1、类名：GuessNumber
//        2、字段：最小值、最大值、生成的随机数、次数，要求对字段进行封装
//        3、有参构造方法，传入最大值和最小值，生成随机数，初始化次数为0
//        1、//根据范围生成的随机整数
//        2 、int num=（int）（Math.random(）（max- min +1）)+min
//        4、比较的方法：judge，方法参数为一个整数，功能是判断此整数是否与随机数数相同，并输出提示信息，返回是否猜中状态
//        5、猜数字的方法：guess，功能为接收录入的数，调用udge方法，根据方法的返回结果判断是否继续录入。如果结束，则输出使用
//        的次数。
//        6、创建GuessNumberTest类，类中声明main方法，接收两个数，并创建GuessNumber对象，实现猜数字的功能

import java.util.Random;
import java.util.Scanner;
public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入最小值：");
        int min = scanner.nextInt();

        System.out.print("请输入最大值：");
        int max = scanner.nextInt();

        GuessNumber game = new GuessNumber(min, max);
        game.guess();

        scanner.close();
    }
}

