package controleur.login;

import dao.*;
import modeles.Abonnement;
import modeles.Client;
import modeles.User;
import utilitaire.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utilitaire.GenerateurNombreSequentiel.genererNombre;

/**
 * Name : Register
 * Servlet permettant d'aller chercher toute les informations du clients et du users
 * Il insère également dans la BD 1 user et 1 client
 *
 * @author Francis Lafontaine
 * @version V2
 * @since 12/sept/2022
 */
@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");

        String dest = "";
        if (source.equals("registerForms")) {
            dest = "formulaireLogin.jsp";
        } else if (source.equals("gestionClientAdmin")) {
            dest = "/WEB-INF/gestionClientAdmin.jsp";
        }

        String prenom = request.getParameter("prenomNew");
        String nom = request.getParameter("nomNew");
        String email = request.getParameter("emailNew");

        String adresse = request.getParameter("adresseNew");
        String telephone = request.getParameter("telephoneNew");

        String typeAbonnement = request.getParameter("typeAbonnementNew");

        String userName = request.getParameter("userNameNew");
        String passWord = request.getParameter("passWordNew");

        if (prenom.isEmpty() || nom.isEmpty() || email.isEmpty()
                || adresse.isEmpty() || telephone.isEmpty() || userName.isEmpty() || passWord.isEmpty()) {
            RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/erreur.jsp");
            disp.forward(request, response);
        }
        UserDao userDao = new UserDao();

        if (!userDao.doExist(userName)) {



            /*
             * je créer un client typique
             */
            Client client = new Client(nom, prenom, adresse, email, telephone, genererNombre());

            /*
             * je créer un user typique
             */

            PasswordUtils passwordUtils = new PasswordUtils();
            passwordUtils.hash(passWord);
            User user = new User(userName, passwordUtils.getHashpassword(), passwordUtils.getSalt());

            /*
             * j'enregistre le user dans la base de donnée
             */
            userDao.insert(user);

            /*
             * J'enregistre le client dans la base de donnée
             */
            client.setIdUser(user.getIdUser());
            IclientDao clientDao = new ClientDao();
            clientDao.insert(client);

            /*
             * je créer un abonnement pour le user
             */
            Abonnement abonnement = new Abonnement(client.getIdAbonnement(), typeAbonnement, 25.77, user.getIdUser());

            /*
             * J"enregistre l'abonnement fans la base donnée
             */
            AbonnementDao abonnementDao = new AbonnementDao();
            abonnementDao.insert(abonnement);

            request.setAttribute("client", client);
            RequestDispatcher disp = request.getRequestDispatcher(dest);
            disp.forward(request, response);
        }else {
            dest = "registerForms.jsp";
            RequestDispatcher disp = request.getRequestDispatcher(dest);
            disp.forward(request, response);
//            response.sendRedirect("registerForms.jsp");
        }
    }
}

