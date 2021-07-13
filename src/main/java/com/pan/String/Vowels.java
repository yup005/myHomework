package com.pan.String;

import java.util.Scanner;

public class Vowels {
    public static int count(String sentence) {
        int num = 0;
        for (int i = 0; i < sentence.length(); i++) {
            switch (sentence.charAt(i)){
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u':
                    num++;break;
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        if (sentence.trim().isEmpty()) {//sentence.isEmpty() include "space"
            System.out.print("Wrong input.\nPlease enter a correct sentence: ");
            sentence = scanner.nextLine();
        }
        System.out.printf("There are %d vowels in the sentence.", count(sentence));
    }
}
