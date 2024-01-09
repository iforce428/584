package dao;

import bean.crime;
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
public class CrimeDao {

    public ArrayList<crime> getAllCrimes() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<crime> allCrimes = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT CRIME.ID AS CRIME_IDS, CRIME.CRIMENAME AS CRIME_NAME, CRIME.PLACE_ID, CRIME.RESIDENT_ID, CRIME.CRIME_ID, CRIME.NOTES, CRIME.CRIMEDATE, CRIME.STATUS, "
                    + "PLACE.PLACENAME, RESIDENT.ID, CRIMETYPE.CRIMENAME "
                    + "FROM CRIME "
                    + "JOIN PLACE ON CRIME.PLACE_ID = PLACE.ID "
                    + "JOIN RESIDENT ON CRIME.RESIDENT_ID = RESIDENT.ID "
                    + "JOIN CRIMETYPE ON CRIME.CRIME_ID = CRIMETYPE.ID";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate crime object with data from the result set
                crime crimeRecord = new crime();
                crimeRecord.setID(Integer.parseInt(resultSet.getString("CRIME_IDS")));
                crimeRecord.setCrimename(resultSet.getString("CRIME_NAME"));
                crimeRecord.setResident_id(Integer.parseInt(resultSet.getString("RESIDENT_ID")));
                crimeRecord.setCrimetype(resultSet.getString("CRIMENAME"));
                crimeRecord.setPlace(resultSet.getString("PLACENAME"));
                crimeRecord.setCrime_id(Integer.parseInt(resultSet.getString("CRIME_ID")));
                crimeRecord.setPlace_id(Integer.parseInt(resultSet.getString("PLACE_ID")));
                crimeRecord.setNotes(resultSet.getString("NOTES"));
                crimeRecord.setTime(resultSet.getString("CRIMEDATE"));
                crimeRecord.setStatus(resultSet.getString("STATUS"));

                allCrimes.add(crimeRecord);
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

        return allCrimes;
    }

    public ArrayList<crime> getReportCrime(int residentId) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<crime> crimes = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT CRIME.ID AS CRIME_IDS, CRIME.CRIMENAME AS CRIME_NAME, CRIME.PLACE_ID, CRIME.RESIDENT_ID, CRIME.CRIME_ID, CRIME.NOTES, CRIME.CRIMEDATE, CRIME.STATUS, "
                    + "PLACE.PLACENAME, RESIDENT.ID, CRIMETYPE.CRIMENAME "
                    + "FROM CRIME "
                    + "JOIN PLACE ON CRIME.PLACE_ID = PLACE.ID "
                    + "JOIN RESIDENT ON CRIME.RESIDENT_ID = RESIDENT.ID "
                    + "JOIN CRIMETYPE ON CRIME.CRIME_ID = CRIMETYPE.ID WHERE CRIME.RESIDENT_ID = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, residentId); // Use setInt instead of setString for an integer parameter
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate crime object with data from the result set
                crime crimeRecord = new crime();
                crimeRecord.setID(resultSet.getInt("CRIME_IDS")); // Use getInt for integer columns
                crimeRecord.setCrimename(resultSet.getString("CRIME_NAME"));
                crimeRecord.setResident_id(resultSet.getInt("RESIDENT_ID")); // Use getInt for integer columns
                crimeRecord.setCrimetype(resultSet.getString("CRIMENAME"));
                crimeRecord.setPlace(resultSet.getString("PLACENAME"));
                crimeRecord.setCrime_id(resultSet.getInt("CRIME_ID")); // Use getInt for integer columns
                crimeRecord.setPlace_id(resultSet.getInt("PLACE_ID")); // Use getInt for integer columns
                crimeRecord.setNotes(resultSet.getString("NOTES"));
                crimeRecord.setTime(resultSet.getString("CRIMEDATE"));
                crimeRecord.setStatus(resultSet.getString("STATUS"));

                crimes.add(crimeRecord);
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

        return crimes;
    }

    public crime getReportCrimeById(int id) {
        crime crimeRecord = null;

        try (Connection con = DBConnection.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(
                        "SELECT CRIME.ID AS CRIME_IDS, CRIME.CRIMENAME AS CRIME_NAME, CRIME.PLACE_ID, CRIME.RESIDENT_ID, CRIME.CRIME_ID, CRIME.NOTES, CRIME.CRIMEDATE, CRIME.STATUS, "
                        + "PLACE.PLACENAME, RESIDENT.ID, CRIMETYPE.CRIMENAME "
                        + "FROM CRIME "
                        + "JOIN PLACE ON CRIME.PLACE_ID = PLACE.ID "
                        + "JOIN RESIDENT ON CRIME.RESIDENT_ID = RESIDENT.ID "
                        + "JOIN CRIMETYPE ON CRIME.CRIME_ID = CRIMETYPE.ID WHERE CRIME.ID = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    crimeRecord = new crime();
                    crimeRecord.setID(resultSet.getInt("CRIME_IDS"));
                    crimeRecord.setCrimename(resultSet.getString("CRIME_NAME"));
                    crimeRecord.setResident_id(resultSet.getInt("RESIDENT_ID"));
                    crimeRecord.setCrimetype(resultSet.getString("CRIMENAME"));
                    crimeRecord.setPlace(resultSet.getString("PLACENAME"));
                    crimeRecord.setCrime_id(resultSet.getInt("CRIME_ID"));
                    crimeRecord.setPlace_id(resultSet.getInt("PLACE_ID"));
                    crimeRecord.setNotes(resultSet.getString("NOTES"));
                    crimeRecord.setTime(resultSet.getString("CRIMEDATE"));
                    crimeRecord.setStatus(resultSet.getString("STATUS"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return crimeRecord;
    }

    public boolean deleteCrime(int ID) {
        boolean success = false;
        try (Connection connection = DBConnection.createConnection()) {
            if (connection != null) {
                String sql = "DELETE FROM CRIME WHERE ID = ? ";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, ID);

                    int rowsAffected = preparedStatement.executeUpdate();
                    success = rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean updateCrime(int id, int residentId, String crimeName, int crimeId, int placeId, String notes, String date, String status) {
        boolean success = false;
        try (Connection connection = DBConnection.createConnection()) {
            if (connection != null) {
                String sql = "UPDATE CRIME SET CRIMENAME=?, RESIDENT_ID=?, CRIME_ID=?, PLACE_ID=?, NOTES=?, CRIMEDATE=?, STATUS=? WHERE ID=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, crimeName);
                    preparedStatement.setInt(2, residentId);
                    preparedStatement.setInt(3, crimeId);
                    preparedStatement.setInt(4, placeId);
                    preparedStatement.setString(5, notes);
                    preparedStatement.setString(6, date);
                    preparedStatement.setString(7, status);
                    preparedStatement.setInt(8, id);

                    int rowsAffected = preparedStatement.executeUpdate();
                    success = rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

}
