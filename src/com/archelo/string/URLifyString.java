package com.archelo.string;

/*
 * Write a method to replace all spaces in a string with '%20: You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith "
 * Output: "Mr%20John%20Smith"
 */
public class URLifyString {
    public static void main(String[] args) {
        String test1 = "         ";
        String test2 = "Luis was here";
        String test3 = "abc";
        String test4 = "just anotherlongtestwithmanything going on";

        String a = toUrlString(test1);
        String b = toUrlString(test2);
        String c = toUrlString(test3);
        String d = toUrlString(test4);

        System.out.println("Test 1 " + a);
        System.out.println("Test 2 " + b);
        System.out.println("Test 3 " + c);
        System.out.println("Test 4 " + d);
    }

    /**
     * This method adds %20 as all spaces inside a string.
     * I believe that an even more optimal solution would be to calculate statistically
     * how many spaces there are in a normal string of size n and create an array big enough to hold that
     * many words. With validation, this would avoid the first iteration of log(n) work.
     */
    public static String toUrlString(String string) {
        char[] inputString = string.toCharArray();
        /*
         * count the number of spaces inside the string
         * */
        int numSpaces = 0;
        for (char c : inputString) {
            if (c == ' ') {
                numSpaces++;
            }
        }

        /*
         * no spaces, we are done.
         * */
        if (numSpaces == 0) {
            return string;
        }

        /*
         * Create new array with enough space for output.
         * */
        char[] output = new char[inputString.length + 2 * numSpaces];

        for(int i = 0, j = 0 ; i < inputString.length ; i++,j++){
            if (inputString[i] == ' ') {
                output[j] = '%';
                output[j + 1] = '2';
                output[j + 2] = '0';
                //the for loop will add the second 1
                j+=2;
            } else{
                output[j] = inputString[i];
            }
        }

        return new String(output);

    }
}
