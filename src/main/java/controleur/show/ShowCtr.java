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
 * Name: SHowCtr
 * Servlet permettant de faire afficher une liste de film pour le client regulier
 * On va pouvoir y ajouter des filtres pour raccourcir la liste de film
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "ShowCtr", value = "/ShowCtr")
public class ShowCtr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/vues/films/AffListeShow.jsp";
        List<Netflix> listeShows = null;
        String option1 = request.getParameter("pays");
        String action = request.getParameter("action");
        String type = request.getParameter("type");

        System.out.println(option1);
        NetflixDao showDao = new NetflixDao();

        if (action.equals("admin")) {
            dest = "/WEB-INF/Connecter.jsp";
        }


        if (option1.equals("all") && type.equals("kids")) {
            listeShows = showDao.GetAllkids();
        } else if (option1.equals("canada")) {
            listeShows = showDao.GetAllCanadian();
        } else if (option1.equals("usa")) {
            listeShows = showDao.GetAllAmerican();
        } else if (option1.equals("recentCanadianTV")) {
            listeShows = showDao.GetAllCanadianShowsRecent();
        } else if (option1.equals("all")) {
            listeShows = showDao.getAllShows();
        }


        request.setAttribute("listeShows", listeShows);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
