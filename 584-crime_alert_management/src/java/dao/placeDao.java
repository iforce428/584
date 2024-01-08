/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.place;
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
public class placeDao {

    public ArrayList<place> getAllplace() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<place> place = new ArrayList<place>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM PLACE";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate crime object with data from the result set
                place places = new place();
                places.setId(Integer.parseInt(resultSet.getString("ID")));
                places.setPlaceName(resultSet.getString("PLACENAME"));

                place.add(places);
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

        return place;
    }

    public place getPlaceById(int ID) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        place foundplace = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM PLACE WHERE ID = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Populate resident object with data from the result set
                foundplace = new place();
                foundplace.setId(Integer.parseInt(resultSet.getString("ID")));
                foundplace.setPlaceName(resultSet.getString("PLACENAME"));
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

        return foundplace;
    }
}
