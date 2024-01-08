
import bean.crime;
import bean.resident;
import bean.place;
import bean.crimeType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.userDataDao;
import dao.placeDao;
import dao.crimeTypeDao;
import dao.CrimeDao;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class reportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();
        placeDao placedao = new placeDao();
        crimeTypeDao typeDao = new crimeTypeDao();
        CrimeDao dao = new CrimeDao();

        ArrayList<crime> crime = dao.getAllCrimes();
        ArrayList<place> place = placedao.getAllplace();
        ArrayList<crimeType> type = typeDao.getAllTypes();
// Assuming you have a method to retrieve a resident by username
        resident res = user.getResidentData(username);

        request.setAttribute("obj", res);
        request.setAttribute("place", place);
        request.setAttribute("crimeType", type);

        request.getRequestDispatcher("user/report.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();
        placeDao placedao = new placeDao();
        crimeType type = new crimeType();
        CrimeDao dao = new CrimeDao();

        ArrayList<crime> crime = dao.getAllCrimes();
        ArrayList<place> place = placedao.getAllplace();
// Assuming you have a method to retrieve a resident by username
        resident res = user.getResidentData(username);

        request.setAttribute("obj", res);
        request.setAttribute("place", place);
        request.setAttribute("crimeType", type);
        request.getRequestDispatcher("user/report.jsp").forward(request, response);
    }

}
