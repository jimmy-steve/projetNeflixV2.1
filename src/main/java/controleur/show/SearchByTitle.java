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
        String dest = "/vues/films/AffListeShow.jsp";
        String titleSearch = request.getParameter("titleSearch");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        INetflixDao iNetflixDao = new NetflixDao();
        List<Netflix> listRechercher = iNetflixDao.findNetflixByTitle(titleSearch);
        request.setAttribute("smallList", listRechercher);

        for (Netflix tmp : listRechercher
        ) {
            System.out.println(tmp);
        }


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

        RequestDispatcher disp = request.getRequestDispatcher(dest);
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
