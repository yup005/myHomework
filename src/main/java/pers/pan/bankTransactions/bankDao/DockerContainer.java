package pers.pan.bankTransactions.bankDao;

import java.sql.*;


public class DockerContainer {
    public static void main(String[] args) {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://databasepan.cttusmxetoju.us-west-1.rds.amazonaws.com:3306/bankDB";
        final String USER = "admin";
        final String PASS = "password_pan";
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating table in the database...");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE TestJava "
                    + "(AccountID INTEGER not NULL, "
                    + "name VARCHAR(255), "
                    + "email VARCHAR(255), "
                    + "phoneNumber VARCHAR(255), "
                    + "balance DOUBLE, "
                    + "PRIMARY KEY ( AccountID ))";
            stmt.executeUpdate(sql);
            System.out.println("Successful creating!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

