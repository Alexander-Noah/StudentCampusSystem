
class Shape{
    private String type;//形状
    private String color;//颜色
    public Shape(String type, String color){
        this.type=type;
        this.color=color;
    }
    //重写equals()方法
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || !(obj instanceof Shape)){
            return false;
        }
        Shape shape = (Shape) obj;
        return type.equals(shape.type)&& color.equals(shape.color);
    }
    //重写toString()方法
    @Override
    public String toString(){
        return "Shape{"+"type='"+type+",color='"+color+'}';
    }
}
public class Example01{
    public static void main(String[] args) {
        Shape shape1 = new Shape("Circle","Red");
        Shape shape2 = new Shape("Circle","Red");
        System.out.println("两个形状是否相等："+shape1.equals(shape2));
        System.out.println(shape1);//输出shape1的信息
        System.out.println(shape2);//输出shape2的信息
    }
}
