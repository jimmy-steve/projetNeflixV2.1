package controleur.show;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateShowsAdmin", value = "/UpdateShowsAdmin")
public class UpdateShowsAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dest = "/WEB-INF/Connecter.jsp";
//        int id = Integer.parseInt(request.getParameter("id"));

//        String title = request.getParameter("title");
//        String type = request.getParameter("type");



        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
