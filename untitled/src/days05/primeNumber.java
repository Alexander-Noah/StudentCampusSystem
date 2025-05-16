package days05;
import java.util.Scanner;
public class primeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x:while(true) {
            boolean bool=false;
            System.out.println("请输入一个数：");
            int h = sc.nextInt();
            if (h < 0) {
                System.out.println("只能输入整数，请重新输入！");
                continue x;
            }
            for (int i = 2;i<h; i++) {
                if (h % i == 0) bool=true;
            }
                if (bool) {
                    System.out.printf("不是素数！");
                } else {
                    System.out.printf("是素数！\n");
                }
                System.out.println("是否继续请输入（1（继续）或2（退出）)");
                int n = sc.nextInt();
                if (n == 1) {
                    continue x;
                }
                if (n == 2) {
                    break x;
                }
        }
    }
}
