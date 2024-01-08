/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LoginBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author User
 */
public class LoginDao {

    public String authAdmin(LoginBean loginBean) {
        String userName = loginBean.getUsername(); //Assign user entered values to temporary 
        String password = loginBean.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultset = null;
        String userNameDB = "";
        String passwordDB = "";

        try {
            con = DBConnection.createConnection(); //Fetch database connection object
            statement = con.createStatement(); //Statement is used to write queries. Read more
            resultset = statement.executeQuery("select USERNAME, PASSWORD from ADMIN"); //the ti 
            while (resultset.next()) {
                userNameDB = resultset.getString("username"); //fetch the values present in databa 
                passwordDB = resultset.getString("password");
                if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                    return "SUCCESS"; ////If the user entered values are already present in the datal
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials"; // Return appropriate message in case of failure
    }

    public boolean authUser(LoginBean data) {
        String userName = data.getUsername(); // Assign user entered values to temporary 
        String password = data.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultset = null;
        String userNameDB = "";
        String passwordDB = "";

        try {
            con = DBConnection.createConnection(); // Fetch database connection object
            statement = con.createStatement(); // Statement is used to write queries.
            resultset = statement.executeQuery("select IC, PASSWORD from RESIDENT"); // Query to retrieve username and password from the RESIDENT table
            while (resultset.next()) {
                userNameDB = resultset.getString("ic"); // Fetch the values present in the database
                passwordDB = resultset.getString("password");
                if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                    return true; // If the user entered values match a record in the database, return true
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        } finally {
            // Close resources in the finally block to ensure they are released
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // If no match is found or an exception occurs, return false
    }

}
