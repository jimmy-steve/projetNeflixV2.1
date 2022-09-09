package controleur.client;

import dao.ClientDao;
import dao.UserDao;
import modeles.Client;
import modeles.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Name : GetClient
 * Servlet permettant d'aller chercher un client combiné a un user
 * Permettant d'avoir tout les informations du client
 * On peut donc cliquer sur le liens modifé dans la liste des client
 * et faire apparaitre les données du client dans la table a gauche
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
@WebServlet(name = "GetClient", value = "/GetClient")
public class GetClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/gestionClientAdmin.jsp";
        long numeroClient = Long.parseLong(request.getParameter("id"));

        Client client = (Client) ClientDao.getClient(numeroClient);

        User user = UserDao.getUser(client.getIdUser());

        System.out.println(user);
        System.out.println(client);

        request.setAttribute("user", user);
        request.setAttribute("client", client);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
