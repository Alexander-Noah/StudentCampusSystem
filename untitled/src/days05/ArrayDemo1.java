package days05;

public class ArrayDemo1 {
    public static void main(String[] args) {
        int arr[]={10,9,4,6,3,2,};
        arr(arr);
        max(arr);
    }
    public static void arr(int arr[]){//遍历数组方法
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(",");
            }
        }
    }
    public static void max(int arr[]){//求max数组方法
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.printf("\n");
        System.out.println("max:"+max);
    }
}
