/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.admin;
import java.lang.Math;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class AdminController extends HttpServlet {

    private PreparedStatement addMin;
    private PreparedStatement editMin;
    private PreparedStatement pscd;

    public void init() throws ServletException {
        initializeJdbc();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet empController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet empController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int min = 0;
        int max = 99999;
        int id = (int) (Math.random() * (max - min + 1) + min);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List errorMsgs = new LinkedList();

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String method = request.getParameter("method");
        if (method.equalsIgnoreCase("edit")) {
            try {
                if (name.length() == 0) {
                    errorMsgs.add("Please enter the name.");
                }
                
                if (password.length() == 0) {
                    errorMsgs.add("Please enter the password.");
                }
                
                if (!errorMsgs.isEmpty()) {
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
                    view.forward(request, response);
                    return;
                }
                if (checkDataExist(name) == false) {
                    out.println("Account not exist");
                    response.sendRedirect("error.jsp");
                    return;
                }
                admin dataAdmin = new admin(name, password);
                editAdmin(dataAdmin);
                out.println("Edit Successful");
                response.sendRedirect("success.jsp");
            } catch (Exception ex) {
                out.println("Error: " + ex.getMessage());
            } finally {
                out.close(); // Close stream
            }
        } else {
            try {
                if (name.length() == 0) {
                    errorMsgs.add("Please enter the name.");
                }
                if (password.length() == 0) {
                    errorMsgs.add("Please enter the password.");
                }
                if (checkDataExist(name)) {
                    errorMsgs.add("Admin already exist");
                }
                if (!errorMsgs.isEmpty()) {
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
                    view.forward(request, response);
                    return;
                }
                admin dataAdmin = new admin(name, password);
                addAdmin(dataAdmin, id);
                out.println("Data Successful");
//                response.sendRedirect("login.jsp");
                
//                request.setAttribute("success", "Register Successful!");
//                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
//                view.forward(request, response);
                
                HttpSession session = request.getSession();
                session.setAttribute("success", "Register Successful!");
                response.sendRedirect("login.jsp");

            } catch (Exception ex) {
                out.println("Error: " + ex.getMessage());
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/register.jsp"); // or "/editForm.jsp"
                view.forward(request, response);
            } finally {
                out.close(); // Close stream
            }
        }
    }

    private Boolean checkDataExist(String name) throws SQLException {
        pscd.setString(1, name);
        ResultSet rs = pscd.executeQuery();
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    private void editAdmin(admin data) throws SQLException {
        editMin.setString(1, data.getUsername());
        editMin.setString(2, data.getPassword());
        editMin.executeUpdate();
    }

    private void addAdmin(admin data, int id) throws SQLException {
        addMin.setInt(1, id);
        addMin.setString(2, data.getUsername());
        addMin.setString(3, data.getPassword());
        addMin.executeUpdate();
    }

    private void initializeJdbc() {
        try {
            // Declare driver and connection string
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/crime_system; create=true;user=app; password=app";

            // Load the driver
            Class.forName(driver);

            // Connect to the sample database
            Connection conn = DriverManager.getConnection(connectionString);

            // Create a Statement
            pscd = conn.prepareStatement("SELECT * FROM RESIDENT WHERE USERNAME = ?");
            addMin = conn.prepareStatement("INSERT INTO RESIDENT (ID, USERNAME, PASSWORD) VALUES (?, ?, ?)");
//            editMin = conn.prepareStatement("UPDATE ADMIN SET USERNAME = ?, PASSWORD = ? WHERE NAME = ?");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getServletInfo() {
        return "Short description";
    }

}
