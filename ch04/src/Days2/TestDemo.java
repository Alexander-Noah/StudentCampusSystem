package Days2;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        String str = Arrayuiti.printArr(arr1);
        System.out.println(str);

        double[] arr2 = {1.3,2.4,3.5,5.3,6.5,9.8};
        double avg = Arrayuiti.getAerage(arr2);
        System.out.println(avg);
    }
}
