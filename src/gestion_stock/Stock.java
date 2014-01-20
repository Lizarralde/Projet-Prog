package gestion_stock;

import java.util.*;
import java.io.Serializable;
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Cette classe regroupe des articles de différents types.
 * 
 * @author Falou Seck
 * @version 1.0.1 (Décembre 2013)
 */

public class Stock implements Serializable {
    private ArrayList<Article> listeDArticles;

    public Stock() {
        this.listeDArticles = new ArrayList<Article>();
    }

    public ArrayList<Article> articlesDisponibles() {
        ArrayList<Article> liste = new ArrayList<Article>();
        for (Article a : listeDArticles)
            if (a.getEtat().equals(Etat.Disponible))
                liste.add(a);
        return liste;
    }

    public ArrayList<Article> articlesEnReparation() {
        ArrayList<Article> liste = new ArrayList<Article>();
        for (Article a : listeDArticles)
            if (a.getEtat().equals(Etat.EnReparation))
                liste.add(a);
        return liste;
    }

    public ArrayList<Article> articlesEmpruntes() {
        ArrayList<Article> liste = new ArrayList<Article>();
        for (Article a : listeDArticles)
            if (a.getEtat().equals(Etat.Emprunte))
                liste.add(a);
        return liste;

    }

    public ArrayList<Article> articlesAReparer() {
        ArrayList<Article> liste = new ArrayList<Article>();
        for (Article a : listeDArticles)
            if (a.getEtat().equals(Etat.Inutilisable))
                liste.add(a);
        return liste;
    }

    /**
     * On considère qu'à chaque emprunt, l'article perd 2 points
     * d'intégrité.
     * 
     */
    public void emprunter(Emprunteur e, Article a) {
        if (a.getEtat().equals(Etat.Disponible)) {
            a.setEtat(Etat.Emprunte);
            e.setArticlesEmpruntes(a);
            a.setIntegrite(a.getIntegrite() - 2);
            a.setDateEmprunt();
            System.out.println("Emprunt réussi.");
        }
    }

    /**
     * La m&eacute; ajoute un article au stock; équivalent à l'achat d'un
     * article.
     * 
     * @param article
     *            indique l'article à ajouter au stock;
     */
    public void ajouter(Article article) {
        this.listeDArticles.add(article);
    }

    public String marquesPresentes() {
        return "";
    }

    public void envoyerEnReparation(Article e) {
        if (e.getEtat().equals(Etat.Inutilisable))
            e.setEtat(Etat.EnReparation);
    }

    public String toString() {

        String desc = ("\n\nNombre total d'articles en stock: "
                + this.listeDArticles.size() + "\n"
                + "Nombre d'articles empruntés     : "
                + this.articlesEmpruntes().size() + "\n"
                + "Nombre d'articles disponibles   : "
                + this.articlesDisponibles().size() + "\n"
                + "Nombre d'articles à réparer     : "
                + this.articlesAReparer().size() + "\n"
                + "Nombre d'articles en réparation : "
                + this.articlesEnReparation().size() + "\n");

        desc += "\n\tDescription de l'intégralité du stock : \n";
        for (Article a : listeDArticles)
            desc += a.toString();

        desc += ("\n_______________________________________________________"
                + "\n\n\tArticles disponibles  : \n");
        for (Article a : articlesDisponibles())
            desc += a.toString();

        desc += ("\n_______________________________________________________"
                + "\n\n\tArticles empruntés     : \n");
        for (Article a : articlesEmpruntes())
            desc += a.toString();

        desc += ("\n_______________________________________________________"
                + "\n\n\tArticles à réparer     : \n");
        for (Article a : articlesAReparer())
            desc += a.toString();

        desc += ("\n_______________________________________________________"
                + "\n\n\tArticles en réparation : \n");
        for (Article a : articlesAReparer())
            desc += a.toString();
        return desc;
    }

    public void miseAJourStock() {
        for (Article a : listeDArticles) {
            if (a.getIntegrite() < 50)
                a.setEtat(Etat.Inutilisable);
        }

    }

    public void reparerArticles() {

        for (Article a : this.articlesEnReparation()) {
            a.setIntegrite(a.getIntegrite() + 50);
            a.setEtat(Etat.Disponible);
        }
        System.out.println("\nTous les articles ont été réparés.");
    }

    public Article verifierIdentifiant(String identifiant) {
        Article ar = null;
        boolean trouve = false;
        Iterator it = listeDArticles.iterator();
        while (it.hasNext() && !trouve) {
            Article cpAr = (Article) it.next();
            if (cpAr.getIdArticle().toLowerCase()
                    .equals(identifiant.toLowerCase())) {
                trouve = true;
                ar = cpAr;
            }
        }
        return ar;

    }

}
