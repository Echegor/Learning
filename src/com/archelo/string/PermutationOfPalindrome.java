package com.archelo.string;

import java.util.HashMap;

/*
* Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
* A palindrome is a word or phrase that is the same forwards and backwards. A permutation
* is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
* EXAMPLE
* Input: Tact Coa
* Output: True (permutations: "taco cat". "atco cta". etc.)
* */
public class PermutationOfPalindrome {
    public static void main(String[] args) {
        String test1 = "taco cat";
        String test2 = "oactatc";
        String test3 = "aabbccddeeffgghh";
        String test4 = "racecar";
        String test5 = "abcd";

        boolean a = permutationOfPalindrome(test1);
        boolean b = permutationOfPalindrome(test2);
        boolean c = permutationOfPalindrome(test3);
        boolean d = permutationOfPalindrome(test4);
        boolean e = permutationOfPalindrome(test5);

        System.out.println("Test 1 " + a);
        System.out.println("Test 2 " + b);
        System.out.println("Test 3 " + c);
        System.out.println("Test 4 " + d);
        System.out.println("Test 5 " + e);

    }

    /**
     * This method checks to see if the input string is the permutation of a palindrome.
     */
    public static boolean permutationOfPalindrome(String string) {
        char[] input = string.toCharArray();
        HashMap<Character,Integer> letterMap = new HashMap<>();

        /*
        * index the current string
        * */
        for (char c : input) {
            Integer currentCount = letterMap.get(c);
            letterMap.put(c, currentCount == null ? 1 : ++currentCount);
        }

        /*
        * if the current count is not a multiple of 2
        * */

        int oddCount = 0;
        for(char c : input){
            if(c == ' ')
                continue;

            Integer currentCount = letterMap.get(c);
            if(currentCount == null){
                currentCount = 0;
            }

            if(currentCount % 2 != 0){
                oddCount ++;
            }
        }

        return oddCount <= 1;

    }
}
