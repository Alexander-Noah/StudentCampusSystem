package days05;
import java.util.Scanner;
public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(sum(5,9));
        System.out.println(sum(10.5,20.5));
        System.out.println(sum(15,25,65));
    }
    public static int sum(int a,int b){
        return a+b;
    }
    public static double sum(double a,double b){
        return a+b;
    }
    public static int sum(int a,int b,int c){
        return a+b+c;
    }
}
