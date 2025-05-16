package days01;

public class Phone {
    //1.成员属性（a.手机品牌b.手机价格）
    //2.成员方法
    String brand;
    double price;
    public void call(String brand){
        System.out.println("使用"+brand+"拨打电话");
    }
    public void sendMsg(String brand){
        System.out.println("使用"+brand+"发送短信");
    }

}
