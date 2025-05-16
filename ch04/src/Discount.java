import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//引用Scanner
        System.out.println("请输入消费金额：");
        double money1 = sc.nextDouble();//金额输入
        System.out.println("请输入会员等级：(1.普通会员  2.黄金会员   3.钻石会员   4.非会员)");
        char grade = sc.next().charAt(0);//会员等级输入
        double money=money1;
        switch (grade) {
            case '1'://普通会员
                money =money1*0.95;
                break;
            case '2'://黄金会员
                money =money1*0.9;
                if(money1>=500)
                {
                    money-=50;
                }
                break;

            case '3'://钻石会员
                money *= 0.85;
                if(money1>=500){
                    money-=80;
                }
                else if(money1>=300)
                {
                    money-=40;
                }
                else if(money1>=200)
                {
                    money-=20;
                }
                System.out.println(money);
                break;
            case '4'://非会员
                System.out.println("是否加入沃尔玛会员：(false或true)");//是否加入会员
                boolean c= sc.nextBoolean();
                if(c==true) {
                    System.out.println("感谢您加入沃尔玛超市会员!");
                    money *= 0.98;
                }

        }
        System.out.println("您的商品金额是：" + '$' + String.format("%.2f", money));
        System.out.println("谢谢惠顾，欢迎下次光临！");
    }
}

