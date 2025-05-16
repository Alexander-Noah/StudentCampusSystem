package days03;
import java.util.Scanner;
public class Mark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a=new int[10];
        int min;
        int max;
        int sum=0;
        int avg=0;
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        min = a[0];
        max = a[0];
        for (int j = 0; j < a.length; j++) {
            sum += a[j];
            if (a[j] > max) {
                max = a[j];
            }
            if (a[j] < min) {
                min = a[j];
            }
        }
        avg=(sum-max-min)/8;

        System.out.println(avg);
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);
    }
}
