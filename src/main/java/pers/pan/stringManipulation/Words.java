package pers.pan.stringManipulation;

import java.util.Scanner;

public class Words {
    public static int count(String string) {
        int num = 0;
        boolean isWord = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                isWord = true;
            } else if (isWord) {
                num++;
                isWord = false;
            }
        }
        if (isWord) {
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (punctuations will be consider as " +
                "part of a word): ");
        String string = scanner.nextLine();
        if (string.trim().isEmpty()) {//sentence.isEmpty() include "space"
            System.out.print("Wrong input.\nPlease enter a correct string: ");
            string = scanner.nextLine();
        }
        System.out.printf("There are %d words in the string.", count(string));
    }
}
