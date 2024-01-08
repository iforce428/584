
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
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editPlaceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");

        int id = Integer.parseInt(request.getParameter("id"));

        placeDao placedao = new placeDao();

        place places = placedao.getPlaceById(id);
// Assuming you have a method to retrieve a resident by username

        request.setAttribute("place", places);
        request.getRequestDispatcher("admin/editPlace.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");

        int id = Integer.parseInt(request.getParameter("id"));

        placeDao placedao = new placeDao();

        place places = placedao.getPlaceById(id);
// Assuming you have a method to retrieve a resident by username

        request.setAttribute("place", places);
        request.getRequestDispatcher("admin/editPlace.jsp").forward(request, response);
    }

}
