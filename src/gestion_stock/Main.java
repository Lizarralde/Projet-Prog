package gestion_stock;

import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

/**
 * Cette classe simule le gestionnaire du stock.
 * 
 * @author Falou Seck
 * @version 1.1 (Décembre 2013)
 **/
public class Main {

    public static void main(String[] args) {

        String fichierStock = "./Sauvegarde/stock.stk";
        String fichierUtilisateur = "./Sauvegarde/utilisateur.usr";

        ObjectOutputStream oos, oos2;
        ObjectInputStream ois, ois2;
        Stock st2 = new Stock();
        ListeUtilisateur lus = new ListeUtilisateur();

        try {

            ois = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(new File(fichierStock))));

            st2 = (Stock) ois.readObject();

            try {
                ois2 = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream(new File(fichierUtilisateur))));
                lus = (ListeUtilisateur) ois2.readObject();
                Menu.menuConnexion(lus, st2);
                ois2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
