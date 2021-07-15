package pers.pan.bankTransactions.bankDao;

public interface BankDao {
    void addUser();
    void updateUserName(int accountNumber, String name);
    void updateUserEmail(int accountNumber, String email);
    void updateUserPhone(int accountNumber, String phoneNumber);

    void deleteUser(int accountNumber);

    void getAllUsers();
    void getUserInfo(String name);

    void depositMoney(int accountNumber, double balance);
    void getBalance(int accountNumber);
}
