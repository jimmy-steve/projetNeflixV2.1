package controleur.show;

import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * Name : AffTopFilm
 * Permet d'aller chercher dans la bd une liste de nouveauté
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 18/septembre/2022
 */
@WebServlet(name = "AffTopFilms", value = "/AffTopFilms")
public class AffTopFilms extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/vues/films/AffNewFilms.jsp";
        List<Netflix> listeShows = null;

        NetflixDao showDao = new NetflixDao();
        listeShows = showDao.getListNouveaute();


        request.setAttribute("listeShows", listeShows);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
