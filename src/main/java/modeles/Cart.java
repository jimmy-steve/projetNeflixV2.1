package modeles;

import java.util.List;

/**
 * Name : Cart
 * Permet d'avoir un panier personnalisé
 *
 * @author Francis lafontaine
 * @since 1/09/2022
 * @version V1
 */
public class Cart {
    private int quantite;
    List<Netflix> listFilms;

    public Cart(int quantite) {
        this.quantite = quantite;
    }

    public Cart(int quantite, List<Netflix> listFilms) {
        this.quantite = quantite;
        this.listFilms = listFilms;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Netflix> getListFilms() {
        return listFilms;
    }

    public void setListFilms(List<Netflix> listFilms) {
        this.listFilms = listFilms;
    }
}
