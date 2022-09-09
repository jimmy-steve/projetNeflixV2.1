package controleur.client;

import dao.ClientDao;
import dao.UserDao;
import modeles.Client;
import modeles.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateClient", value = "/UpdateClient")
public class UpdateClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/Connecter.jsp";
        HttpSession session = request.getSession();
        Client client = new Client();

        try {
            long numeroClient = Long.parseLong(request.getParameter("id"));

            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String adresse = request.getParameter("adresse");
            String telephone = request.getParameter("telephone");
            long idUser = Long.parseLong(request.getParameter("idUser"));
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");

            ClientDao clientDao = new ClientDao();
            UserDao userDao = new UserDao();
            clientDao.updateClient(numeroClient, nom, prenom, adresse, email, telephone, idUser);

            User user = new User(client.getIdUser(),userName,passWord);
            userDao.updateUser(user);

            System.out.println(ClientDao.getClient(numeroClient).toString());
        }catch (NumberFormatException e){
            dest = "/WEB-INF/erreur.jsp";
        }

        request.setAttribute("client", client);
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
}
