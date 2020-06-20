package com.chaoliu.swordoffer.chapter2;


/**
 * todo 4 二维数组中查找
 * 在1个二维数组中，每一行都按照从左到右的顺序排列
 * 每一列都按照从上到下底层的顺序排序，输入一个整数，判断
 * 数组中是否含有该整数
 */
public class FindInPartiallySortedMatrix {

    /*
     *
     *  1 2 8 9
     *  2 4 9 12
     *  4 7 10 13
     *  6 8 11 15
     *
     */

    static boolean  find(int[][] matrix, int rows, int column, int number) {

        if (matrix == null || rows == 0 || column == 0) return false;

        // i 行 j 列
        int i = 0, j = 0;

        for (j = 0; j < column; j++) {

            if (matrix[i][j] == number){
                System.out.println("matrix["+i+"]["+j+"]");
                return true;
            }

            if (matrix[i][j] < number && j < (column-1)) {
                continue;
            }

            if (j == column-1){

                for (; i < rows; i++){

                    if (matrix[i][j] == number) {
                        System.out.println("matrix["+i+"]["+j+"]");
                        return true;
                    }

                    if (matrix[i][j] < number)
                        continue;

                    //回溯
                    if (matrix[i][j] > number) {
                        --i;
                        --j;
                        if (i < 0 || j < 0) return false;
                    }

                }

            }

            //边界处理
            if (i >= rows || j >= column ) return false;

            if (matrix[i][j] > number) {
                --j;

                if (j < 0) return false;

                for (; i < rows; i++) {

                    if (matrix[i][j] == number) {
                        System.out.println("matrix["+i+"]["+j+"]");
                        return true;
                    }

                    if (matrix[i][j] < number)
                        continue;

                    //回溯
                    if (matrix[i][j] > number) {
                        --i;
                        --j;
                        if (i < 0 || j < 0) return false;
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        int rows = 4;
        int column = 4;

        System.out.println(find(matrix,rows,column,14));
        System.out.println(find(matrix,4,4,7));
        System.out.println(find(matrix,4,4,5));
        System.out.println(find(matrix,4,4,15));
        System.out.println(find(matrix,4,4,16));
        System.out.println(find(matrix,4,4,-1));
        System.out.println(find(matrix,4,4,13));
        System.out.println(find(matrix,4,4,11));

    }


}
