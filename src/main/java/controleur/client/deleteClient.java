package controleur.client;

import dao.ClientDao;
import dao.UserDao;
import modeles.Client;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deleteClient", value = "/deleteClient")
public class deleteClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dest = "/WEB-INF/Connecter.jsp";

        //------------------------------------------pour permettre laffichage de la liste a droite
        ClientDao clientDao = new ClientDao();
        UserDao userDao = new UserDao();

        List<Client> listClients = clientDao.getAllClients();
        List<User> listUsers = userDao.getAllUsers();

        session.setAttribute("listUsers", listUsers);
        session.setAttribute("listClients", listClients);

        long numeroClient = Long.parseLong(request.getParameter("id"));

        /*
        On delete le user et le client
         */
        Client client = ClientDao.deleteClient(numeroClient);
        System.out.println(userDao.deleteUser(client.getIdUser()));
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
