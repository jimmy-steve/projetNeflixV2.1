package controleur.show;

import dao.*;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateShowsAdmin", value = "/UpdateShowsAdmin")
public class UpdateShowsAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/Connecter.jsp";

        int id = Integer.parseInt(request.getParameter("id"));

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

        /*
        On vérifie si les variable sont vide
         */
        if (title.isEmpty() || type.isEmpty() || director.isEmpty()
                || cast.isEmpty() || country.isEmpty() || dateAdded.isEmpty() || releaseYear == 0
                || rating.isEmpty() || duration.isEmpty() || listedIn.isEmpty() || description.isEmpty()) {
            RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/erreur.jsp");
            disp.forward(request, response);
        }

        /*
         Je test un film et je l'affiche dans la console
         */
        Netflix newNetflix = new Netflix(type, title, director, cast, country, dateAdded, releaseYear, rating,
                duration, listedIn, description);
        System.out.println(newNetflix);


        /*
        j'instancie mon interface dao pour updater un objet
         */
        INetflixDao iNetflixDao = new NetflixDao();
        boolean updated = iNetflixDao.updateNetflix(id, title, type, director, cast, country, dateAdded, releaseYear,
                rating, duration, listedIn, description);

        if (updated){
            System.out.println("Le show : " + newNetflix.getTitle() + " a bien été updater");
        }


        request.setAttribute("netflix", newNetflix);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);

    }
}
