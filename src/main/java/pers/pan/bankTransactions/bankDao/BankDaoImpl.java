package pers.pan.bankTransactions.bankDao;

import pers.pan.bankTransactions.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements BankDao {
    private List<Bank> users;
    private int theAccountNumber = 100000000;

    public BankDaoImpl() {
        users = new ArrayList<>();
    }

    @Override
    public void addUser() {
        Bank user = new Bank();
        user.setAccountNumber(theAccountNumber);
        System.out.printf("Successful creating account! " +
                "Your account number is %d.\n", theAccountNumber);
        theAccountNumber++;
        users.add(user);
    }

/*    public void addUser(String username) {
        Bank user = new Bank();
        user.setAccountNumber(theAccountNumber);
        user.setCustomerName(username);
        System.out.printf("Successful creating account! " +
                "Your account number is %d.\n", theAccountNumber);
        theAccountNumber++;
        users.add(user);
    }*/

    @Override
    public void updateUserName(int accountNumber, String name) {
        users.get(accountNumber - 100000000).setCustomerName(name);
        System.out.printf("Successful updating! %s!\n", name);
    }

    @Override
    public void updateUserEmail(int accountNumber, String email) {
        users.get(accountNumber - 100000000).setEmail(email);
        System.out.printf("Successful updating! " +
                "Your new email address is %s!\n", email);
    }

    @Override
    public void updateUserPhone(int accountNumber, String phoneNumber) {
        users.get(accountNumber - 100000000).setPhoneNumber(phoneNumber);
        System.out.printf("Successful updating! " +
                "Your new phone number is %s!\n", phoneNumber);
    }

    @Override
    public void deleteUser(int accountNumber) {
        //users.removeIf(user->user.getAccountNumber().equals(accountNumber)))
        int index = accountNumber - 100000000;
        if (users.get(index) == null) {
            System.out.println("There is a incorrect account number.");
            return;
        }
        String name = users.get(index).getCustomerName();
        users.set(index, null);
        System.out.printf("%s's account has been deleted!\n", name);
    }

    @Override
    public void getAllUsers() {
        System.out.println("\nThere are names of all current users:");
        for (Bank user : users) {
            if (user!=null){
                System.out.println(user.getCustomerName());
            }
        }
    }

    @Override
    public void getUserInfo(String name) {
        for (Bank user : users) {
            if (user.getCustomerName().equals(name)) user.getInfo();
            return;
        }
    }

    @Override
    public void depositMoney(int accountNumber, double balance) {
        if (balance < 5 || balance > 10000) {
            System.out.print("You can't deposit money less than $5 and more" +
                    " than $10000, please try it again.\n");
            return;
        }
        users.get(accountNumber - 100000000).deposit(balance);
    }

    @Override
    public void getBalance(int accountNumber) {
        System.out.printf("Your balance is %.1f.\n",
                users.get(accountNumber - 100000000).getBalance());
    }
}
