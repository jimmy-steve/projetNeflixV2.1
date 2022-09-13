package controleur.favoris;

import dao.ClientDao;
import dao.FavorisDao;
import dao.IfavorisDao;
import dao.UserDao;
import modeles.Client;
import modeles.Favoris;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "SauvegarderFavoris", value = "/SauvegarderFavoris")
public class SauvegarderFavoris extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "index.jsp";

        HttpSession session = request.getSession();
        Vector  listFavoris = (Vector) session.getAttribute("listeFavoris");

//        long numeroClient = Long.parseLong(request.getParameter("id"));

//        Client client = (Client) ClientDao.getClient(numeroClient);
//        User user = UserDao.getUser(client.getIdUser());
//
//        System.out.println(user);
//        System.out.println(client);
//
//        request.setAttribute("user", user);
//        request.setAttribute("client", client);


        IfavorisDao ifavorisDao = new FavorisDao();
        boolean resultat = ifavorisDao.SaveListFavoris(listFavoris);

        if (resultat) {
            System.out.println("La liste a été effectuer avec succès");
        }


        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
