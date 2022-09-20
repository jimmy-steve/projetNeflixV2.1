package controleur.favoris;

import dao.*;
import modeles.Client;
import modeles.Favoris;
import modeles.Netflix;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteFavoris", value = "/DeleteFavoris")
public class DeleteFavoris extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "index.jsp";
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Favoris favoris = (Favoris) session.getAttribute("favoris");

        INetflixDao showDao = new NetflixDao();
        Netflix netflix = showDao.getShow(id);
        User user = (User) session.getAttribute("user");
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClientByIdUser(user.getIdUser());
        Favoris favorisBaseDonnee = new Favoris(client.getIdAbonnement(), user.getIdUser(), netflix.getId());


        IfavorisDao ifavorisDao = new FavorisDao();
        boolean resultat = ifavorisDao.supprimerFavoris(id);

        if (resultat){
            System.out.println("Supression effectuer");
        }

        favoris.setQuantite(favoris.getQuantite()-1);
        List<Netflix> list = favoris.getListFilms();
        //on récupère l'indice de l'item à supprimer
        String del = request.getParameter("delindex");
        //on supprime l'item du panier
        int d = Integer.parseInt(del);
        list.remove(d);

        String suppressionFavoris = "le film a été supprimer avec succèes";
        request.setAttribute("suppressionFavoris", suppressionFavoris);
        session.setAttribute("listeTemporaire", favoris.getListFilms());
        session.setAttribute("favoris", favoris);

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
