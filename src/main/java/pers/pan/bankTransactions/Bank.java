package pers.pan.bankTransactions;

public class Bank {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Bank() {
    }

    public Bank(double balance) {
        this.balance = balance;
    }

    public void deposit(double funds){
        balance += funds;
        System.out.printf("Successful deposit, the current balance of" +
                " %s's account is %.1f.\n", customerName, balance);
    }

    public void withdraw(double funds){
        if (funds>balance){
            System.out.printf("There are insufficient funds." +
                    " You balance is %.1f.\n", balance);
        } else {
            balance -= funds;
            System.out.printf("Successful withdrawal, the current balance of" +
                    " %s's account is %.1f.\n", customerName, balance);
        }
    }

    public void getInfo(){
        System.out.printf("Name: %s\n", customerName);
        System.out.printf("Account number: %s\n", accountNumber);
        System.out.printf("Balance: %.1f\n", balance);
        System.out.printf("E-mail: %s\n", email);
        System.out.printf("Phone number: %s\n", phoneNumber);
    }

    public String getAccountNumber() {
        System.out.printf("Your account number is %s.\n", accountNumber);
        return accountNumber;
    }

    public double getBalance() {
        System.out.printf("Your balance is %.1f.\n", balance);
        return balance;
    }

    public String getCustomerName() {
        System.out.printf("Your name is %s.\n", customerName);
        return customerName;
    }

    public String getEmail() {
        System.out.printf("Your E-mail address is %s.\n", email);
        return email;
    }

    public String getPhoneNumber() {
        System.out.printf("Your phone number is %s.\n", phoneNumber);
        return phoneNumber;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
