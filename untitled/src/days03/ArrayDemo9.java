package days03;

public class ArrayDemo9 {
    public static void main(String[] args) {
        int[] arr1 = {86, 78, 68, 58, 88, 98, 45};
        int max = 0;
        int min=0;
        for (int i = 0; i < arr1.length-1; i++) {
//           if(arr1[i]>arr1[arr1.length-1]){
//                max=arr1[i];
//           }

            if (arr1[i] > arr1[i + 1]) {
                max=arr1[i];
                min=arr1[i+1];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
