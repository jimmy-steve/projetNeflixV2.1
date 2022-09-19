package controleur;

import dao.ClientDao;
import dao.INetflixDao;
import dao.NetflixDao;
import dao.UserDao;
import modeles.Client;
import modeles.Netflix;
import modeles.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Name : GestionAdmin
 * Servlet permettant de gèrer le menu de gauche dans le côté administration
 * Elle renvoit les bonnes informations au différente page de gestion
 *
 * @author Francis Lafontaine
 * @version V2
 * @since 12/sept/2022
 */
@WebServlet(name = "GestionAdmin", value = "/GestionAdmin")
public class GestionAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("src");
        String dest = "/WEB-INF/Connecter.jsp";

        HttpSession session = request.getSession();

        if (source.equals("client")) {
            ClientDao clientDao = new ClientDao();
            UserDao userDao = new UserDao();

            List<Client> listClients = clientDao.getAllClients();
            List<User> listUsers = userDao.getAllUsers();

            session.setAttribute("listUsers", listUsers);
            session.setAttribute("listClients", listClients);

            dest = "/WEB-INF/gestionClientAdmin.jsp";
        } else if (source.equals("abonnement")) {
            dest = "/WEB-INF/gestionAbonnementAdmin.jsp";
        } else if (source.equals("show")) {
            dest = "/WEB-INF/gestionShowAdmin.jsp";
            NetflixDao netflixDao = new NetflixDao();

            List<Netflix> listShows = netflixDao.getList50();

            request.setAttribute("listShows", listShows);
        }
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
