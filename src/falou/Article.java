
package gestion_stock;



import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;

/**
*La classe Article est la classe m&egrave;re de toutes les classes qui seront
*utilis&eacute;es. On y d&eacute;finit les diff&eacute;rentes qu'ont en communt les mat&eacute;riels composant
*le stock
*@author Falou Seck
*@version 1.0 (Novembre 2013)
**/

public class Article implements Serializable{

	private static Calendar calendrier = Calendar.getInstance();
	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
	private static int nombreArticles;

	private Etat etat;
	//L'intégrité est une valeur inférieure ou égale à 100 montrant la qualité de l'article en question.
	private int integrite;
	private int nombreDEmprunts;
	private String idArticle;
	private String caracteristiques;
	private String marque;
	private String modele;
	private String dateEmprunt;
	private String dateRetour;
	

	public Article(String marque, String modele, String caracteristiques){
		this.marque=marque.toUpperCase();
		this.caracteristiques=caracteristiques;
		this.integrite = 100;
		this.modele = modele.toUpperCase();
		this.etat=Etat.Disponible;
		this.nombreDEmprunts=0;
		this.idArticle = "AR";
		//L'identifiant de l'article contient les 3 premières lettres de la marque
		//On vérifie que la longueur de la marque est bien supérieure à 3
		if(marque.length()>3)
			this.idArticle += this.marque.substring(0,3);
		else
			this.idArticle += this.marque;

		this.idArticle+= "01" + nombreArticles;
		nombreArticles++;	
	}
	/**
	*Cette m&eacute;thode renvoie une description compl&eacute;te d'un article, indiquant l'&eacute;tat de toutes
	*les propri&eacute;t&eacute;s d'un article.
	*@return retourne un texte.
	**/
	public String toString(){
		 String desc=("\n\n\t******* Article *******" + 
									"\n\tIdentifiant        : " + this.idArticle + 
									"\n\tMarque             : " + this.marque +
									"\n\tModèle             : " + this.modele +
									"\n\tCaractéristiques   : " + this.caracteristiques +
									"\n\tIntégrité          : " + this.integrite + " %" +
									"\n\tEtat               : " + this.etat);

				if(this.getEtat().equals(Etat.Emprunte)){
					 desc+=("\n\tDate d'emprunt     : " + this.getDateEmprunt() +
					        "\n\tDate de retour     : " + this.getDateRetour());	
				}

				desc+="\n\t>>>>>>>>>>>>>>>>Type d'article: ";
				return desc;
	}

	/**
	*Cette m&eacute;thode met &egrave; jour l'&eacute;tat d'un article du stock
	*@param state indique le nouvel &eacute;tat de l'article
	*/
	public void setEtat(Etat state){
		this.etat = state;
	}

	/**
	*Cette m&eacute;thode renvoie la valeur de l'intégrité de l'article;
	*@return retourne un entier.
	*
	**/
	public int getIntegrite(){
		return this.integrite;
	}
	/**
	*Cette m&eacute; renvoie la marque de l'article en question.
	*@return retourne une chaine de caract&egrave;s
	**/
	public String getMarque(){
		return this.marque;
	}

	/**
	*Ctte
	*Cette m&eacute; renvoie les caractéristiques de l'article en question.
	*@return retourne une chaine de caract&egrave;s
	**/
	public String getCaracteristiques(){
		return this.caracteristiques;
	}

	/**
	*Ctte
	*Cette m&eacute; renvoie l'identifiant de l'article en question.
	*@return retourne une chaine de caract&egrave;s
	**/
	public String getIdArticle(){
		return this.idArticle;
	}

	/**
	*Ctte
	*Cette m&eacute; renvoie l'état de l'article en question. C'est-à-dire, Emprunté, Disponible, EnRéparation ou Inutilisable.
	*@return Elle renvoie un enum;
	**/
	public Etat getEtat(){
		return this.etat;
	}
	/**
	*Ctte
	*Cette m&eacute; renvoie le modèle de l'article en question.
	*@return retourne une chaine de caract&egrave;s
	**/
	public String getModele(){
			return this.modele;
	}


	/**
	*Ctte
	*Cette m&eacute; renvoie les caractéristiques de l'article en question.
	**/
	public void setIntegrite(int integr){
		
		if(integr>100)
			this.integrite=this.integrite;
		else
			this.integrite=integr;

	}

	/**
	*Ctte
	*Cette m&eacute; détermine la date d'emprunt de l'article.
	**/
	public void setDateEmprunt(){
			
			this.dateEmprunt = formatDate.format(calendrier.getTime());
			setDateRetour();
	}

	/**
	*Ctte
	*Cette m&eacute; détermine la date de retour de l'article en question. 
	**/
	public void setDateRetour(){
			
		calendrier.add(Calendar.DATE,4);
		this.dateRetour=formatDate.format(calendrier.getTime());
	}

	/**
	*Ctte
	*Cette m&eacute; renvoie la date d'emprunt de l'article en question.
	*@return Elle retourne une chaine de caract&egrave;s
	**/
	public String getDateEmprunt(){

		return this.dateEmprunt;
	}

	/**
	*Ctte
	*Cette m&eacute; renvoie la date de retour d'emprunt de l'article en question.
	*@return Elle retourne une chaine de caract&egrave;s
	**/
	public String getDateRetour(){
		return this.dateRetour;
	}
}