package controleur.show;

import dao.INetflixDao;
import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNewShow", value = "/AddNewShow")
public class AddNewShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/Connecter.jsp";
        String show_id = request.getParameter("showId");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String director = request.getParameter("director");
        String cast = request.getParameter("cast");
        String country = request.getParameter("country");
        String dateAdded = request.getParameter("dateAdded");
        int releaseYear = Integer.parseInt(request.getParameter("releaseYear"));
        String rating = request.getParameter("rating");
        String duration = request.getParameter("duration");
        String listedIn = request.getParameter("listedIn");
        String description = request.getParameter("description");


        if (show_id.isEmpty() || title.isEmpty() || type.isEmpty() || director.isEmpty()
                || cast.isEmpty() || country.isEmpty() || dateAdded.isEmpty() || releaseYear == 0
                || rating.isEmpty() || duration.isEmpty() || listedIn.isEmpty() || description.isEmpty()) {
            RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/erreur.jsp");
            disp.forward(request, response);
        }

        Netflix newNetflix = new Netflix(show_id, title, type, director, cast, country, dateAdded, releaseYear, rating,
                duration, listedIn, description);

        System.out.println(newNetflix);

        INetflixDao iNetflixDao = new NetflixDao();
        iNetflixDao.insert(newNetflix);


        request.setAttribute("netflix", newNetflix);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
