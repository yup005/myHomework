package pers.pan.bankTransactions.bankDao;

public class SQLDaoDemo {
    public static void main(String[] args) {
        SQLDao bankDao = new SQLDao();
        bankDao.deleteUser(100000000);
        bankDao.addUser();
        bankDao.updateUserName(100000000,"test name");
        bankDao.updateUserEmail(100000000,"test@test.com");
        bankDao.updateUserPhone(100000000,"0000000000");
        bankDao.depositMoney(100000000, 0);
        bankDao.depositMoney(100000000, 100);
        bankDao.getBalance(100000000);
        bankDao.getUserInfo("test name");
        bankDao.getAllUsers();
    }
}
