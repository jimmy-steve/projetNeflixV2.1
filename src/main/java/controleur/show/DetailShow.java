package controleur.show;

import dao.INetflixDao;
import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Name: DetailShow
 * Servlet permettant d'aller chercher les information de chaque films
 * lorsque l'on clique sur le bouton detail mais serais utilisé juste pour le client-------------À vérifier----
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "DetailShow", value = "/DetailShow")
public class DetailShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/vues/films/AffDetailShow.jsp";

        int id = Integer.parseInt(request.getParameter("id"));
        String source = request.getParameter("source");

        Netflix netflix = null;
        INetflixDao showDao = new NetflixDao();

        if (source.equals("ajouterNewFilm")){
            dest="WEB-INF/newShow.jsp";
        }
        if (source.equals("admin")){
            netflix = showDao.getShow(id);
            request.setAttribute("show", netflix);
            dest="WEB-INF/ModifDetailShow.jsp";
        }else if(source.equals("client")){
            netflix = showDao.getShow(id);
            request.setAttribute("show", netflix);
            dest="index.jsp";
        }
//        INetflixDao showDao = new NetflixDao();
//        Netflix netflix = showDao.getShow(id);
//        request.setAttribute("show", netflix);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
