package com.archelo;

public class AllUniqueString {

    public static void main(String[] args) {
        String test1 = "abcdefghijklmnopqrstuvwxyz";
        String test2 = "aa";
        String test3 = "aabbccddeeffgghh";
        String test4 = "abcd";

        boolean a = testUniqueCharacters(test1);
        boolean b = testUniqueCharacters(test2);
        boolean c = testUniqueCharacters(test3);
        boolean d = testUniqueCharacters(test4);

        System.out.println("Test 1 " + a);
        System.out.println("Test 2 " + b);
        System.out.println("Test 3 " + c);
        System.out.println("Test 4 " + d);

    }

    /**
     * This method verifies that all characters in a string are unique
     */
    public static boolean testUniqueCharacters(String string) {
        /*
         * This integer will be used as a 32 bit array.
         * */
        int index = 0;

        for (char c : string.toCharArray()) {
            /*
             * if char c is 'b' then 'b' - 'a' would result in 66 - 65 = 1. This
             * value is the shifted into its correct position in the array.
             * */
            int currentIndex = 1 << (c - 'a');

            /*
             * if the bit is set, then the current character has already been seen.
             * */
            if ((index & currentIndex) > 0){
                return false;
            }
            else{
                index = index | currentIndex;
            }
        }
        return true;

    }
}
