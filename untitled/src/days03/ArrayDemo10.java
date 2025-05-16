package days03;
/*
 * 定义两个数组将两个数组中的值和并并排序输出
 */

import java.util.Arrays;

import java.util.Scanner;

public class ArrayDemo10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] record = new int[10];

        int[] recordRecovery = new int[10];

        /********** Begin *********/

        for (int i = 0; i < 10; i++) {

            if (scanner.hasNextInt()) {

                record[i] = scanner.nextInt();

            }

        }

        //先进行排序

        Arrays.sort(record);

        recordRecovery[0] = record[0];

        //将不同的项放入新的数组

        int j = 0;

        for (int i = 1; i < record.length; i++) {

            if (record[i] != recordRecovery[j]) {

                j++;

                recordRecovery[j] = record[i];

            }

        }

        //Arrays.sort(recordRecovery);

        //这个j就是实际上有多少个真实的数据

        int num = j + 1;


        /********** End *********/

        for (int i = 0; i < num; i++) {

            System.out.print(recordRecovery[i]);

            if (i != num - 1) {

                System.out.print(' ');

            }

        }

    }

}