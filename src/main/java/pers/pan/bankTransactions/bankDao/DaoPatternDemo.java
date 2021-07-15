package pers.pan.bankTransactions.bankDao;

public class DaoPatternDemo {
    public static void main(String[] args) {
        BankDao bankDao = new BankDaoImpl();

        //first user
        System.out.println("first user");
        bankDao.addUser();
        bankDao.updateUserName(100000000,"test name");
        bankDao.updateUserEmail(100000000,"test@test.com");
        bankDao.updateUserPhone(100000000,"0000000000");
        bankDao.depositMoney(100000000, 0);
        bankDao.depositMoney(100000000, 100);
        bankDao.getBalance(100000000);
        bankDao.getUserInfo("test name");

        //second user
        System.out.println("\nsecond user");
        bankDao.addUser("test2");
        bankDao.updateUserEmail(100000001,"test2@test.com");
        bankDao.updateUserPhone(100000001,"2000000000");
        bankDao.depositMoney(100000001, 2000);

        bankDao.deleteUser(100000001);
        bankDao.getAllUsers();
    }
}
