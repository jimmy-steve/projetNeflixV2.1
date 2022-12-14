package modeles;

import javax.persistence.*;

/**
 * Name : Netflix
 * Classe POJO pour les films
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 18/septembre/2022
 */
@Entity
public class Netflix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "show_id")
    private String showId;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    @Column(name = "date_added")
    private String dateAdded;
    @Column(name = "release_year")
    private int releaseYear;
    private String rating;
    private String duration;
    @Column(name = "listed_in")
    private String listedIn;
    private String description;

    /**
     * Constructeur vide
     */
    public Netflix() {
    }

    public Netflix(String showId, int releaseYear) {
        this.showId = showId;
        this.releaseYear = releaseYear;
    }

    /**
     * Constructeur avec paramètre
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
     */
    public Netflix(int id, String showId, String type, String title,
                   String director, String cast, String country, String dateAdded,
                   int releaseYear, String rating, String duration, String listedIn,
                   String description) {
        this.id = id;
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }

    public Netflix(String showId, String type, String title, String director, String cast, String country,
                   String dateAdded, int releaseYear, String rating, String duration, String listedIn, String description) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }

    public Netflix(String type, String title, String director, String cast, String country, String dateAdded,
                   int releaseYear, String rating, String duration, String listedIn, String description) {
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listedIn;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", showId='" + showId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", country='" + country + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", listedIn='" + listedIn + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
