package jantristanmilan;

import com.google.gson.Gson;
import jantristanmilan.data.Advertisement;
import jantristanmilan.data.AdvertisementDAO;
import jantristanmilan.data.MySQLAdvertisementDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd =
                request.getRequestDispatcher("WEB-INF/search.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        AdvertisementDAO advertisementDAO = new MySQLAdvertisementDAO();
        List<Advertisement> advertisements = advertisementDAO.getAll();
        Gson gson = new Gson();
        String json = gson.toJson(advertisements);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
