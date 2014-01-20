package gestion_stock;


import java.io.Serializable;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
*La classe Utilisateur est la classe mère des différents utilisateurs de l'application.
*On retrouve dans celle-ci plusieurs méthodes qui permettent d'utiliser les différentes propriétés des utilisateurs.
*@author Falou Seck
*@version 1.0 (Décembre 2013)
*/

public class Utilisateur implements Serializable{
		
	private static Calendar calendrier = Calendar.getInstance();
	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

	private static int nombreUtilisateurs;
	private String idUtilisateur;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String dateInscription;


	public Utilisateur(String nom, String prenom){
		this.nom=nom.toUpperCase();
		this.prenom=prenom;
		this.motDePasse=(this.nom + "." + this.prenom).toLowerCase();
		//On vérifie que les longueurs du nom et prénom sont supérieures à 2
		if(this.nom.length()>2)
			this.idUtilisateur = this.nom.substring(0,2);
		else
			this.idUtilisateur = this.nom;
		if(this.prenom.length()>2)
			this.idUtilisateur += this.prenom.substring(0,2);
		else
			this.idUtilisateur += this.prenom;
		this.idUtilisateur += "11" + nombreUtilisateurs;
		this.dateInscription = formatDate.format(calendrier.getTime());
		nombreUtilisateurs++;
	}

	public String getIdUtilisateur(){
		return this.idUtilisateur;
	}

	public String getMotDePasse(){
		return this.motDePasse;
	}

	public String getNom(){
		return this.nom;
	}

	public String getPrenom(){
		return this.prenom;
	}

	public String getInscription(){
		return this.dateInscription;
	}
	

	public void setMotDePasse(String motDePasse){
		this.motDePasse=motDePasse;
	}
	public String toString(){
		return ("\n\t>>>>>>>>>>>>>>>>>> Utilisateur" +
				"\n\tIdentifiant  : " + this.idUtilisateur +
				"\n\tNom          : " + this.nom.toUpperCase() +
				"\n\tPrénom       : " + this.prenom + 
				"\n\tInscription  : " + this.dateInscription +
				"\n\t>>>>>>>>>>>>>>>>>> Catégorie: ");
	}
}

