package com.archelo.string;

import javax.sound.midi.Soundbank;
import java.awt.*;

/*
* 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
* bytes, write a method to rotate the image by 90 degrees. can you do this in place?
* */
public class RotateMatrix {
    public static final int pixelSize = 4;
    public static final int imageWidth = 5;
    public static final int imageHeight = 5;

    public static void main(String[] args) {
        Pixel[][] image = new Pixel[imageWidth][imageHeight];
        initArray(image);
        printArray(image);
        rotateImage90(image);
        System.out.println();
        printArray(image);

    }

    public static void initArray(Pixel[][] input){
        int count = 0;
        for(int i =0 ; i < input.length ; i++){
            for(int j = 0 ; j < input[i].length ; j++){
                input[i][j] = new Pixel(i+j);
            }
        }
    }

    public static void printArray(Pixel[][] input){
        for(int i =0 ; i < input.length ; i++){
            for(int j = 0 ; j < input[i].length ; j++){
                System.out.print(input[i][j].pixel + " ");
            }
            System.out.println();
        }
    }

    /*
    * Rotates an image 90 degrees to the right
    * */
    public static Pixel[][] rotateImage90(Pixel[][] input){
        Point topLeft = new Point(0,0);
        Point topRight = new Point(input.length,0);
        Point bottomRight = new Point(input.length,input.length);
        Point bottomLeft= new Point(0,input.length);
        int currentSquareSize = input.length - 1;

        Pixel temp;
        while(topLeft.x < topRight.x){
            //System.out.println("swapping");
            //save top left
            temp = input[topRight.x][topRight.y];

            //put topLeft in topRight
            input[topRight.x][topRight.y] = input[topLeft.x][topLeft.y];

            //put bottomLeft in topLeft
            input[topLeft.x][topLeft.y] = input[bottomLeft.x][bottomLeft.y];

            //put bottomRight in bottomLeft
            input[bottomLeft.x][bottomLeft.y] = input[bottomRight.x][bottomRight.y];

            //put topRight in bottomRight
            input[topLeft.x][topLeft.y] = temp;

            /*
            * At this point, we can no longer swap pieces and must move onto the next inner square
            * */
            if(topLeft.x == currentSquareSize){
                currentSquareSize--;
                topLeft.x = topLeft.y++ + 1;
                topRight.y = topRight.x-- + 1;
                bottomRight.x = bottomRight.y-- -1;
                bottomLeft.y = bottomLeft.x-- - 1;
            }
            else{
                topLeft.x++;
                topRight.y++;
                bottomRight.x--;
                bottomLeft.y--;
            }
        }

        return input;
    }
    public static void swap(Pixel a,Pixel b){
        Pixel temp = a;
        a = b;
        b = temp;
    }

    public static void swap(){

    }

    public static class Pixel{
//        public byte[] pixel;
//        public Pixel(){
//            pixel = new byte[pixelSize];
//        }

        public int pixel;
        public Pixel(int pixel){
            this.pixel = pixel;
        }

    }

//    public static class Point {
//
//    }
}
