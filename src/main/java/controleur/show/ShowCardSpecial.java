package controleur.show;

import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Name: SHowCardSpecial
 * Servlet permettant de faire afficher un certain nombre de film
 * mais de façon différente et avec un peux d'animation
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "ShowCardSpecial", value = "/ShowCardSpecial")
public class ShowCardSpecial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/vues/films/AffCardTourne.jsp";

        NetflixDao showDao = new NetflixDao();
        List<Netflix> listeShows = showDao.GetAllCanadianShowsRecent();
        request.setAttribute("listeShows", listeShows);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
