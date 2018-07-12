package com.archelo.string;

import java.util.ArrayList;

/*
 * 1.9 String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 * */
public class StringRotation {
    public static void main(String[] args) {
        String test1a = "abcd";
        String test1b = "cdab";

        String test2a = "abcd";
        String test2b = "abcd";

        String test3a = "waterbottle";
        String test3b = "erbottlewat";

        boolean a = isRotated(test1a, test1b);
        boolean b = isRotated(test2a, test2b);
        boolean c = isRotated(test3a, test3b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

    /*
    * This method determines if a string is a rotation of another.
    * */
    public static boolean isRotated(String original, String rotated) {
        if (original == null || rotated == null || original.length() != rotated.length() || original.length() == 0)
            return false;

        char[] originalInput = original.toCharArray();
        char[] rotatedInput = rotated.toCharArray();

        Node<Character> head = new Node<>(originalInput[0]);
        Node<Character> tail = head;
        for (int i = 1; i < originalInput.length; i++) {
            Node<Character> current = new Node<>(originalInput[i]);
            tail.right = current;
            current.left = tail;
            tail = current;
            tail.right = head;
        }
        char c = rotatedInput[0];
        Node<Character> temp = head;

        while (temp != tail) {
            if (temp.element == c && matchString(temp,rotatedInput)) {
                return true;
            }
            temp = temp.right;
        }

        return false;
    }


    /*
    * This is a helper method to determine if the node's elements match the given char array
    * */
    public static boolean matchString(Node<Character> node, char[] input) {
        for (char c : input) {
            if (node.element != c) {
                return false;
            }
            node = node.right;
        }

        return true;
    }


    /*
    * This is a helper class to create a double linked list
    * */
    public static class Node<T> {
        Node<T> left;
        Node<T> right;
        T element;

        public Node(T element) {
            this.element = element;
        }
    }
}
