package gestion_stock;

/**
*La classe Telephone définit les articles de type Telephone du Stock.
*@author Falou Seck
*@version 1.0 (Décembre 2013)
*/

public class Telephone extends Article{

		

	public Telephone(String marque, String modele, String caracteristiques){
		super(marque,modele,caracteristiques);

	}
	
	public String toString(){
		return super.toString() + " Téléphone";
	}
	
}

