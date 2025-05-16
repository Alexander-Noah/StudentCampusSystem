package days05;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int []arr={9,5,3,7,13,6,75,435,86,342};
        //记录排序之前系统时间值
        long startTime=System.currentTimeMillis();

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                System.out.println(Arrays.toString(arr));
                }
            }
            System.out.println();
        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]);
//            System.out.print(" ");
//        }
        //记录排序之后的时间值
        long endTime=System.currentTimeMillis();
        //输出结果
        System.out.println("耗时："+(endTime-startTime)+"ms");
    }
}
