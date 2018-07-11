package com.archelo.matrix;

import java.util.HashSet;

/*
* 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
* column are set to O.
* */
public class ZeroMatrix {
    public static final int pixelSize = 4;
    public static final int imageWidth = 3;
    public static final int imageHeight = 3;

    public static void main(String[] args) {
        int[][] matrix = new int[imageWidth][imageHeight];
        initArray(matrix);
        printArray(matrix);
        zeroMatrix(matrix);
        System.out.println();
        printArray(matrix);

    }

    /*
    * This function zeroes out the entire column and row where there is a zero.
    * */
    private static void zeroMatrix(int[][] matrix) {
        HashSet<Integer> columnSet = new HashSet<>();
        HashSet<Integer> rowSet = new HashSet<>();

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j]==0){
                    columnSet.add(i);
                    rowSet.add(j);
                }
            }
        }

        for(int i : columnSet){
            for(int j = 0 ; j < matrix.length ; j++){
                matrix[i][j] = 0;
            }

        }

        for(int i : rowSet){
            for(int j = 0 ; j < matrix.length ; j++){
                matrix[j][i] = 0;
            }
        }

    }

    public static void initArray(int[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = count++;
            }
        }
    }

    public static void printArray(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.printf("%02d ",input[i][j]);
//                System.out.print( + " ");
            }
            System.out.println();
        }
    }
}
