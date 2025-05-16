package days05;

public class break关键字 {
    public static void main(String[] args) {
        int num=6;
        int sum=0;
        for(int i=1;i<=6;i++){
            sum=sum+i;
            if(sum>20){
                break;
            }
        }
        System.out.println(sum);
    }
}
