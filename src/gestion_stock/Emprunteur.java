package gestion_stock;

import java.util.ArrayList;

/**
 * La classe Emprunteur définit les abonnés.
 * 
 * @author Falou Seck
 * @version 1.0 (Décembre 2013)
 */

public class Emprunteur extends Utilisateur {

    private static int nombreEmprunteurs;
    private ArrayList<Article> articlesEmpruntes;

    public Emprunteur(String nom, String prenom) {
        super(nom, prenom);
        this.articlesEmpruntes = new ArrayList<Article>();
        nombreEmprunteurs++;
    }

    public int nombreArticlesEmpruntes() {
        return this.articlesEmpruntes.size();
    }

    public void setArticlesEmpruntes(Article a) {
        this.articlesEmpruntes.add(a);
    }

    public String toString() {
        return (super.toString() + " Emprunteur" + "\n\tArticles empruntés ("
                + articlesEmpruntes.size() + ") : " + articlesEmpruntes + "\n");

    }
}
