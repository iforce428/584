package dao;

import bean.crime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.resident;
import java.util.ArrayList;
import util.DBConnection;

public class userDataDao {

    public resident getResidentData(String username) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        resident foundResident = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM RESIDENT WHERE IC = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Populate resident object with data from the result set
                foundResident = new resident();
                foundResident.setIc(resultSet.getString("IC"));
                foundResident.setName(resultSet.getString("NAME"));
                foundResident.setPhone(resultSet.getString("PHONE"));
                String idString = resultSet.getString("ID");
                foundResident.setPassword(resultSet.getString("PASSWORD"));
                int id = Integer.parseInt(idString);
                foundResident.setId(id);
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

        return foundResident;
    }

    public ArrayList<resident> getAllUserData() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<resident> allResidents = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM RESIDENT";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate resident object with data from the result set
                resident foundResident = new resident(); // Create a new Resident object for each record

                // Assuming you have a CrimeRecord class and an instance variable crimeRecord in the Resident class
                foundResident.setIc(resultSet.getString("IC"));
                foundResident.setName(resultSet.getString("NAME"));
                foundResident.setPhone(resultSet.getString("PHONE"));
                int id = resultSet.getInt("ID");
                foundResident.setId(id);

                // Add crime record to the resident
                // Add the populated resident to the list
                allResidents.add(foundResident);
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

        return allResidents;
    }

    public boolean deletePlace(int id) {
        boolean success = false;
        try (Connection connection = DBConnection.createConnection()) {
            if (connection != null) {
                String sql = "DELETE FROM RESIDENT WHERE ID = ? ";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    int rowsAffected = preparedStatement.executeUpdate();
                    success = rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean updateUser(String ic, int id, String name, String phone, String pass) {
        boolean success = false;
        try (Connection connection = DBConnection.createConnection()) {
            if (connection != null) {
                String sql = "UPDATE RESIDENT SET IC=?, NAME = ?, PASSWORD = ?, PHONE = ? WHERE ID=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, ic);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, pass);
                    preparedStatement.setString(4, phone);
                    preparedStatement.setInt(5, id);

                    int rowsAffected = preparedStatement.executeUpdate();
                    success = rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.print(id);
        return success;
    }

}
