package days05;
import java.util.Scanner;
public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int n = sc.nextInt();
        int sum=0;
        while(n>0){
             sum+=n%10;
             n=n/10;


        }
        System.out.println(sum);
    }
}
