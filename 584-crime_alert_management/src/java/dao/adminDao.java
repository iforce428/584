/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

/**
 *
 * @author mamir
 */
public class adminDao {
        public admin getAdminData(String username) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        admin foundAdmin = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM ADMIN WHERE USERNAME = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Populate resident object with data from the result set
                foundAdmin = new admin();
                foundAdmin.setUsername(resultSet.getString("USERNAME"));
                String idString = resultSet.getString("ID");
                int id = Integer.parseInt(idString);
                foundAdmin.setId(id);
                // Set other properties as needed
                // For example:
                // foundResident.setName(resultSet.getString("name"));
                // foundResident.setAddress(resultSet.getString("address"));
                // ...

                // You should set all the properties you need from the result set
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return foundAdmin;
    }
}
