package days6;

import java.util.Scanner;

public class Democracy {

    public static void main(String[] args) {
        Object[][] Goods = new Object[50][4];
        Scanner scanner = new Scanner(System.in);
        Goods[0][0] = "商品名称";
        Goods[0][1] = "单价";
        Goods[0][2] = "数量";
        Goods[0][3] = "小计";
        int temp = 1, temp2 = 0;
        for (int i = 0; i < 50; i++) {
            System.out.println(Goods[temp2][0] + "\t" + Goods[temp2][1] + "\t" + Goods[temp2][2]);
            String Name = scanner.next();
            Double Price = scanner.nextDouble();
            int num = scanner.nextInt();
            Double money = Price * num;
            Goods[temp][0] = Name;
            Goods[temp][1] = Price;
            Goods[temp][2] = num;
            Goods[temp][3] = money;
            temp++;
            System.out.println("是否结束录入？y/n");
            if (scanner.next().equals("y")) {
                break;
            }
        }
        for (int i = 0; i < temp; i++) {
            System.out.println(Goods[temp2][0] + "\t" + Goods[temp2][1] + "\t" + Goods[temp2][2] + "\t" + Goods[temp2][3]);
            temp2++;
        }
        System.out.println("请选择  1.显示总价列表  2.显示排序列表  输入其他的表示退出");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                Output(Goods, temp);
                break;
            case 2:
                Sort(Goods, temp);
                break;
            default:
                System.exit(0);
        }
    }

    public static void Output(Object[][] Goods, int temp) {
        Scanner scanner = new Scanner(System.in);
        int Allnum = 0, temp2 = 1;
        Double Allmoney = 0.0;
        System.out.println(Goods[0][0] + "\t" + Goods[0][1] + "\t" + Goods[0][2] + "\t" + Goods[0][3]);
        for (int i = 1; i < temp; i++) {
            System.out.println(Goods[temp2][0] + "\t" + Goods[temp2][1] + "\t" + Goods[temp2][2] + "\t" + Goods[temp2][3]);
            Allnum = (int) Goods[temp2][2] + Allnum;
            Allmoney = (Double) Goods[temp2][3] + Allmoney;
            temp2++;
        }
        System.out.println("总计" + "\t" + "     " + "\t" + Allnum + "\t" + Allmoney);
        System.out.println("是否继续查看排序列表 ？y/n");
        char choose = scanner.next().charAt(0);
        if (choose == 'y') {
            Sort(Goods, temp);
        } else System.exit(0);
    }

    public static void Sort(Object[][] Goods, int temp) {
        Scanner scanner = new Scanner(System.in);
        Object[][] sort = new Object[50][4];
        for (int i = 0; i < 50; i++) {
            Object[] temp1 = Goods[i];
            sort[i] = temp1;
        }
        int temp2 = 0;
        for (int i = 1; i < temp; i++) {
            for (int j = 1; j < temp - i; j++) {
                if ((Double) sort[j][3] < (Double) sort[j + 1][3]) {
                    Object[] temp1 = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp1;
                }
            }
        }
        for (int i = 0; i < temp; i++) {
            System.out.println(sort[i][0] + "\t" + sort[i][1] + "\t" + sort[i][2] + "\t" + sort[i][3]);
        }
        System.out.println("是否继续查看总价列表？y/n");
        char choose = scanner.next().charAt(0);
        if (choose == 'y') {
            Output(Goods, temp);
        } else System.exit(0);
    }
}
