package com.archelo.string;

import javax.sound.midi.Soundbank;
import java.awt.*;

/*
 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. can you do this in place?
 * */
public class RotateMatrix {
    public static final int pixelSize = 4;
    public static final int imageWidth = 3;
    public static final int imageHeight = 3;

    public static void main(String[] args) {
        Pixel[][] image = new Pixel[imageWidth][imageHeight];
        initArray(image);
        printArray(image);
        rotateImage90(image);
        System.out.println();
        printArray(image);

    }

    public static void initArray(Pixel[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = new Pixel(count++);
            }
        }
    }

    public static void printArray(Pixel[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.printf("%02d ",input[i][j].pixel);
//                System.out.print( + " ");
            }
            System.out.println();
        }
    }

    /*
     * Rotates an image 90 degrees to the right
     * */
    public static Pixel[][] rotateImage90(Pixel[][] input) {
        int currentSquareSize = input.length - 1;
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(currentSquareSize, 0);
        Point bottomRight = new Point(currentSquareSize, currentSquareSize);
        Point bottomLeft = new Point(0, currentSquareSize);


        Pixel temp;
        while (currentSquareSize > 1) {

            //save top right
            System.out.println("Saving top right " + topRight);
            System.out.println("Saving topRight = " + topRight + " " + input[topRight.y][topRight.x].pixel);
            temp = input[topRight.y][topRight.x];

            //put topLeft in topRight
            System.out.println("topRight = " + topRight + " Moving " + input[topLeft.y][topLeft.x].pixel + " to " + input[topRight.y][topRight.x].pixel);
            input[topRight.y][topRight.x] = input[topLeft.y][topLeft.x];

            //put bottomLeft in topLeft
            System.out.println("topLeft = " + topLeft + " Moving " + input[bottomLeft.y][bottomLeft.x].pixel + " to " + input[topLeft.y][topLeft.x].pixel);
            input[topLeft.y][topLeft.x] = input[bottomLeft.y][bottomLeft.x];

            //put bottomRight in bottomLeft
            System.out.println("bottomLeft = " + bottomLeft + " Moving " + input[bottomRight.y][bottomRight.x].pixel + " to " + input[bottomLeft.y][bottomLeft.x].pixel);
            input[bottomLeft.y][bottomLeft.x] = input[bottomRight.y][bottomRight.x];

            //put topRight in bottomRight
            System.out.println("bottomRight = " + bottomRight + "Moving " + temp.pixel + " to " + input[bottomRight.y][bottomRight.x].pixel);
            input[bottomRight.y][bottomRight.x] = temp;

            printArray(input);
            System.out.println("topleft.x " + topLeft.x+ " currentsquare size " + currentSquareSize);
            /*
             * At this point, we can no longer swap pieces and must move onto the next inner square
             * */
            if (topLeft.x >= currentSquareSize-1) {
                System.out.println("Resetting");
                currentSquareSize--;
                topLeft.x = topLeft.y + 1;
                topLeft.y = topLeft.x;

                topRight.x = currentSquareSize;
                topRight.y = topLeft.x;

                bottomRight.x = currentSquareSize;
                bottomRight.y = currentSquareSize;

                bottomLeft.x = bottomLeft.x + 1;
                bottomLeft.y = currentSquareSize;
            } else {
                System.out.println("Incrementing");
                topLeft.x++;
                topRight.y++;
                bottomRight.x--;
                bottomLeft.y--;
            }
        }


        return input;
    }

    public static class Pixel {
//        public byte[] pixel;
//        public Pixel(){
//            pixel = new byte[pixelSize];
//        }

        public int pixel;

        public Pixel(int pixel) {
            this.pixel = pixel;
        }

    }

//    public static class Point {
//
//    }
}
