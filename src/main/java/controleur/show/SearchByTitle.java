package controleur.show;

import dao.INetflixDao;
import dao.NetflixDao;
import modeles.Netflix;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchByTitle", value = "/SearchByTitle")
public class SearchByTitle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dest = "";
        String titleSearch = request.getParameter("titleSearch");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        String source = request.getParameter("source");

        /*
        Recherche avec le mot clé dans la title de film
         */
        INetflixDao iNetflixDao = new NetflixDao();
        List<Netflix> listRechercher = iNetflixDao.findNetflixByTitle(titleSearch);

        /*
        Affichage console de la recherche
         */
        for (Netflix tmp : listRechercher
        ) {
            System.out.println(tmp);
        }


        if (source.equals("admin")) {
            dest = "/WEB-INF/Connecter.jsp";
            request.setAttribute("listShows", listRechercher);

        /*
        Je simule 50 ligne mais on pourrait aller chercher le nombre de ligne complete
        mais dans notre cas
         */
             //       int rows = iNetflixDao.getNumberOfRows();
            //int rows = 50;//---------------------on simule 50 lignes mais le traitement peut se faire


            int nOfPages = listRechercher.size() / recordsPerPage;

            if (nOfPages % recordsPerPage > 0) {

                nOfPages++;
            }

            request.setAttribute("noOfPages", nOfPages);
            System.out.println(nOfPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("recordsPerPage", recordsPerPage);


        } else if (source.equals("pasAdmin")) {
            dest = "/vues/films/AffListeShow.jsp";


            int rowPerPage = 20;
            if (listRechercher.size() >= 20) {
                int nbrPage = listRechercher.size() / rowPerPage;
                request.setAttribute("rowPerPage", rowPerPage);
                request.setAttribute("nbrPage", nbrPage);
                request.setAttribute("currentPage", currentPage);
                int end;

                int start = currentPage * rowPerPage - rowPerPage;
                if (start + rowPerPage > listRechercher.size()) {
                    end = listRechercher.size() - 1;
                } else {
                    end = start + rowPerPage;
                }
                List<Netflix> smallList = listRechercher.subList(start, end);
                request.setAttribute("smallList", smallList);
            }

            request.setAttribute("smallList", listRechercher);

        }




        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
