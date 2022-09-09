package utilitaire;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * GenerateurFacture
 * QUi permet de générer un nombre selon la date et l'heure actuel
 *
 * @author Francis Lafontaine
 * @since 08/septembre/2022
 * @version V2
 */
public class GenerateurNombreSequentiel {
    static int serialNo = 000;
    static LocalDate todaysDate = LocalDate.now();
    static LocalDateTime myDateObj = LocalDateTime.now();

    /**
     * Méthode qui générer un nombre avec la date leure et la seconde
     * et une suite de nombre croissante par la suite
     *
     * @return un nombre séquentiel basé sur la date et l'heure
     */
    public static String genererNombre() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String nombre = "";
        serialNo++;
        nombre = String.valueOf(todaysDate.getYear() + String.valueOf(todaysDate.getMonthValue())
                + String.valueOf(todaysDate.getDayOfMonth()) + ":" + formattedDate + serialNo);

        return nombre;
    }
}
