
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

public class eCrime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");

        CrimeDao crimedao = new CrimeDao();

        int id = Integer.parseInt(request.getParameter("id"));
        int residentId = Integer.parseInt(request.getParameter("residentId"));
        String crimeName = request.getParameter("crimeName");
        int crimeId = Integer.parseInt(request.getParameter("crimeId"));  // Corrected parameter name
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        String notes = request.getParameter("notes");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        boolean statusUpdate = crimedao.updateCrime(id, residentId, crimeName, crimeId, placeId, notes, date, status);

        System.out.println(statusUpdate);
        request.getRequestDispatcher("crimeAdminServlet").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String username = (String) request.getSession(false).getAttribute("username");

        CrimeDao crimedao = new CrimeDao();

        int id = Integer.parseInt(request.getParameter("id"));
        int residentId = Integer.parseInt(request.getParameter("residentId"));
        String crimeName = request.getParameter("crimeName");
        int crimeId = Integer.parseInt(request.getParameter("crimeId"));  // Corrected parameter name
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        String notes = request.getParameter("notes");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        boolean statusUpdate = crimedao.updateCrime(id, residentId, crimeName, crimeId, placeId, notes, date, status);

        System.out.println(statusUpdate);
        request.getRequestDispatcher("crimeAdminServlet").forward(request, response);
    }

}
