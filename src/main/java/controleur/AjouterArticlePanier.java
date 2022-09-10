package controleur;

import dao.ClientDao;
import dao.FavorisDao;
import dao.IItem;
import dao.NetflixDao;
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
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "AjouterArticlePanier", value = "/AjouterArticlePanier")
public class AjouterArticlePanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "cart.jsp";
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }
        Favoris cart = (Favoris) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");


        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClientByIdUser(user.getIdUser());


        int id = Integer.parseInt(request.getParameter("id"));

        IItem showDao = new NetflixDao();
        Netflix netflix = showDao.getShow(id);

        /*
        Pour la sauvegarde dans la base donnée
         */
        Favoris favoris = new Favoris(client.getIdAbonnement(), user.getIdUser(), netflix.getId());
        favoris.setQuantite(favoris.getQuantite()+1);


        FavorisDao favorisDao = new FavorisDao();
        favorisDao.insertFavoris(favoris);

        /*
        pour l'affichage de la liste
         */
        cart.setQuantite(cart.getQuantite() + 1);
        cart.getListFilms().add(netflix);

        session.setAttribute("listePersonnel", cart.getListFilms());

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
