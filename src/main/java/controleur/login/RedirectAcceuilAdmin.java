package controleur.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Name : RedirectAcceuilAdmin
 * Permet de rediriger vers l,acceuil de l'administration
 *
 *
 */
@WebServlet(name = "RedirectAcceuilAdmin", value = "/RedirectAcceuilAdmin")
public class RedirectAcceuilAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/Connecter.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
