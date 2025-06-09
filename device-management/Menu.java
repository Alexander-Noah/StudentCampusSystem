import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static int showMainMenu() {
        while (true) {
            System.out.println("===============================");
            System.out.println("         设备管理系统         ");
            System.out.println("===============================");
            System.out.println("1: 设备管理");
            System.out.println("0: 退出");
            System.out.print("请输入要执行操作的编号：");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 1) {
                    return choice;
                } else {
                    System.out.println("无效的输入，请输入0或1。");
                }
            } else {
                scanner.next(); // 清除非法输入
                System.out.println("无效的输入，请输入数字。");
            }
        }
    }

    public static int showDeviceMenu() {
        while (true) {
            System.out.println("1: 新增");
            System.out.println("2: 修改");
            System.out.println("3: 删除");
            System.out.println("4: 查询");
            System.out.println("0: 返回");
            System.out.print("请输入要执行操作的编号：");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("无效的输入，请输入0到4之间的数字。");
                }
            } else {
                scanner.next(); // 清除非法输入
                System.out.println("无效的输入，请输入数字。");
            }
        }
    }

    public static int showQueryMenu() {
        while (true) {
            System.out.println("1: 查询所有");
            System.out.println("2: 根据设备名称查询");
            System.out.println("0: 返回");
            System.out.print("请输入要执行操作的编号：");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 2) {
                    return choice;
                } else {
                    System.out.println("无效的输入，请输入0到2之间的数字。");
                }
            } else {
                scanner.next(); // 清除非法输入
                System.out.println("无效的输入，请输入数字。");
            }
        }
    }
}