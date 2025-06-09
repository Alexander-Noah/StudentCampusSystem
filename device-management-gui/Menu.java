import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static int mainMenu() {
        System.out.println("==================================");
        System.out.println("          设备管理系统           ");
        System.out.println("==================================");
        System.out.println("1. 设备管理");
        System.out.println("0. 退出");
        return scanner.nextInt();
    }

    public static int deviceMenu() {
        System.out.println("1. 新增");
        System.out.println("2. 修改");
        System.out.println("3. 删除");
        System.out.println("4. 查询");
        System.out.println("0. 返回");
        return scanner.nextInt();
    }

    public static int queryMenu() {
        System.out.println("1. 查询所有");
        System.out.println("2. 根据设备名称查询");
        System.out.println("0. 返回");
        return scanner.nextInt();
    }
}