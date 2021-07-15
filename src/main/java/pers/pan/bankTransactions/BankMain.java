package pers.pan.bankTransactions;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Bank mine, test, newAccount;
        test = new Bank(50.0);
        test.setAccountNumber("123456789");
        test.setCustomerName("My Name");
        test.setEmail("mine@email.com");
        test.setPhoneNumber("000000000");
        mine = test;

        Scanner scanner = new Scanner(System.in);
        System.out.println("There is the info of the test bank account.\n");
        mine.getInfo();

        System.out.print("\nDo you want create a new account or use the test " +
                "bank account? (Y / N) ");
        String string = scanner.nextLine();

        if (string.equals("Y")||string.equals("y")) {
            newAccount = new Bank();

            System.out.print("Please enter your name: ");
            string = scanner.nextLine();
            newAccount.setCustomerName(string);

            System.out.print("Please enter your phone number: ");
            string = scanner.nextLine();
            newAccount.setPhoneNumber(string);


            System.out.print("Please enter your email address: ");
            string = scanner.nextLine();
            newAccount.setEmail(string);

            newAccount.setAccountNumber("100000000");

            System.out.printf("\nSuccessful creating account!\n" +
                    "Welcome, %s!\nYour account number is " +
                    "%s, and your current balance is %s.\n",
                    newAccount.getCustomerName(),
                    newAccount.getAccountNumber(),
                    newAccount.getBalance());
            mine = newAccount;
        }
        while (true) {
            System.out.print(
                    "\nPlease enter a number to continue:\n" +
                            "   1. Show Account Balance\n" +
                            "   2. Deposit Money\n" +
                            "   3. Withdraw Money\n" +
                            "   Exit (E)\n" +
                            "Choose: ");
            string = scanner.nextLine();
            if(string.equals("e")||string.equals("E")) {System.exit(0);}
            switch (Integer.parseInt(string)) {
                case 1:
                    System.out.printf("Your balance is %.1f.\n", mine.getBalance());
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
                default:
                    System.out.print("Wrong input.\n");
            }
            System.out.print("Enter \"E\" to exit. " +
                    "Enter others to continue.");
            string = scanner.nextLine();
            if(string.equals("E") || string.equals("e")) System.exit(0);
        }
    }
}
