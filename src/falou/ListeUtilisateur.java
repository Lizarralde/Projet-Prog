package gestion_stock;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
*Cette classe définit la liste des utilisateurs de l'application.
*@author Falou Seck
*@version 1.0 (Décembre 2013)
**/

public class ListeUtilisateur implements Serializable{
	private ArrayList <Utilisateur> listeUtilisateur;


	public ListeUtilisateur(ArrayList<Utilisateur> liste){
		if (!liste.isEmpty())
			listeUtilisateur=liste;
		else
			listeUtilisateur= new ArrayList<Utilisateur>();	
	}

	public ListeUtilisateur(){
		this.listeUtilisateur = new ArrayList <Utilisateur>();
	}


	public int nombreUtilisateurs(){
		return this.listeUtilisateur.size();
	}

	public String toString(){
		String desc="Nombre d'utilisateurs: " + listeUtilisateur.size();
		for (Utilisateur user: listeUtilisateur)
			desc+=user.toString();

		return desc;
	}

	public void ajouter(Utilisateur user){

		this.listeUtilisateur.add(user);

	}


	public Utilisateur utilisateurIdentifie(String identifiant,String motDePasse){
		boolean trouve =false;
		Utilisateur us = null;
		Utilisateur cp;
		Iterator it = listeUtilisateur.iterator();
		while (it.hasNext() && !trouve){
			 cp= (Utilisateur) it.next();
			 if(cp.getIdUtilisateur().toLowerCase().equals(identifiant) && cp.getMotDePasse().equals(motDePasse)){
				trouve=true;
				us = cp;
			}
				
		}

		return us;
	}	

}