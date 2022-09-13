package controleur.login;

import dao.*;
import modeles.Client;
import modeles.Favoris;
import modeles.Netflix;
import modeles.User;
import utilitaire.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Name : Login
 * Servlet permettant de controller le login
 * devrait être modifié pour être intégrer au bloque de gabriel Gagnon------------------------a vérifier
 * car les user ne sont pas valider ............................faire un get user by username et password
 *
 * il sont écrit en dur
 * frank password=1234---admin
 * alex password=1234--- client régulier
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }

        String dest = "";
        List<Netflix> listeShows = null;
        User user = null;

        try {

            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            UserDao userDao = new UserDao();

            PasswordUtils passwordUtils = new PasswordUtils();
            user = (User) userDao.find(userName);
            if (user == null){
                response.sendRedirect("/formulaireLogin.jsp");
            }

            String passwordHash = user.getHashPassword();
            String salt = user.getSalt();

            boolean isValid = passwordUtils.verify(passWord,passwordHash,salt);



                if (isValid && user.isAdmin()) {

                    dest = "/WEB-INF/Connecter.jsp";

                } else if (isValid && !user.isAdmin()) {

                    List<Netflix> listFilmsPersonel = new ArrayList<>();
                    Favoris favoris = new Favoris(0, listFilmsPersonel);


                    /*
                    on prépare une liste de film a afficher
                     */

                    NetflixDao showDao = new NetflixDao();
                    listeShows = showDao.getListTop5();
                    List<Netflix> listeShowsScienceFiction = showDao.getListTop5ScienceFiction();
                    List<Netflix> listeShowsFantasy = showDao.getListTop5Fantasy();




                    session.setAttribute("listTop5", listeShows);
                    session.setAttribute("listTop5ScienceFiction", listeShowsScienceFiction);
                    session.setAttribute("listeShowsFantasy", listeShowsFantasy);

                    session.setAttribute("listeTemporaire", listFilmsPersonel);
                    session.setAttribute("favoris", favoris);
                    dest = "index.jsp";
                } else {
                    dest = "/WEB-INF/erreurConnection.jsp";
                }
                session.setAttribute("user", user);
        } catch (NumberFormatException e) {
            dest = "/WEB-INF/erreur.jsp";
        }
        session.setAttribute("listeShows", listeShows);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
