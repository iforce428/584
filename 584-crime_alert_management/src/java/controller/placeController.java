package controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.place;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class placeController extends HttpServlet {

    private PreparedStatement psAdd;

    @Override
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<String> errorMsgs = new LinkedList<>();
        String placename = request.getParameter("placename");
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        try {
            if (placename.length() == 0 ) {
                errorMsgs.add("All form fields are required to complete");
            }

            /*if (checkDataExist(name) == true) {
            errorMsgs.add("Staff exist");
        }*/
            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
                view.forward(request, response);
                return;
            }
            place Place = new place(placeId, placename);
            addPlace(Place);
            out.println("Data Successful");
            response.sendRedirect("placeAdminServlet.do");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close(); // Close stream
        }

    }

    private void addPlace(place data) throws SQLException {
        psAdd.setInt(1, data.getId());
        psAdd.setString(2, data.getPlaceName());
        psAdd.executeUpdate();
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
            psAdd = conn.prepareStatement("INSERT INTO PLACE (ID, PLACENAME) VALUES (?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}