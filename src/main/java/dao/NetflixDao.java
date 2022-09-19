package dao;

import modeles.Client;
import modeles.Netflix;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Name : NetflixDao
 * Classe qui implémente ITem
 * Permettant de sauvegarder tous se qui touche la base de donnée des film de netflix
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 18/septembre/2022
 */

public class NetflixDao implements INetflixDao {
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * name : getAllShows
     * Permet d'aller cherche tout la liste des shows
     *
     * @return une liste de show complête
     */
    @Override
    public List<Netflix> getAllShows() {
        List listeShows = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM netflix;", Netflix.class);
            listeShows = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeShows;
        } finally {
            entityManager.close();
        }
        return listeShows;
    }

    /**
     * Name : getShow
     * Permet d'aller chercher un show et prend le id en int du show
     *
     * @return un show de type show
     */
    @Override
    public Netflix getShow(int id) {
        Netflix show = null;
        EntityManager entityManager = null;
        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            show = entityManager.find(Netflix.class, id);
            return show;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return show;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : updateNetflix
     * Permet de faire l'update d'un films dans la bd
     *
     * @param id          du film
     * @param title       du film
     * @param type        un type de film ou Show
     * @param director    le directeur du film
     * @param cast        le casting du film
     * @param country     le pays d'origine du film
     * @param dateAdded   la date ajouter du film
     * @param releaseYear l'année qu'a sortie le film
     * @param rating      le reting du film
     * @param duration    la duration du film
     * @param listedIn    les catégorie dans lequelle peut etre lister
     * @param description la description du film
     * @return true si l'update a été effectuer
     */
    @Override
    public boolean updateNetflix(int id, String title, String type, String director, String cast,
                                 String country, String dateAdded, int releaseYear, String rating,
                                 String duration, String listedIn, String description) {
        EntityManager entityManager = null;
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*
             * recherche une personne selon son id
             */

            Netflix netflix = entityManager.find(Netflix.class, id);


                netflix.setTitle(title);
                netflix.setType(type);
                netflix.setDirector(director);
                netflix.setCast(cast);
                netflix.setCountry(country);
                netflix.setDateAdded(dateAdded);
                netflix.setReleaseYear(releaseYear);
                netflix.setRating(rating);
                netflix.setDuration(duration);
                netflix.setListedIn(listedIn);
                netflix.setDescription(description);

                ///--------------------------------------------------- probleme lorsque le champ est vide

//            if (!netflix.getTitle().equals(title)) {
//                netflix.setTitle(title);
//            }
//            if (!netflix.getType().equals(type)) {
//                netflix.setType(type);
//            }
//            if (!netflix.getDirector().equals(director) || netflix.getDirector() == null) {
//                netflix.setDirector(director);
//            }
//            if ((!netflix.getCast().equals(cast))) {
//                netflix.setCast(cast);
//            }
//            if (!netflix.getCountry().equals(country)) {
//                netflix.setCountry(country);
//            }
//            if (!netflix.getDateAdded().equals(dateAdded)) {
//                netflix.setDateAdded(dateAdded);
//            }
//            if (netflix.getReleaseYear() != releaseYear) {
//                netflix.setReleaseYear(releaseYear);
//            }
//            if (!netflix.getRating().equals(rating)) {
//                netflix.setRating(rating);
//            }
//            if (!netflix.getDuration().equals(duration)) {
//                netflix.setDuration(duration);
//            }
//            if (!netflix.getListedIn().equals(listedIn)) {
//                netflix.setListedIn(listedIn);
//            }
//            if (!netflix.getDescription().equals(description)) {
//                netflix.setDescription(description);
//            }

            entityManager.merge(netflix);
            entityManager.persist(netflix);
            entityManager.getTransaction().commit();//dans L'etat de persistent
            System.out.println("Réussi");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();//----------------reviens en arrière
            return false;
        } finally {
            entityManager.close();//dans l'etat detached
        }
    }

    /**
     * Name : finNetfixShow
     * Permet d'aller chercher toute les film dans la film avec 2 critères
     *
     * @param currentPage    la page courante
     * @param recordsPerPage le nombre de ligne voulu a l'affichage
     * @return une liste de films
     */
    @Override
    public List<Netflix> findNetflixShow(int currentPage, int recordsPerPage) {
        EntityManager entityManager = null;
        List<Netflix> list = null;

        int start = currentPage * recordsPerPage - recordsPerPage;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM Netflix LIMIT :A, :B", Netflix.class).
                    setParameter("A", start).setParameter("B", recordsPerPage);

            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return list;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getNumberOfRows
     * Permet d'aller chercher dans la bd le nombre d'enregistrement total
     *
     * @return un int qui est le total
     */
    @Override
    public int getNumberOfRows() {
        EntityManager entityManager = null;
        int numOfRows = 0;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM netflix;", Netflix.class);
            numOfRows = query.getResultList().size();


        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return numOfRows;
        } finally {
            entityManager.close();
        }
        return numOfRows;
    }

    /**
     * Name : getAllAmericanMovies
     * Permet de faire une requête et d'aller chercher tout les film américain
     *
     * @return une list de show de netflix
     */
    public List<Netflix> getAllAmericanMovies() {
        List<Netflix> listAmericanShows = new ArrayList<>();
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'United States' and type like 'Movie';", Netflix.class);
            listAmericanShows = query.getResultList();
            return listAmericanShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listAmericanShows;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : GetAllCanadianShowsRecent
     * Permet de faire une reqûete et d'aller chercher une liste des plus récent show canadien
     *
     * @return une list de show canadien
     */
    public List<Netflix> GetAllCanadianShowsRecent() {
        List<Netflix> listCanadianShows = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                            "where country like 'Canada' and type like 'TV Show' and release_year >= 2020 LIMIT 12;"
                    , Netflix.class);
            listCanadianShows = query.getResultList();
            return listCanadianShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listCanadianShows;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : Get allCanadian
     * Permet de faire une requête et d'aller chercher toutes les films canadiens
     *
     * @return une liste de show canadian
     */
    public List<Netflix> GetAllCanadian() {
        List<Netflix> listCanadianShows = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'Canada' ;", Netflix.class);
            listCanadianShows = query.getResultList();
            return listCanadianShows;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listCanadianShows;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getAllAmerican
     * Permet de faire une requête de tous les film américan
     *
     * @return une list de show de netflix de film américain
     */
    public List<Netflix> GetAllAmerican() {
        List<Netflix> listAmerican = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix \n" +
                    "where country like 'United States';", Netflix.class);
            listAmerican = query.getResultList();
            return listAmerican;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listAmerican;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getAllKids
     * Permet d'aller chercher tout la liste des film lister pour enfants
     *
     * @return une liste de film lister dans la catégorie enfant
     */
    public List<Netflix> GetAllkids() {
        List<Netflix> listKids = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix where listed_in like '%Kids%';"
                    , Netflix.class);
            listKids = query.getResultList();
            return listKids;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listKids;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getListNouveaute
     *
     * @return une liste de 12 nouveau films
     */
    public List<Netflix> getListNouveaute() {
        List<Netflix> listNew = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix  where date_added like\n" +
                            "'%September%'and release_year >=2021 LIMIT 12;"
                    , Netflix.class);
            listNew = query.getResultList();
            return listNew;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listNew;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getListTop5
     * permet de faire une requete dans la bd pour aller chercher juste 5 films
     * Pour la bannière
     *
     * @return une liste de 5 films qui sont les plus récents
     */
    public List<Netflix> getListTop5() {
        List<Netflix> listTop5 = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from netflix  where date_added like\n" +
                            "'%September%'and release_year >=2021 LIMIT 5;"
                    , Netflix.class);
            listTop5 = query.getResultList();
            return listTop5;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listTop5;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getListTop5ScienceFiction
     * <p>
     * permet d'aller faire une requête dans la bd et de ramener juste 5 films pour la bannière
     *
     * @return une list de 5 films classé science fictions
     */
    public List<Netflix> getListTop5ScienceFiction() {
        List<Netflix> listTop5ScienceFiction = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("" +
                    "select * from netflix where listed_in like '%Sci-Fi%' limit 5", Netflix.class);
            listTop5ScienceFiction = query.getResultList();
            return listTop5ScienceFiction;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listTop5ScienceFiction;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getListTop5Fantasy
     * permet d'aller faire une reqûete dans la bd et d,aller chercher
     * une liste de 5 films classé fantasy pour la bannière
     *
     * @return une liste de 5 films classé fantasy
     */
    public List<Netflix> getListTop5Fantasy() {
        List<Netflix> listTop5Fantasy = new ArrayList<>();

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("" +
                    "select * from netflix where listed_in like '%Fantasy%' limit 5;", Netflix.class);
            listTop5Fantasy = query.getResultList();
            return listTop5Fantasy;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listTop5Fantasy;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : getList50
     * Permet d'aller chercher dans la bd un liste de 50 film dans la classe fantasy
     * pour un traitement a plus petite échelle sans avoir les 8000 enregistrement
     *
     * @return une list de 50 film de la base de donnée
     */
    public List<Netflix> getList50() {
        List<Netflix> listTop50 = new ArrayList<>();
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("" +
                    "select * from netflix where listed_in like '%Fantasy%' limit 50;", Netflix.class);
            listTop50 = query.getResultList();
            return listTop50;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listTop50;
        } finally {
            entityManager.close();
        }
    }
}
