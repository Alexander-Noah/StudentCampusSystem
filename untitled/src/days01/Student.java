package days01;

public class Student {
    String name;
    private int age;
    public void work(){
        int j=20;
        System.out.println("开始使用键盘敲代码----");
    }
    public  void setAge(int age){
        if(age>120||age<0){
            System.out.println("格式错误");
            return;
        }
        this.age=age;
    }
    public  int getAge(){
        return this.age;
    }
}
