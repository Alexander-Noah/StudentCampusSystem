package days01;

public class PhoneDem {
    public static void main(String[] args){
        Phone phone1=new Phone();
//        System.out.println(phone1,brand);
//        System.out.println(phone1,price);
        System.out.println("-----------给对象属性赋值之后---------------");
        phone1.brand="小米品牌手机";
        phone1.price=2999;
        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        phone1.call(phone1.brand);
        Phone phone2=new Phone();
        phone2.brand="华为品牌手机";
        phone2.price=5999;
        System.out.println(phone2.brand);
        System.out.println(phone2.price);
        phone1.call(phone2.brand);
        Phone phone3=new Phone();
        phone3.brand="OPPO品牌手机";
        phone3.price=3999;
        System.out.println(phone3.brand);
        System.out.println(phone3.price);
        phone3.sendMsg(phone3.brand);
    }
}
