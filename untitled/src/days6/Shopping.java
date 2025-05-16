package days6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Shopping {
    private static ArrayList<Object[]> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inputProducts();
        showMenu();
    }

    public static void inputProducts() {
        System.out.println("=== 商品信息录入 ===");
        while (true) {
            Object[] product = new Object[4];

            System.out.print("输入商品名称：");
            product[0] = scanner.next();

            System.out.print("输入商品单价：");
            product[1] = scanner.nextDouble();

            System.out.print("输入商品数量：");
            product[2] = scanner.nextInt();

            // 计算小计
            product[3] = (Double) product[1] * (Integer) product[2];

            products.add(product);

            System.out.print("继续录入？(y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                break;
            }
        }
        lst(false);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n=== 功能菜单 ===");
            System.out.println("1. 显示商品列表");
            System.out.println("2. 计算总价");
            System.out.println("3. 按小计排序");
            System.out.println("4. 退出系统");
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    lst(false);
                    break;
                case 2:
                    clst();
                    break;
                case 3:
                    sbt();
                    break;
                case 4:
                    System.out.println("系统已退出");
                    System.exit(0);
                default:
                    System.out.println("无效输入！");
            }
        }
    }

    public static void lst(boolean showTotal) {
        System.out.println("\n商品名称\t单价\t数量\t小计");
        System.out.println("-----------------------------------");

        for (Object[] product : products) {
            System.out.printf("%-8s\t%-6.2f\t%-4d\t%-8.2f%n",
                    product[0], (Double) product[1],
                    (Integer) product[2], (Double) product[3]);
        }

        if (showTotal) {
            int totalQuantity = 0;
            double totalAmount = 0.0;
            for (Object[] product : products) {
                totalQuantity += (Integer) product[2];
                totalAmount += (Double) product[3];
            }
            System.out.println("-----------------------------------");
            System.out.printf("总计\t\t\t%-4d\t%-8.2f%n", totalQuantity, totalAmount);
        }
    }

    public static void clst() {
        lst(true);
    }

    public static void sbt() {
        ArrayList<Object[]> sortedList = new ArrayList<>(products);

        Collections.sort(sortedList, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] p1, Object[] p2) {
                return Double.compare((Double) p2[3], (Double) p1[3]);
            }
        });

        System.out.println("\n=== 按小计降序排序 ===");
        System.out.println("商品名称\t单价\t数量\t小计");
        System.out.println("-----------------------------------");

        for (Object[] product : sortedList) {
            System.out.printf("%-8s\t%-6.2f\t%-4d\t%-8.2f%n",
                    product[0], (Double) product[1],
                    (Integer) product[2], (Double) product[3]);
        }
    }

}


