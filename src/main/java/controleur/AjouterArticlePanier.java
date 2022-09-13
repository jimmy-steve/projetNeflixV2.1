package controleur;

import dao.*;
import modeles.Client;
import modeles.Favoris;
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

/**
 * Name : AjouterArticlePanier
 * <p>
 * Permet d'ajouter un article a notre panier
 *
 * @author Francis Lafontaine
 * @version V2
 * @since 23/sept/2022
 */
@WebServlet(name = "AjouterArticlePanier", value = "/AjouterArticlePanier")
public class AjouterArticlePanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "index.jsp";
        HttpSession session = request.getSession();

        Favoris favoris = (Favoris) session.getAttribute("favoris");
        User user = (User) session.getAttribute("user");


        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClientByIdUser(user.getIdUser());


        int id = Integer.parseInt(request.getParameter("id"));

        INetflixDao showDao = new NetflixDao();
        Netflix netflix = showDao.getShow(id);

        /*z
        Pour la sauvegarde dans la base donnée
         */
        Favoris favorisBaseDonnee = new Favoris(client.getIdAbonnement(), user.getIdUser(), netflix.getId());
        FavorisDao favorisDao = new FavorisDao();
        favorisDao.insertFavoris(favorisBaseDonnee);

        /*
        pour l'affichage de la liste
         */
        favoris.setQuantite(favoris.getQuantite()+1);
        favoris.getListFilms().add(netflix);


        session.setAttribute("favoris", favoris);

        session.setAttribute("listeTemporaire", favoris.getListFilms());

        session.setAttribute("favorisBaseDeDonnee", favorisBaseDonnee );

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
