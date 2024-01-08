package controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.resident;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {

    private Connection connection;
    private PreparedStatement addUser;
    private PreparedStatement editUser;
    private PreparedStatement pscd;

    public void init() throws ServletException {
        initializeJdbc();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        List<String> errorMsgs = new LinkedList<>();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String ic = request.getParameter("ic");
        String phone = request.getParameter("phone");
        String method = request.getParameter("method");

        try {
            validateInput(name, password, ic, phone);

            if (method.equalsIgnoreCase("edit")) {
                if (!checkDataExist(name)) {
                    out.println("Account does not exist");
                    response.sendRedirect("error.jsp");
                    return;
                }
                resident dataresident = new resident(ic, name, password, phone);
                editUser(dataresident);
                out.println("Edit Successful");
                response.sendRedirect("success.jsp");
            } else {
                if (checkDataExist(name)) {
                    errorMsgs.add("Admin already exists");
                }
                if (!errorMsgs.isEmpty()) {
                    forwardToRegisterPage(request, response, errorMsgs);
                    return;
                }
                 resident dataresident = new resident(ic, name, password, phone);
                addUser(dataresident, id);
                out.println("Data Successful");
                HttpSession session = request.getSession();
                session.setAttribute("success", "Register Successful!");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception ex) {
            handleException(out, ex);
            forwardToRegisterPage(request, response, errorMsgs);
        } finally {
            out.close(); // Close stream
        }
    }

    private void validateInput(String name, String password, String ic, String phone) throws Exception {
        if (isEmptyOrNull(name)) {
            throw new Exception("Please enter the name.");
        }
        if (isEmptyOrNull(password)) {
            throw new Exception("Please enter the password.");
        }
        if (isEmptyOrNull(ic)) {
            throw new Exception("Please enter the IC.");
        }
        if (isEmptyOrNull(phone)) {
            throw new Exception("Please enter the phone.");
        }
    }

    private boolean isEmptyOrNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    private void handleException(PrintWriter out, Exception ex) {
        out.println("Error: " + ex.getMessage());
        ex.printStackTrace(); // Log the exception
    }

    private void forwardToRegisterPage(HttpServletRequest request, HttpServletResponse response, List<String> errorMsgs)
            throws ServletException, IOException {
        request.setAttribute("errorMsgs", errorMsgs);
        RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
        view.forward(request, response);
    }

    private Boolean checkDataExist(String name) throws SQLException {
        validateConnection();
        pscd.setString(1, name);
        try (ResultSet rs = pscd.executeQuery()) {
            return rs.next();
        }
    }

    private void editUser(resident data) throws SQLException {
        validateConnection();
        editUser.setString(1, data.getName());
        editUser.setString(2, data.getPassword());
        editUser.setString(3, data.getIc());
        editUser.setString(4, data.getPhone());
        editUser.executeUpdate();
    }

    private void addUser(resident data, int id) throws SQLException {
        validateConnection();
        addUser.setInt(1, id);
        addUser.setString(2, data.getName());
        addUser.setString(3, data.getPassword());
        addUser.setString(4, data.getIc());
        addUser.setString(5, data.getPhone());
        addUser.executeUpdate();
    }

    private void initializeJdbc() {
        try {
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/crime_system;create=true;user=app;password=app";

            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString);

            pscd = connection.prepareStatement("SELECT * FROM RESIDENT WHERE NAME = ?");
            addUser = connection.prepareStatement("INSERT INTO RESIDENT (ID, NAME, PASSWORD, IC, PHONE) VALUES (?, ?, ?, ?, ?)");
            editUser = connection.prepareStatement("UPDATE RESIDENT SET NAME = ?, PASSWORD = ?, IC = ?, PHONE = ? WHERE ID = ?");
        } catch (Exception ex) {
            ex.printStackTrace(); // Log the exception
        }
    }

    private void validateConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Re-establish the connection if it is closed
            initializeJdbc();
        }
    }

    public String getServletInfo() {
        return "User Controller Servlet";
    }
}
