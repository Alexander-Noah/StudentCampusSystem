package days01;

public class Demo01 {
    public static void main(String[] args){
        getMax(60,30);
    }
    public static void getMax(int a,int b){
//        int a=20;
//        int b=60;
        int max=a>b?a:b;
        System.out.println("max:"+max);
    }
}
