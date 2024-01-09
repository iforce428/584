
import bean.admin;
import bean.crime;
import bean.crimeType;
import bean.place;
import bean.resident;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.userDataDao;
import dao.placeDao;
import dao.crimeTypeDao;
import dao.CrimeDao;
import dao.adminDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletePlace extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");
                adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);
        
        placeDao placedao = new placeDao();
        ArrayList<place> places = placedao.getAllplace();
// Assuming you have a method to retrieve a resident by username
        request.setAttribute("adminData", Admin);
        request.setAttribute("place", places);

        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = placedao.deletePlace(id);

        System.out.println(status);
        request.getRequestDispatcher("placeAdminServlet.do").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");
                adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);
        
        placeDao placedao = new placeDao();
        ArrayList<place> places = placedao.getAllplace();
// Assuming you have a method to retrieve a resident by username
        request.setAttribute("adminData", Admin);
        request.setAttribute("place", places);

        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = placedao.deletePlace(id);

        System.out.println(status);
        request.getRequestDispatcher("placeAdminServlet.do").forward(request, response);
    }

}
