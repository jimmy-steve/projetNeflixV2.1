package controleur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Name : ChoixLangue
 *
 * Permet de changer la langue de la page d'accueil
 *
 * @author Erick Solis
 * @since 18/09/2022
 * @version V1
 */
@WebServlet(name = "ChoixLangue", value = "/ChoixLangue")
public class ChoixLangue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String langue = (String)session.getAttribute("langue");
        if(langue == null || request.getParameter("src").equals("1")) {
            String langueChoisie=request.getParameter("langue");
            session.setAttribute("langue",langueChoisie);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Acceuil.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
