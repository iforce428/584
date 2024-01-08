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

public class editCrime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");
        String resident_id = request.getParameter("crime_id");
        int id = Integer.parseInt(resident_id);
        
        System.out.println(id);
        placeDao placedao = new placeDao();
        crimeTypeDao typeDao = new crimeTypeDao();
        CrimeDao dao = new CrimeDao();

        ArrayList<crime> crime = dao.getReportCrime(id);
        ArrayList<place> place = placedao.getAllplace();
        ArrayList<crimeType> type = typeDao.getAllTypes();
// Assuming you have a method to retrieve a resident by username

        request.setAttribute("place", place);
        request.setAttribute("crimeType", type);
        request.setAttribute("crime", crime);

        request.getRequestDispatcher("admin/editCrime.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");
        String resident_id = request.getParameter("crime_id");
        int id = Integer.parseInt(resident_id);
        
        System.out.println(id);
        placeDao placedao = new placeDao();
        crimeTypeDao typeDao = new crimeTypeDao();
        CrimeDao dao = new CrimeDao();

        crime crime = dao.getReportCrimeById(id);
        ArrayList<place> place = placedao.getAllplace();
        ArrayList<crimeType> type = typeDao.getAllTypes();
// Assuming you have a method to retrieve a resident by username

        request.setAttribute("place", place);
        request.setAttribute("crimeType", type);
        request.setAttribute("crime", crime);

        request.getRequestDispatcher("admin/editCrime.jsp").forward(request, response);
    }

}