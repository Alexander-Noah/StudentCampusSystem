package days03;

public class ArrayDemo7 {
    public static void main(String[] args) {
        int [] arr1=new int [2];
        arr1[0]=100;
        arr1[1]=20;
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        int [] arr2=arr1;
        System.out.println("arr1"+arr1);
        System.out.println("arr2"+arr2);
        arr2[0]=300;
        arr2[1]=40;
        System.out.println("arr2[0]"+arr2[0]);
        System.out.println("arr2[1]"+arr2[1]);
        System.out.println("arr1[0]:"+arr1[0]);
        System.out.println("arr1[1]:"+arr1[1]);
    }
}
