package days05;

import java.util.Scanner;

public class 循环嵌套的控制 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
       flag: for (int i = 1; i <= 3; i++){
            System.out.printf("请输入一个数 %d",i);
            for (int j = 1; j <= 3; j++) {
                int num = sc.nextInt();
                if(num<0) {
//                    i=3;
                    flag=true;
//                    break;
                    break flag;//结束flag
                }
            }
            if(true){
                break;
            }
        }
    }
}
