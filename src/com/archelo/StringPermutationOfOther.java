package com.archelo;

import java.util.ArrayList;

/*
* Given two strings, write a method to decide if one is a permutation of the
* other.
* */
public class StringPermutationOfOther {
    public static void main(String[] args) {
        String test1a = "abc";
        String test1b = "cba";

        String test2a = "abc";
        String test2b = "def";

        String test3a = "abc";
        String test3b = "abcd";

        String test4a = "aaabc";
        String test4b = "abc";

        boolean a = isPermutation(test1a,test1b);
        boolean b = isPermutation(test2a,test2b);
        boolean c = isPermutation(test3a,test3b);
        boolean d = isPermutation(test4a,test4b);

        System.out.println("Test 1 " + a);
        System.out.println("Test 2 " + b);
        System.out.println("Test 3 " + c);
        System.out.println("Test 4 " + d);
    }

    /**
    * Check if the first string is a permutation of the second string. This assumes the strings are all letters.
    * */
    public static boolean isPermutation(String first, String second){

        /*
        * Cannot be a permutation if you are not the same length
        * */
        if(first.length() != second.length())
            return false;

        /*
        * Create array holding character counts
        * */
        int[] characterList = new int[128];

        for(char c : second.toCharArray()){
            int index = c - 'A';
            int currentCount = characterList[index] + 1;
            characterList[index] = currentCount;
        }

        /*
        * Subtracts 1 from the counts. If the new count is less than 0, then the string cannot be a permutation
        * */
        for(char c : first.toCharArray()){
            int index = c - 'A';
            int currentCount = characterList[index] - 1;

            if(currentCount < 0){
                return false;
            }
            characterList[index] = currentCount;
        }

        return true;
    }
}
