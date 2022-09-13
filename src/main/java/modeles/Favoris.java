package modeles;

import javax.persistence.*;
import java.util.List;

/**
 * Name : Favoris
 * Permet d'avoir une liste de favoris sauvegarder dans la base de donnée
 *
 * @author Francis lafontaine
 * @since 9/09/2022
 * @version V2
 */
@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favoris")
    private int idFav;
    @Column(name = "id_abonnement")
    private String idAbonnement;
    @Column(name = "id_user")
    private long idUser;
    @Column(name = "id_netflix")
    private int idNetflix;
    static private int quantite;

    public Favoris() {
    }

    public Favoris(String idAbonnement, long idUser, int idNetflix, int quantite) {
        this.idAbonnement = idAbonnement;
        this.idUser = idUser;
        this.idNetflix = idNetflix;
        Favoris.quantite = quantite;
    }

    public Favoris(String idAbonnement, long idUser) {
        this.idAbonnement = idAbonnement;
        this.idUser = idUser;
    }

    public Favoris(String idAbonnement, long idUser, int idNetflix) {
        this.idAbonnement = idAbonnement;
        this.idUser = idUser;
        this.idNetflix = idNetflix;
    }

    public int getIdFav() {
        return idFav;
    }

    public void setIdFav(int idFav) {
        this.idFav = idFav;
    }

    public String getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(String idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public int getIdNetflix() {
        return idNetflix;
    }

    public void setIdNetflix(int idNetflix) {
        this.idNetflix = idNetflix;
    }

    //variable static messemble que hibernate n'y touche pas
    static List<Netflix> listFilms;

    public Favoris(int quantite, List<Netflix> listFilms) {
        Favoris.quantite = quantite;
        Favoris.listFilms = listFilms;
    }

    public int getQuantite() {
        return Favoris.quantite;
    }

    public void setQuantite(int quantite) {
        Favoris.quantite = quantite;
    }

    public List<Netflix> getListFilms() {
        return listFilms;
    }

    public void setListFilms(List<Netflix> listFilms) {
        Favoris.listFilms = listFilms;
    }

    @Override
    public String toString() {
        return "Favoris{" +
                "idFav=" + idFav +
                ", idAbonnement='" + idAbonnement + '\'' +
                ", idUser=" + idUser +
                ", idNetflix=" + idNetflix +
                ", quantite=" + quantite +
                '}';
    }
}
