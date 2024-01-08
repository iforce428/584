import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import bean.crime;
import bean.resident;
import dao.CrimeDao;
import dao.userDataDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class dashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();
        CrimeDao dao = new CrimeDao();
        ArrayList<crime> crimes = dao.getAllCrimes();

        // Assuming you have a method to retrieve a resident by username
        resident res = user.getResidentData(username);

        request.setAttribute("obj", res);
        request.setAttribute("crime", crimes);

        // Assuming "user.jsp" is in the "user" folder
        request.getRequestDispatcher("user/user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        userDataDao user = new userDataDao();
        CrimeDao dao = new CrimeDao();
        ArrayList<crime> crimes = dao.getAllCrimes();

        // Assuming you have a method to retrieve a resident by username
        resident res = user.getResidentData(username);

        request.setAttribute("obj", res);
        request.setAttribute("crime", crimes);

        // Assuming "user.jsp" is in the "user" folder
        request.getRequestDispatcher("user/user.jsp").forward(request, response);
    }
}
