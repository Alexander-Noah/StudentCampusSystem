package days03;

public class ArrayDemo2 {

        public static void main(String[] args) {

            /********** Begin **********/

            int[][] scores = {{92,85},{91,65},{90,33}};

            for(int i=0; i<scores.length; i++){     //行循环次数scores.length（每一列的长度）

                for(int j=0; j<scores[i].length; j++){  //列循环次数scores[i].length（每一行的长度）

                    System.out.println(scores[i][j]);

                }

                //System.out.println();

            }

            //scores[][] = {{1,2},{1,2},{1,2}};     //是错误的

            for(int i=0; i<scores.length; i++){

                scores[i][0] = 1;

                scores[i][1] = 2;

            }

            for(int i=0; i<scores.length; i++){     //行循环次数

                for(int j=0; j<scores[i].length; j++){  //列循环次数

                    System.out.println(scores[i][j]);

                }

                //System.out.println();

            }



            /********** End **********/

        }
}
