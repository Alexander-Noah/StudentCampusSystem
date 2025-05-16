package days02;
import java.util.Scanner;
public class InOutDemo {
    public static void main(String[] args) {
        int number1;
        int number2;
        int number3;
        /********** Begin *********/
        Scanner sc=new Scanner(System.in);
        number1 = sc.nextInt();
        number2 = sc.nextInt();
        number3 = number1 + number2;
        System.out.println(number3);
        /********** End *********/
    }
}
