package days6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class towArray {
    public static void main(String[] args) {
        int[][]a=new int [3][3];
        Random r=new Random();
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]= r.nextInt(100);
            }
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
