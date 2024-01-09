/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.admin;
import bean.chart;
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
public class dashboadDao {

    public ArrayList<chart> getReportByYear() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<chart> Alldata = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT MONTH(CRIMEDATE) AS MONTH, COUNT(*) AS REPORT_COUNT FROM CRIME WHERE YEAR(CRIMEDATE) = 2024 GROUP BY MONTH(CRIMEDATE) ORDER BY MONTH(CRIMEDATE)";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate resident object with data from the result set

                // Assuming you have a CrimeRecord class and an instance variable crimeRecord in the Resident class
                String label = resultSet.getString("MONTH");
                int id = resultSet.getInt("REPORT_COUNT");
                chart data = new chart(label, id); // Create a new Resident object for each record

                // Add crime record to the resident
                // Add the populated resident to the list
                Alldata.add(data);
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

        System.out.println("the data is " + Alldata.get(1).getLabel() + "" + Alldata.get(1).getData());
        return Alldata;
    }

    public chart getReportThisMonth() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        chart foundChart = null;

        try {
            con = DBConnection.createConnection();
            String query = "SELECT\n"
                    + "    MONTH(CRIMEDATE) AS MONTH,\n"
                    + "    COUNT(*) AS REPORT_COUNT\n"
                    + "FROM\n"
                    + "    CRIME\n"
                    + "WHERE\n"
                    + "    YEAR(CRIMEDATE) = 2024 AND MONTH(CRIMEDATE) = 1\n"
                    + "GROUP BY\n"
                    + "    MONTH(CRIMEDATE)\n"
                    + "ORDER BY\n"
                    + "    MONTH(CRIMEDATE)";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Populate resident object with data from the result set

                String label = resultSet.getString("MONTH");
                int data = resultSet.getInt("REPORT_COUNT");
                foundChart = new chart(label, data);
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

        System.out.println("the data (month) is " + foundChart.getLabel() + "" + foundChart.getData());
        return foundChart;
    }

    public ArrayList<chart> getReportByPlace() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<chart> allData = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT PLACE.PLACENAME AS PLACENAME, COUNT(*) as CRIME_COUNT\n"
                    + "FROM CRIME\n"
                    + "JOIN PLACE ON CRIME.PLACE_ID = PLACE.ID\n"
                    + "GROUP BY PLACE.PLACENAME\n"
                    + "ORDER BY PLACE.PLACENAME";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate resident object with data from the result set

                // Assuming you have a CrimeRecord class and an instance variable crimeRecord in the Resident class
                String label = resultSet.getString("PLACENAME");
                int id = resultSet.getInt("CRIME_COUNT");
                chart data = new chart(label, id); // Create a new Resident object for each record

                // Add crime record to the resident
                // Add the populated resident to the list
                allData.add(data);
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
        System.out.println("the data (Place) is " + allData.get(1).getLabel() + "" + allData.get(1).getData());

        return allData;
    }

    public ArrayList<chart> getReportBySeverity() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<chart> allData = new ArrayList<>();

        try {
            con = DBConnection.createConnection();
            String query = "SELECT CRIMETYPE.CRIMENAME as CRIMENAME, COUNT(*) AS CRIME_COUNT\n"
                    + "FROM CRIME\n"
                    + "JOIN CRIMETYPE ON CRIME.CRIME_ID = CRIMETYPE.ID\n"
                    + "GROUP BY CRIMETYPE.CRIMENAME\n"
                    + "ORDER BY CRIMETYPE.CRIMENAME";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Populate resident object with data from the result set

                // Assuming you have a CrimeRecord class and an instance variable crimeRecord in the Resident class
                String label = resultSet.getString("CRIMENAME");
                int id = resultSet.getInt("CRIME_COUNT");

                chart data = new chart(label, id); // Create a new Resident object for each record
                // Add crime record to the resident
                // Add the populated resident to the list
                allData.add(data);
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

        System.out.println("the data (crime) is " + allData.get(1).getLabel() + "" + allData.get(1).getData());
        return allData;
    }
}
