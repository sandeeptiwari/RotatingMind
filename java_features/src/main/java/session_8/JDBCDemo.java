package session_8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1 - JDBC client : Our code/application
 * 2-  JDBC API: standard APIs from oracle which we shou;ld know for connecting with db
 * 3- JDBC Driver: Is a program which is a interface between our JDBC client and db
 * 4- DriverManager : Is a helper class which finds a driver and establish the connection
 *
 *  <dependency>
 *       <groupId>mysql</groupId>
 *       <artifactId>mysql-connector-java</artifactId>
 *       <version>8.0.26</version>
 * </dependency>
 *
 * Assignment:
 *  Create 1 User class
 *     User {
 *          id, username, password, firstname, lastname, age, hobby
 *     }
 *  2- create user table
 *  create table user(accno int, firstName varchar(255), lastname varchar(255), balance bigint);
 *
 *  3- create 1 class UserManager
 *      - login method
 *      - register method
 *      - updateUser
 *      - deleteUser
 *
 *  3- perform login operation by method login, update operation by using update etc...
 */
public class JDBCDemo {


    public static void show() throws SQLException  {
        throw new SQLException("I am null");
    }

    /**
     * If at compile time you get warning from compiler like in future this code can cause exception
     * so this exception known as checked exception
     * @return
     */
    public static Connection conn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
    }

    public static void main(String[] args) {
        try(Connection conn = conn();
            Statement stmt = conn().createStatement();
            ResultSet resultSet = stmt.executeQuery("Select * from account");
          ) {

            //int affectedRows = stmt.executeUpdate("insert into account values (2, 'Poonam', 'xyz', 50000)");
            //int affectedRows = stmt.executeUpdate("update account set accno=4 where balance=10000");
            //int affectedRows = stmt.executeUpdate("delete from account where accno=2");

           List<Account> accounts = new ArrayList<>();

            while (resultSet.next()) {
                /*System.out.println("FirstName : " + resultSet.getString("firstName"));
                System.out.println("LastName : " + resultSet.getString("lastname"));
                System.out.println("Balance : " + resultSet.getString("balance"));*/
                Account account = new Account();
                account.setAccountNumber(resultSet.getInt("accno"));
                account.setFirstName(resultSet.getString("firstName"));
                account.setLastName(resultSet.getString("lastname"));
                account.setBalance(resultSet.getDouble("balance"));

                accounts.add(account);
            }
            System.out.println("# of account " + accounts.size());
            System.out.println("List of Account " + accounts);
            //System.out.println("Affected Rows " + affectedRows);

            accounts =
                    accounts.stream()
                            .filter(account -> account.getBalance() > 500)
                            .collect(Collectors.toList());

            System.out.println("# of account " + accounts.size());
            System.out.println("List of Account " + accounts);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } /*finally {
            conn().close();
            resultSet.close();
        }*/
    }

}
