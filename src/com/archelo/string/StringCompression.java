package com.archelo.string;

import java.util.LinkedList;

/*
 * 1.6 String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * */
public class StringCompression {
    public static void main(String[] args) {
        String test1 = "aabcccccaaa";
        String test1Output = "a2b1c5a3";
        String test2 = "aabbccddeeffgghh";
        String test2Output = "a2b2c2d2e2f2g2h2";
        String test3 = "abcd";
        String test3Output = "abcd";

        String a = compressString(test1);
        String b = compressString(test2);
        String c = compressString(test3);

        System.out.println("Test 1 " + a + " " + a.equals(test1Output));
        System.out.println("Test 2 " + b + " " + b.equals(test2Output));
        System.out.println("Test 3 " + c + " " + c.equals(test3Output));

    }


    /*
     * Compresses a string such that repeated letters are represented by the number
     * */
    private static String compressString(String input) {
        if (input == null || input.length() == 0)
            return input;

        char[] word = input.toCharArray();
        LinkedList<String> linkedList = new LinkedList<>();
        char lastChar = word[0];
        int lastcharCount = 1;
        int maxLength = 0;
        int i = 0;
        linkedList.addLast(String.valueOf(lastChar));

        while (true) {
            if (++i >= word.length) {
                linkedList.addLast(String.valueOf(lastcharCount));
                break;
            }

            char c = word[i];

            /*
             * This statement keeps track of the count of characters and to see if the string
             * should be compressed
             * */
            if (c == lastChar) {
                lastcharCount++;
                if (lastcharCount > maxLength) {
                    maxLength = lastcharCount;
                }
            }
            else{
                linkedList.addLast(String.valueOf(lastcharCount));
                linkedList.addLast(String.valueOf(c));
                lastChar = c;
                lastcharCount = 1;
            }


        }

        if (maxLength < 2)
            return input;

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : linkedList) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
