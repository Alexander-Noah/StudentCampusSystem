package days05;

public class Demo06 {
    public static void main(String[] args) {
        // 请在 Begin-End 间编写代码

        /********** Begin **********/
        // 第一步：使用for循环依次取999到100中的每个数，判断是否为水仙花数
        for(int i=100;i<=999;i++){
            // 第二步：获取个位
            int g=i%10;
            // 第三步：获取十位
            int s=i/10%10;
            // 第四步：获取百位
            int b=i/100;
            // 第五步：判断个位数的三次幂，十位数的三次幂，百位数的三次幂的和是否等于这个数本身，等于的话，输出该数
            g=(g*g*g);
            s=(s*s*s);
            b=(b*b*b);
            int sum=g+s+b;
            if(sum==i)
            {
                System.out.println(i+"是一个水仙花数。");
            }
        }
    }
}
