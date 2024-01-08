
import bean.admin;
import bean.resident;
import bean.crime;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.userDataDao;
import dao.CrimeDao;
import dao.adminDao;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class residentAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();

// Assuming you have a method to retrieve a resident by username
        ArrayList<resident> res = user.getAllUserData();
        adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);

        request.setAttribute("obj", res);
        request.setAttribute("adminData", Admin);

        request.getRequestDispatcher("admin/residentAdmin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();

// Assuming you have a method to retrieve a resident by username
        ArrayList<resident> res = user.getAllUserData();
        adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);

        request.setAttribute("obj", res);
        request.setAttribute("adminData", Admin);

        request.getRequestDispatcher("admin/residentAdmin.jsp").forward(request, response);

    }

}
