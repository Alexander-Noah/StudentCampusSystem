package days03;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayDemo11 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr1=new int[10];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=sc.nextInt();
        }
        Arrays.sort(arr1);
        for(int element: arr1)
        {
            System.out.println(element);
        }
    }
}
