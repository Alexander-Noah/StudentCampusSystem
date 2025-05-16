package days01;

public class Dome02 {
    public static void main(String[] args) {
        int a=65;
        int b=97;
        getMax(a,b);
    }
    public static void getMax(int a,int b){
//        int c=a>b?a:b;
        if(a>b){
            System.out.println(a);
        }
        System.out.println("a:"+a);
        System.out.println("b:"+b);
//        System.out.println("max:"+c);
    }
}
