package com.pan.String;

import java.util.Scanner;

public class Palindrome {
    public static String reverse(String string) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (DO NOT ENTER SPACE): ");
        String string = scanner.next();
        if (string.equals(reverse(string))) {
            System.out.printf("This is palindrome, and the reversed string is %s.",
                    reverse(string));
        } else {
            System.out.println("This is not palindrome.");
        }
    }
}
