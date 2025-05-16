package days01;

public class student1 {
    private String name ="mayikt";
    private int age=666;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println(this.age);
    }

    @Override
    public String toString() {
        return "student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
