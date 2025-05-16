package days01;

public class StudentDemo {
    public static void main(String[] args){
       Student s= new Student();
       s.name="张三";
       s.setAge(184);
       System.out.println(s.name);
       System.out.println(s.getAge());
//       s.work();
//       Student s1=new Student();
//       s1.name="李四";
//       s1.age=35;
//       System.out.println(s1.name);
//       System.out.println(s1.age);
//       s1.work();

    }
}
