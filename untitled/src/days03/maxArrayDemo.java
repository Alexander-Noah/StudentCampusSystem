package days03;
import java.util.Scanner;
public class maxArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[sc.nextInt()];

        //循环给数组赋值
        for(int i = 0 ; i< scores.length;i++){
            scores[i] = sc.nextInt();
        }
        /********** Begin **********/
        //在这里计算数组scores的平均值和最大值
        int sum = 0 ;
        int max = 0 ;
        for(int j=0 ; j < scores.length; j++) {
            sum = sum + scores[j] ;
            if(max < scores[j]) {
                max = scores[j] ;
            }
        }

        System.out.println("平均值：" + (double)sum / scores.length );
        System.out.println("最大值：" + max );
        /********** End **********/
    }
}
