package days04;

import java.util.Scanner;

public class annotation {
    /**
     * 任务：编写程序，读入投资额、年利率和投资年限，利用题目所给公式计算投资的未来价值
     * 类名为：Finance
     */
// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

    /********** Begin **********/
// 第一步：导入Scanner类
    // 第二步：创建一个名为 Finance 的公开类
    // 第三步：定义主方法
    public static void main(String[] args) {
// 第四步：在主方法中，根据题目给出的计算投资的未来价值公式来计算未来价值
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double sum = a;
        double b = sc.nextDouble();
        int year = sc.nextInt();
        double f = a * (Math.pow((1+b/12),12*year));
        sum = sum + f;
// 第五步：格式化输出未来价值，结果保留两位小数
        System.out.println(f);
        System.out.println(sum);

/********** End **********/
    }
}