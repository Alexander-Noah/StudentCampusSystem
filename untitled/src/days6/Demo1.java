package days6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        // 创建 Io 对象用于读取键盘输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入字符串
        System.out.print("请输入一个字符串: ");
        String input = scanner.nextLine();

        // 调用方法判断字符是否唯一
        String result = areCharactersUnique(input) ? "YES" : "NO";

        // 输出结果
        System.out.println(result);

        // 关闭 Io
        scanner.close();
    }

    public static boolean areCharactersUnique(String str) {
        // 将字符串转换为小写，忽略大小写
        str = str.toLowerCase();

        // 使用一个 Set 来存储已经出现的字符
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // 如果字符已经存在于 Set 中，说明字符不唯一
            if (charSet.contains(currentChar)) {
                return false;
            }

            // 将字符添加到 Set 中
            charSet.add(currentChar);
        }

        // 如果所有字符都唯一，返回 true
        return true;
    }
}