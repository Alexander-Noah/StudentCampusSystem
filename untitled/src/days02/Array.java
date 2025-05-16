package days02;

public class Array {
    public static void main(String[] args){
        int[] a=new int[10];
        for(int i=0;i<a.length;i++){
            a[i]=i+1;
        }
        for(int i=0;i<a.length;i++){
        }
        System.out.println("---------------------");
        int[] b={1,2,3,4,5};
        b[2]=10;
        System.out.println(b[2]);
        System.out.println("---------------------");
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
