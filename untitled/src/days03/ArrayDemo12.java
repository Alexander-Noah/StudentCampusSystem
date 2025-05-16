package days03;
import javax.swing.plaf.IconUIResource;
import java.util.Scanner;
public class ArrayDemo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[20];
        int i = 0;
        int sum = 0;
        System.out.println("请输入数值：");
        for (i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum++;
            if (arr[i] < 0) {
                break;
            }
        }
        s:for (; ; ) {
            System.out.println("1：查找 2：最大值 0：退出");
            int flag=0;
            int z = sc.nextInt();
            switch (z) {
                case 1:
                    int d = sc.nextInt();
                    u:for (i = 0; i < arr.length; i++) {
                        if (arr[i] == d) {
                            System.out.println(d + "在数组的位置是" + i);
                            flag=1;
                            break u;
                        }
                    }
                    if(flag==0){
                        System.out.println(d + "在数组中不存在");
                    }

                    break;
                case 2:
                    int max = arr[0];
                    int n=1;
                    for (int j = 1; j < arr.length; j++) {
                        if (arr[j] > max) {
                            max = arr[j];
                            n = j;
                        }
                    }
                    System.out.println("最大值："+max+"的位置在第"+n+"个");
                    break;
                    default:{
                        break s;
                    }
            }

        }
    }
}
