package days6;

import java.util.Scanner;

public class goshooping {

    /**
     * 类的说明：
     * 假设你正在开发一个电商网站的购物车功能。使用二维数组来模拟用户的购物车，每一行代表一个商品，包括商品名称、单价和数量。编写一个程序实现以下功能：
     * <p>
     * 向购物车中添加商品。
     * 从购物车中删除商品。
     * 修改购物车中某个商品的数量。
     * 计算购物车中所有商品的总价。
     * 格言：认认真真敲代码
     *
     * @author 汤老师
     * @date 2024/3/26 17:26
     */


    private static final int MAX_PRODUCTS = 100; // 最大商品数量
    private static final int PRODUCT_FIELDS = 3; // 商品信息字段数量 (名称、单价、数量)
    private static String[][] cart = new String[MAX_PRODUCTS][PRODUCT_FIELDS]; // 购物车二维数组
    private static int itemCount = 0; // 商品数量

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("====== 购物车功能 ======");
            System.out.println("1. 添加商品到购物车");
            System.out.println("2. 从购物车中删除商品");
            System.out.println("3. 修改购物车中商品数量");
            System.out.println("4. 计算购物车中商品总价");
            System.out.println("0. 结束购物");
            System.out.print("请选择操作：");
            choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    addProductToCart(scanner);
                    break;
                case 2:
                    removeProductFromCart(scanner);
                    break;
                case 3:
                    updateProductQuantity(scanner);
                    break;
                case 4:
                    calculateTotalPrice();
                    break;
                case 0:
                    System.out.println("感谢使用，再见！");
                    break;
                default:
                    System.out.println("无效的选项，请重新选择！");
            }
        } while (choice != 0);
        scanner.close();
    }

    // 添加商品到购物车
    private static void addProductToCart(Scanner scanner) {
        if (itemCount >= MAX_PRODUCTS) {
            System.out.println("购物车已满，无法添加新商品！");
            return;
        }
        System.out.print("请输入商品名称：");
        String productName = scanner.nextLine();
        System.out.print("请输入商品单价：");
        double unitPrice = scanner.nextDouble();
        System.out.print("请输入商品数量：");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        cart[itemCount][0] = productName;
        cart[itemCount][1] = String.valueOf(unitPrice);
        cart[itemCount][2] = String.valueOf(quantity);
        itemCount++;

        System.out.println("商品已成功添加到购物车！");
    }

    // 从购物车中删除商品
    private static void removeProductFromCart(Scanner scanner) {
        if (itemCount == 0) {
            System.out.println("购物车为空！");
            return;
        }
        displayCart();
        System.out.print("请选择要删除的商品序号：");
        int index = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        if (index < 1 || index > itemCount) {
            System.out.println("无效的商品序号！");
            return;
        }

        for (int i = index - 1; i < itemCount - 1; i++) {
            cart[i] = cart[i + 1];
        }
        itemCount--;

        System.out.println("商品已成功从购物车中删除！");
    }

    // 修改购物车中商品数量
    private static void updateProductQuantity(Scanner scanner) {
        if (itemCount == 0) {
            System.out.println("购物车为空！");
            return;
        }
        displayCart();
        System.out.print("请选择要修改数量的商品序号：");
        int index = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        if (index < 1 || index > itemCount) {
            System.out.println("无效的商品序号！");
            return;
        }

        System.out.print("请输入新的商品数量：");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        cart[index - 1][2] = String.valueOf(newQuantity);

        System.out.println("商品数量修改成功！");
    }

    // 计算购物车中商品总价
    private static void calculateTotalPrice() {
        if (itemCount == 0) {
            System.out.println("购物车为空！");
            return;
        }
        double totalPrice = 0;
        for (int i = 0; i < itemCount; i++) {
            double unitPrice = Double.parseDouble(cart[i][1]);
            int quantity = Integer.parseInt(cart[i][2]);
            totalPrice += unitPrice * quantity;
        }
        System.out.println("购物车中所有商品的总价为：" + totalPrice + " 元");
    }

    // 显示购物车内容
    private static void displayCart() {
        System.out.println("购物车中的商品：");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + cart[i][0] + " - 单价：" + cart[i][1] + " - 数量：" + cart[i][2]);
        }
    }
}

