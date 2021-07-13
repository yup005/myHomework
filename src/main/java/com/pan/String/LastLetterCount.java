package com.pan.String;

import java.util.Scanner;

public class LastLetterCount {
    static class intString {
        int num;
        String string;

        intString(int i, String s) {
            num = i;
            string = s;
        }
    }

    public static intString count(String string) {
        int num = 0;
        int pos = 0, startS = -1, endS = -1, startY = -1, endY = -1;
        boolean isWord = false;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) != ' ') {
                isWord = true;
            } else if (isWord) {
                isWord = false;
                switch (string.charAt(i - 2)) {
                    case 's':
                        if (startS == -1) {
                            startS = pos;
                            endS = i - 2;
                        }
                        num++;
                        break;
                    case 'y':
                        if (startY == -1) {
                            startY = pos;
                            endY = i - 2;
                        }
                        num++;
                        break;
                }
                pos = i;
            } else {
                pos = i;
            }
        }
        if (string.charAt(string.length() - 1) == 's'
                || string.charAt(string.length() - 1) == 'y') {
            num++;
            if (startS == -1) {
                startS = pos;
            }
            if (startY == -1) {
                startY = pos;
            }
        }

        if (startS < startY) {
            string = getString(string, startY, endY, startS, endS);
        } else {
            string = getString(string, startS, endS, startY, endY);
        }
        return new intString(num, string);
    }

    private static String getString(String string, int startS, int endS, int startY, int endY) {
        String firstString = string.substring(0, startY);
        String yWord = string.substring(startY, endY + 1);
        String secondString = string.substring(endY + 1, startS);
        String sWord = string.substring(startS, endS + 1);
        String thirdString = string.substring(endS + 1);
        string = firstString + sWord + secondString + yWord + thirdString;
        return string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String string = scanner.nextLine();
        if (string.trim().isEmpty()) {
            System.out.print("Wrong input.\nPlease enter a correct sentence: ");
            string = scanner.nextLine();
        }
        System.out.printf("There are %d words end in 's' or 'y'.\n" +
                        "The new sentence is: %s",
                count(string).num, count(string).string);
    }
}
