package Student;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        //创建集合存储学生对象
        ArrayList<StudentDemoTest> list = new ArrayList<>();
        //创建3个学生对象
        StudentDemoTest stu1 = new StudentDemoTest("张三",22,"男");
        StudentDemoTest stu2 = new StudentDemoTest("李四",25,"男");
        StudentDemoTest stu3 = new StudentDemoTest("小微",18,"女");

        //把学生对象添加到集合当中
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        //调用工具类中的方法
        int maxAgeStudent=StudentUtil.getMaxAgeStudent(list);
        System.out.println(maxAgeStudent);
    }
}
