package com.pan.String;

import java.util.*;

public class Consonants {
    private static final Set<Character> consonants= new HashSet<>(Arrays.asList('B', 'C', 'D', 'F', 'G', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'S', 'T', 'V', 'X', 'Z', 'H', 'R', 'W', 'Y')) ;
    static class intString {
        int num;
        String string;
        intString(int i, String s){num = i; string = s;}
    }

    public static intString count(String string) {
    int num = 0;
    for (int i = 0; i < string.length(); i++) {
        char current = string.charAt(i);
        if (consonants.contains(current)
                || consonants.contains((char)(current+'A'-'a'))){
            num++;
            string = string.substring(0, i) +"*"+ string.substring(i + 1);
        }
    }
    return new intString(num,string);
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter the sentence: ");
        String string = scanner.nextLine();
        if (string.trim().isEmpty()) {//sentence.isEmpty() include "space"
            System.out.print("Wrong input.\nPlease enter a correct string: ");
            string = scanner.nextLine();
        }
        System.out.printf("There are %d vowels in the string.\n" +
                        "And the new string is %s.",
                count(string).num, count(string).string);
    }
}
