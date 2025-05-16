package days04;

public class FgoC {/**
 * 任务：编写一个程序，依次将摄氏温度为 1°、2°、3°、4°、5° 所对应的华氏温度的值四舍五入后保留两位小数输出， 摄氏温度和华氏温度转换公式如下：
 * fahrenheit（华氏温度） = ( 9/5 ) × celsius（摄氏温度） + 32。
 * 类名为：Temperature
 */
// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

    /********** Begin **********/
// 第一步：创建一个名为 Temperature 的公开类
    public static void main(String[] args) {
        double f;
        double s = (9.0/ 5.0);
        double a=0.3,b=0.1;
        System.out.println(a*b);
        // for(int i=1;i<=5;i++){
        //     f=(9/5)*i+32;
        // System.out.printf("摄氏温度为"+i+"时，华氏温度为"+"%.2f",f);
        //     System.out.println(f);
        // }
        f = ((9.0 / 5.0) * 1.0) + 32;
        System.out.println(f);
        System.out.println(s);
// 第二步：在这个类中定义主方法


// 第三步：在主方法中依次计算摄氏温度为 1°、2°、3°、4°、5° 所对应的华氏温度的值，四舍五入后保留两位小数，最后格式化输出华氏温度的值，例子：摄氏温度为1时，华氏温度为xx。
    }
}
/********** End **********/
