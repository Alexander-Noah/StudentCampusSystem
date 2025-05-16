package days05;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double a = reader.nextDouble();
        double b = reader.nextDouble();
        double c = reader.nextDouble();
        double n,m;
        if(b*b-4*a*c>0){//两个根
            n=((-b)+Math.sqrt((b*b-4*a*c)))/(2.0*a);
            m=((-b)-Math.sqrt((b*b-4*a*c)))/(2.0*a);
            System.out.println("该方程有两个根");
            System.out.println("x1 = "+String.format("%.2f",n)+"，x2 = "+String.format("%.2f",m));
        }
        else if(b*b-4*a*c==0){//一个根
            n=(-b)/(2.0*a);
            System.out.println("该方程只有一个根");
            System.out.println("x = "+String.format("%.2f",n));
        }
        else {//没根
            System.out.println("该方程无解");
        }

    }
}
