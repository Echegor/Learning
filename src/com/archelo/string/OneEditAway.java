package com.archelo.string;

/*
 * 1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, pIe -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 * */
public class OneEditAway {
    public static void main(String[] args) {
        String test1a = "pale";
        String test1b = "ple";

        String test2a = "pales";
        String test2b = "pale";

        String test3a = "pale";
        String test3b = "bale";

        String test4a = "pale";
        String test4b = "bake";

        boolean a = isOneEditAway(test1a, test1b);
        boolean b = isOneEditAway(test2a, test2b);
        boolean c = isOneEditAway(test3a, test3b);
        boolean d = isOneEditAway(test4a, test4b);

        System.out.println("Test 1 " + a);
        System.out.println("Test 2 " + b);
        System.out.println("Test 3 " + c);
        System.out.println("Test 4 " + d);
    }


    /*
     * Check to see if the second input is one edit away from the second. An edit can be defined as
     * insert a character
     * remove a character
     * or replace a character
     * */
    private static boolean isOneEditAway(String first, String second) {
        int editCount = 0;
        char[] firstInput;
        char[] secondInput;

        if(first.length() >= second.length()){
            firstInput = first.toCharArray();
            secondInput = second.toCharArray();
        }
        else{
            firstInput = second.toCharArray();
            secondInput = first.toCharArray();
        }


        for (int i = 0, j = 0; i < firstInput.length; i++,j++) {
            //first string is longer than the second
            if( j >= secondInput.length){
                editCount ++;
                continue;
            }

            //everything is fine
            if (firstInput[i] == secondInput[j]) {//equal
                continue;
            }

            //could not get right index. letter was replaced or deleted
            int rightIndex = j +1;
            if(rightIndex >= secondInput.length){
                editCount++;
                continue;
            }

            //a letter was inserted
            if( firstInput[i] == secondInput[rightIndex]){
                j = rightIndex;
            }

            //a letter was deleted
            if(firstInput[i+1] == secondInput[j]){
                i++;
            }

            //a letter was replaced
            editCount++;


        }

        System.out.println("edit count " + editCount);
        return editCount < 2;
    }


}
