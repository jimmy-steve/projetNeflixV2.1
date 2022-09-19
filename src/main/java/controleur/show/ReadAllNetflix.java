package controleur.show;

import dao.INetflixDao;
import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * Name ReadAllNetflix
 * Servlet qui permet d'aller chercher tout les films
 * Et de les afficher avec l'aide de la pagination selon les critères passer en paramètre
 * qui sont la page current et le nombre de ligne par page
 *
 * @author Francis lafontaine
 * @version V2
 * @since 18/septembre/2022
 */
@WebServlet(name = "ReadAllNetflix", value = "/ReadAllNetflix")
public class ReadAllNetflix extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();


        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));

        INetflixDao iNetflixDao = new NetflixDao();

        List<Netflix> list = iNetflixDao.findNetflixShow(currentPage, recordsPerPage);

        request.setAttribute("listShows", list);

        /*
        Je simule 50 ligne mais on pourrait aller chercher le nombre de ligne complete
        mais dans notre cas
         */
        //        int rows = iNetflixDao.getNumberOfRows();
        int rows = 50;//---------------------on simule 50 lignes mais le traitement peut se faire


        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Connecter.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
