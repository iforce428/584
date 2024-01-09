
import bean.resident;
import bean.chart;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.userDataDao;
import dao.dashboadDao;
import java.util.ArrayList;
import dao.adminDao;
import bean.admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        dashboadDao dao = new dashboadDao();
        ArrayList<chart> reportByYear = dao.getReportByYear();
        chart reportThisMonth = dao.getReportThisMonth();
        ArrayList<chart> reportBySeverity = dao.getReportBySeverity();
        ArrayList<chart> reportByPlace = dao.getReportByPlace();

        System.out.println("why not " + reportByYear.get(1).getLabel() + "" + reportByYear.get(1).getData());
        adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);
        request.setAttribute("adminData", Admin);
        request.setAttribute("reportThisMonth", reportThisMonth);
        request.setAttribute("reportByYear", reportByYear);
        request.setAttribute("reportBySeverity", reportBySeverity);
        request.setAttribute("reportByPlace", reportByPlace);

        request.getRequestDispatcher("admin/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession(false).getAttribute("username");
        dashboadDao dao = new dashboadDao();
        ArrayList<chart> reportByYear = dao.getReportByYear();
        chart reportThisMonth = dao.getReportThisMonth();
        ArrayList<chart> reportBySeverity = dao.getReportBySeverity();
        ArrayList<chart> reportByPlace = dao.getReportByPlace();

        System.out.println("why not " + reportByYear.get(1).getLabel() + "" + reportByYear.get(1).getData());
        adminDao admindao = new adminDao();
        admin Admin = admindao.getAdminData(username);
        request.setAttribute("adminData", Admin);
        request.setAttribute("reportThisMonth", reportThisMonth);
        request.setAttribute("reportByYear", reportByYear);
        request.setAttribute("reportBySeverity", reportBySeverity);
        request.setAttribute("reportByPlace", reportByPlace);

        request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
    }

}
