package days01;

public class studentDemo01 {
    public static void main(String[] args) {
        student1 s=new student1();
        System.out.println(s.getAge());
        System.out.println(s.getName());
        s.setName("执笔");
        s.setAge(20);
        studentDemo02 r= new studentDemo02();
        r.student1();

    }
}
