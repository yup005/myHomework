package pers.pan.bankTransactions;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class BankWindow {
    public static void main(String[] args) {
        Bank mine;
        mine = new Bank(50.0);
        mine.setAccountNumber("123456789");
        mine.setCustomerName("My Name");
        mine.setEmail("mine@email.com");
        mine.setPhoneNumber("000000000");

        Scanner scanner = new Scanner(System.in);
        System.out.println("There is the info of the test bank account.\n");
        mine.getInfo();
        String string;
        while (true) {
            System.out.print(
                    "\nPlease enter a number to continue:\n" +
                            "   1. Show Account Balance\n" +
                            "   2. Deposit Money\n" +
                            "   3. Withdraw Money\n" +
                            "   4. Exit\n" +
                            "Choose: ");
            string = scanner.nextLine();
            if(string.equals("4")) {System.exit(0);}
            switch (Integer.parseInt(string)) {
                case 1:
                    mine.getBalance();
                    break;
                case 2:
                    System.out.print("Please enter the funds: ");
                    string = scanner.nextLine();
                    mine.deposit(Integer.parseInt(string));
                    break;
                case 3:
                    System.out.print("Please enter the funds: ");
                    string = scanner.nextLine();
                    mine.withdraw(Integer.parseInt(string));
                    break;
                default:System.out.print("Wrong input. ");
            }
            System.out.println("Enter \"E\" to exit.\n" +
                    "Enter others to continue.");
            string = scanner.nextLine();
            if(string.equals("E") || string.equals("e")) System.exit(0);
        }
    }
}
