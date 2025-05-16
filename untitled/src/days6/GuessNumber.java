package days6;
//        1、类名：GuessNumber
//        2、字段：最小值、最大值、生成的随机数、次数，要求对字段进行封装
//        十3、有参构造方法，传入最大值和最小值，生成随机数，初始化次数为0
//        1、//根据范围生成的随机整数
//        2 、int num=（int）（Math.random(）（max- min +1）)+min
//        4、比较的方法：judge，方法参数为一个整数，功能是判断此整数是否与随机数数相同，并输出提示信息，返回是否猜中状态
//        5、猜数字的方法：guess，功能为接收录入的数，调用judge方法，根据方法的返回结果判断是否继续录入。如果结束，则输出使用
//        的次数。

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    // 封装字段
    private final int min;
    private final int max;
    private int targetNumber; // 移除了final，因为需要重新生成
    private int count;
    private Scanner scanner;

    // 有参构造方法
    public GuessNumber(int min, int max) {
        this.min = min;
        this.max = max;
        this.scanner = new Scanner(System.in);
        this.targetNumber = generateRandomNumber(min, max);
        this.count = 0;
    }

    // 生成随机数（私有方法）
    private int generateRandomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    // 判断猜测结果
    public boolean judge(int guess) {
        count++; // 每次判断增加尝试次数

        if (guess < targetNumber) {
            System.out.println("太小了！");
            return false;
        } else if (guess > targetNumber) {
            System.out.println("太大了！");
            return false;
        } else {
            System.out.println("恭喜你，猜对了！");
            return true;
        }
    }

    // 猜数字主流程
    public void guess() {

        while (true) {
            System.out.print("请输入你的猜测：");

            // 输入验证（仅验证是否为整数）
            while (!scanner.hasNextInt()) {
                System.out.println("请输入一个有效的整数！");
                scanner.next(); // 清除无效输入
                System.out.print("请重新输入：");
            }

            int guess = scanner.nextInt();

            if (judge(guess)) {
                System.out.printf("你总共猜了%d次。\n", count);
                askToContinue();
                break;
            }
        }
    }

    // 询问是否继续
    private void askToContinue() {
        System.out.print("是否继续游戏？(y/n): ");
        String choice = scanner.next().toLowerCase();

        if (choice.equals("y")) {
            // 重置游戏状态
            this.targetNumber = generateRandomNumber(min, max);
            this.count = 0;
            guess(); // 重新开始游戏
        } else {
            System.out.println("游戏结束，谢谢游玩！");
            scanner.close();
        }
    }

    // Getter方法
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getcount() {
        return count;
    }
    public  int setMin(int min) {
        return min;
    }
    public  int setMax(int max) {
        return max;
    }
    public int setCount(int count){
        return count;
    }
}
