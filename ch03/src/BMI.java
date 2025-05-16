import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的身高：");
        double height = sc.nextDouble();
        System.out.println("请输入您的体重：");
        double weight = sc.nextDouble();
        double bmi = weight / (height * height);
        System.out.println("您的BMI值为：" + bmi);
        String c=bmi<18.5?"偏瘦":bmi>23.9?"偏胖":"正常";
         System.out.println("您的体质"+c);
    }
}
