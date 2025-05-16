package days02;

public class BasisDemo {
    public static void main(String[] args){
       int a[]={5,3,9,4,7} ;
       System.out.println(a[0]);
       a[4]=6;
       System.out.println(a[4]);
       int[] g=new int[3];
       System.out.println(g[0]);
       System.out.println(g[1]);
       System.out.println(g[2]);
       double[] h=new double[3];
       System.out.println(h[0]);
       System.out.println(h[1]);
       System.out.println(h[2]);
       char[] c=new char[3];
       System.out.println(c[0]);
       System.out.println(c[1]);
       System.out.println(c[2]);
       boolean[] n=new boolean[3];
       System.out.println(n[0]);
       System.out.println(n[1]);
       System.out.println(n[2]);
       String[] s={"张三","李四"};
       for(int i=0;i<s.length;i++){
          System.out.println(s[i]);
       }
       int[] j={3,2,15,6,7,8,8};
       for(int l=0;l<j.length;l++){
          System.out.println(j[l]);
       }
       double[] m={59.15,45.556,4845.45,35};
     for(double x:m){
        System.out.println(x);
     }
    }
}
