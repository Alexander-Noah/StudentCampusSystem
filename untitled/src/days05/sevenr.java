package days05;

public class sevenr {
    public static void main(String[] args) {
    seven();
    }
    public static void seven(){
        for(int i=1;i<=100;i++){
            if(i%10==7||i/10%10==7||i%7==0){
                System.out.println(i);
            }
        }
    }
}
