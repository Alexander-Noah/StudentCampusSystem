package days04;

public class Demo01 {
    public static void main(String[] args) {
        for(int i=0;i<128;i++){
            if(i>=65&&i<=90||(i>=97&&i<=122)){
                System.out.print((char)i);
            }
        }
    }
}
