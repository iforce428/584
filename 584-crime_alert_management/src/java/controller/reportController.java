package controller;

import bean.crime; // Assuming crime is a class in the "bean" package
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class reportController extends HttpServlet {
    private PreparedStatement psAdd;

    @Override
    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int min = 0;
        int max = 99999;
        int id = (int) (Math.random() * (max - min + 1) + min);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<String> errorMsgs = new LinkedList<>();
        String crimeName = request.getParameter("crimeName");
        int residentId = Integer.parseInt(request.getParameter("residentId"));
        int crimeId = Integer.parseInt(request.getParameter("crimeId"));
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        String notes = request.getParameter("notes");
        String status = "pending";
        String date = request.getParameter("date");
        try {
            if (crimeName.length() == 0 || notes.length() == 0 || residentId <= 0 || crimeId <= 0 || placeId <= 0) {
                errorMsgs.add("All form fields are required to complete");
            }

            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }

            crime dataCrime = new crime(id, crimeName, residentId, crimeId, placeId, notes, date, status);
            addCrime(dataCrime, id);
                out.println("Data Successful");
                HttpSession session = request.getSession();
                session.setAttribute("success", "Register Successful!");
                response.sendRedirect("reportServlet.do");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close();
        }
    }

    private void addCrime(crime data, int id) throws SQLException {
        psAdd.setInt(1, id);
        psAdd.setString(2, data.getCrimename());
        psAdd.setInt(3, data.getResident_id());
        psAdd.setInt(4, data.getCrime_id());
        psAdd.setInt(5, data.getPlace_id());
        psAdd.setString(6, data.getNotes());
        psAdd.setString(7, data.getTime());
        psAdd.setString(8, data.getStatus());
        psAdd.executeUpdate();
    }

    private void initializeJdbc() {
        try {
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/crime_system; create=true;user=app; password=app";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            psAdd = conn.prepareStatement("INSERT INTO CRIME (ID, CRIMENAME, RESIDENT_ID, CRIME_ID, PLACE_ID, NOTES, CRIMEDATE, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reportController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
