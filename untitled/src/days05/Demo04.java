package days05;
import java.util.Scanner;
public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 声明 int 类型的变量 y 用来获取控制台输入的年
        int y = scanner.nextInt();
        // 声明 int 类型的变量 m 用来获取控制台输入的月
        int m = scanner.nextInt();
        // 声明 int 类型的变量 d 用来获取控制台输入的日
        int d = scanner.nextInt();

        /********** Begin **********/
        // 第一步：判断变量 m 的值是否是 1 或者 2。如果是，则变量 m 在原来的基础上加12，同时变量 y 在原来的基础上减1
        if (m == 1 || m == 2) {
            m = m + 12;
            y = y - 1;
        }

        // 第二步：使用基姆拉尔森日期公式，计算星期几
         int iweek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
        System.out.println(iweek);
        // 第三步：使用多路分支判断星期几。如果是星期一，则在控制台输出"星期一"；如果是星期二，则在控制台输出"星期二"....以此类推，如果是星期日，就是在控制台输出"星期日"
        switch(iweek){
            case 0:System.out.println("星期一");break;
            case 1:System.out.println("星期二");break;
            case 2:System.out.println("星期三");break;
            case 3:System.out.println("星期四");break;
            case 4:System.out.println("星期五");break;
            case 5:System.out.println("星期六");break;
            case 6:System.out.println("星期日");break;

        }
    }
}
