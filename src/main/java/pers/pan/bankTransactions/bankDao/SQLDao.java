package pers.pan.bankTransactions.bankDao;

import java.sql.*;

public class SQLDao implements BankDao {
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://databasepan.cttusmxetoju.us-west-1.rds.amazonaws.com:3306/bankDB";
    final String USER = "admin";
    final String PASS = "password_pan";

    private static final String INSERT_USERS_SQL = "INSERT INTO TestJava " +
            "(AccountID,balance) VALUES (?,?)";
    private static final String SELECT_USER_BY_NAME = "select * from TestJava" +
            " where name =?;";
    private static final String SELECT_ALL_USERS = "select * from TestJava";
    private static final String DELETE_USERS_SQL = "delete from TestJava where AccountID = ?;";
    private static final String UPDATE_USERNAME_SQL = "update TestJava set " +
            "name = ? where AccountID = ?;";
    private static final String UPDATE_EMAIL_SQL = "update TestJava set " +
            "email = ? where AccountID = ?;";
    private static final String UPDATE_PHONE_SQL = "update TestJava set " +
            "phoneNumber = ? where AccountID = ?;";
    private static final String SELECT_BALANCE = "select balance from TestJava " +
            "where AccountID =?;";
    private static final String DEPOSIT_SQL = "update TestJava set " +
            "balance=balance+? where AccountID = ?;";

    private int theAccountNumber = 100000000;

    public SQLDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void addUser() {
        System.out.printf("Successful creating account! " +
                "Your account number is %d.\n", theAccountNumber);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, String.valueOf(theAccountNumber));
            preparedStatement.setDouble(2, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        theAccountNumber++;
    }

    @Override
    public void updateUserName(int accountNumber, String name) {
        System.out.printf("Successful updating! %s!\n", name);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERNAME_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(accountNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateUserEmail(int accountNumber, String email) {
        System.out.printf("Successful updating! " +
                "Your new email address is %s!\n", email);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMAIL_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, String.valueOf(accountNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateUserPhone(int accountNumber, String phoneNumber) {
        System.out.printf("Successful updating! " +
                "Your new phone number is %s!\n", phoneNumber);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHONE_SQL)) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, String.valueOf(accountNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteUser(int accountNumber) {
        System.out.printf("%d account has been deleted!\n", accountNumber);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setString(1, String.valueOf(accountNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void getAllUsers() {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int accountNumber = rs.getInt("AccountID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                double balance = rs.getDouble("balance");
                System.out.println("\nThere are information of all current users:");
                System.out.println("account      name           email        phone        balance");
                System.out.printf("%d   %s   %s   %s   %f\n", accountNumber,
                        name,
                        email,phoneNumber,balance);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void getUserInfo(String name) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int accountNumber = rs.getInt("AccountID");
            String email = rs.getString("email");
            String phoneNumber = rs.getString("phoneNumber");
            double balance = rs.getDouble("balance");
            System.out.println("account      name           email        phone        balance");
            System.out.printf("%d   %s   %s   %s   %f\n", accountNumber,name,
                    email,phoneNumber,balance);
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void depositMoney(int accountNumber, double balance) {
        if (balance < 5 || balance > 10000) {
            System.out.print("You can't deposit money less than $5 and more" +
                    " than $10000, please try it again.\n");
            return;
        }
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DEPOSIT_SQL)) {
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, String.valueOf(accountNumber));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println("Successful depositing!");
    }

    @Override
    public void getBalance(int accountNumber) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BALANCE)) {
            preparedStatement.setString(1, String.valueOf(accountNumber));
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.printf("Your balance is: %s.\n", rs.getDouble("balance"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
