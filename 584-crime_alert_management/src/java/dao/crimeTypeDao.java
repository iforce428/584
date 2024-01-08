/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.crimeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author mamir
 */
public class crimeTypeDao {

    public ArrayList<crimeType> getAllTypes(){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<crimeType> type = new ArrayList<crimeType>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM CRIMETYPE";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate crime object with data from the result set
                crimeType types = new crimeType();
                types.setId(Integer.parseInt(resultSet.getString("ID")));
                types.setCrimeType(resultSet.getString("CRIMENAME"));

                type.add(types);
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

        return type;
    }
}
