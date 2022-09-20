package controleur.client;

import dao.ClientDao;
import dao.IUserDao;
import dao.IclientDao;
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
//            String passWord = request.getParameter("passWord");

            IclientDao clientDao = new ClientDao();
            IUserDao iUserDao = new UserDao();
            clientDao.updateClient(numeroClient, nom, prenom, adresse, email, telephone, idUser);

            User user = new User(client.getIdUser(),userName);
            iUserDao.updateUser(idUser, userName);

            request.setAttribute("client", client);
            System.out.println(clientDao.getClient(numeroClient).toString());
        }catch (NumberFormatException e){
            dest = "/WEB-INF/erreur.jsp";
        }
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);





















//        try {
//            long numeroClient = Long.parseLong(request.getParameter("id"));

//            String prenom = request.getParameter("prenom");
//            String nom = request.getParameter("nom");
//            String email = request.getParameter("email");
//            String adresse = request.getParameter("adresse");
//            String telephone = request.getParameter("telephone");
//            long idUser = Long.parseLong(request.getParameter("idUser"));
//            String userName = request.getParameter("userName");

            /*
             * J'ai enlever l'affichage du mot de passe
             */

//            String passWord = request.getParameter("passWord");


//            IclientDao iclientDao = new ClientDao();

//            Client client = iclientDao.getClient(numeroClient);
//            System.out.println(client);
//            boolean resultat =
//                    iclientDao.updateClient(5, nom);

//            Client newClient = iclientDao.getClient(numeroClient);
//
//            System.out.println(newClient);
//
//            System.out.println(resultat);



//            IUserDao iUserDao = new UserDao();
//            iUserDao.updateUser(idUser,userName);
//
//            boolean resultat = iUserDao.updateUser(idUser,userName);

//            if (resultat){
//                System.out.println("L'update a été effectuer avec succès ");
//                System.out.println(iclientDao.getClient(numeroClient).toString());
//                System.out.println(iUserDao.getUser(client.getIdUser()).toString());
//            }


//        }catch (NumberFormatException e){
//            e.getMessage();
//            dest = "/WEB-INF/erreur.jsp";
//        }
//
////        request.setAttribute("client", client);
//        RequestDispatcher disp = request.getRequestDispatcher(dest);
//        disp.forward(request, response);
    }
}
