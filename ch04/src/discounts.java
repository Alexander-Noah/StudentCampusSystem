import java.util.Scanner;

public class discounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        double money = sc.nextDouble();
        System.out.println("请输入会员等级：");
        char grade = sc.next().charAt(0);
        switch (grade) {
            case '1':
                money *= 0.95;
                break;
            case '2':
                money *= 0.9;
                break;

            case '3':
                money *= 0.85;
                break;
            case '4':
                System.out.println("感谢您加入沃尔玛超市会员!");
                money *= 0.98;
            default: {
                break;
            }
        }
        System.out.println("您的商品金额是：" + '$' + String.format("%.2f", money));
        System.out.println("谢谢惠顾，欢迎下次光临！");
    }
}
