package Days2;

public class Arrayuiti {
    //私有化构造方法
    //目的：为了不让外界创建他的对象
    private  Arrayuiti() {}



    //需要定义为静态的，方便调用
    public static String printArr(int[] arr){
        StringBuilder sb =  new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1) {
                //i索引 arr[i]元素
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]+",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public static double getAerage(double[] arr){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            sum = sum +arr[i];
        }
        return sum/arr.length;
    }
}
