package days01;
import java.util.Scanner;
public class Demo03 {
    public static int geMax(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int max=geMax(a,b);
        System.out.println(max);
    }
}
