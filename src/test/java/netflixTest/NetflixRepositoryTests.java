package netflixTest;

import dao.INetflixDao;
import dao.NetflixDao;
import modeles.Netflix;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NetflixRepositoryTests {

    @Test
    public void testInsertBase() {
        Netflix showTest = new Netflix("Test","Film","Title","director","cast",
                "country","date_added", 2024,"rating","duration",
                "listed in", "description");
        INetflixDao showDao = new NetflixDao();
        showDao.insert(showTest);
        System.out.println(showTest);
    }

    @Test
    public void testGetAllShows() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listShows = showDao.getAllShows();

        for (Netflix tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllAmericanMovies() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listShows = showDao.getAllAmericanMovies();

        for (Netflix tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetAllCanadianShowsRecent() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listCanadianShows = showDao.GetAllCanadianShowsRecent();

        for (Netflix tmp : listCanadianShows
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetNouveaute() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> shows = showDao.getListNouveaute();

        for (Netflix tmp : shows
             ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetShow() {
        NetflixDao showDao = new NetflixDao();
        Netflix show = showDao.getShow(5);
        System.out.println(show);
    }

    @Test
    public void testGetlistDe50() {
        NetflixDao showDao = new NetflixDao();
        List<Netflix> listShows = showDao.getList50();

        for (Netflix tmp : listShows
        ) {
            System.out.println(tmp);
        }
    }


}
