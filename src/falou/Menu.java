package gestion_stock;



import java.util.Scanner;
import java.io.Console;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
*Cette permet la gestion des menus de l'application.
*
*@author Falou Seck
*@version 1.0 (Décembre 2013)
**/

public class Menu{
	
	
	//La première fenêtre de connexion
	 public static void menuConnexion(ListeUtilisateur l, Stock st){
	 	char rep;
	 	Scanner sc = new Scanner(System.in);
	 	do{
	 	int choix= menuPrincipal();
	 	
	 	if(choix == 3){	
	 		System.out.println("\n\tVous allez Quitter l'application");
			System.exit(0);
		}	
	 	else{
	 		boolean identifie = false;
	 		do{
		 	Console console= System.console();
		 	
		 	System.out.println("\n");
		 	System.out.println("\t+============================+");
		 	System.out.println("\t+     MENU CONNEXION         +");
		 	System.out.println("\t+============================+");
		 	System.out.print  ("\t+ Identifiant :   ");
		 	String user = sc.nextLine().toLowerCase();
		 	System.out.print  ("\t+ Mot de passe:   ");
		 	String mdp = new String(console.readPassword());
		 	System.out.println("\t+============================+");
		 	
		 	Utilisateur connecte = l.utilisateurIdentifie(user,mdp);

		 	if (connecte !=null){
		 		String classe = connecte.getClass().getName();
		 		switch(choix){
		 			case 1:
		 					if(classe.equals("gestion_stock.Emprunteur")){
		 						Emprunteur emp = (Emprunteur) connecte;
		 						menuEmprunteur(emp,st,l);
		 						identifie = true;
		 					}
		 					else{
								System.out.println("Identifiant et/ou mot de passe incorrects");
							}
							break;
		 			case 2:
		 					if(classe.equals("gestion_stock.Gestionnaire")){
		 						Gestionnaire ges = (Gestionnaire) connecte;
		 						menuGestionnaire(ges,st,l);
		 						identifie = true;
		 					}
		 					else{
								System.out.println("Identifiant et/ou mot de passe incorrects");
							}
							break;
		 		}

		 	}else{
		 		System.out.println("Identifiant et/ou mot de passe incorrects");
		 	}
			
		 }while(!identifie);
		}
	System.out.print("Changer d'utilisateur [O/N]?");
	rep=sc.nextLine().charAt(0);
	}while(rep!='n' && rep!='N');
	}


//Permet de définir le type d'utilisateur connecté.
public static int menuPrincipal(){
	int choix=0;
	Scanner sc = new Scanner(System.in);

	System.out.println("\n\n\t _____________________________________________________________ ");
	System.out.println("\t|                                                             |");
	System.out.println("\t|                    MENU  PRINCIPAL                          |");
	System.out.println("\t|_____________________________________________________________|");
	System.out.println("\t|                                                             |");   
	System.out.println("\t|                     Vous êtes?                              |");
	System.out.println("\t|                                                             |");
	System.out.println("\t|               1 ---> Emprunteur                             |");
	System.out.println("\t|                                                             |");
	System.out.println("\t|               2 ---> Gestionnaire                           |");
	System.out.println("\t|                                                             |");
	System.out.println("\t|               3 ----> Quitter                               |");
	System.out.println("\t|_____________________________________________________________|");

	do{
		System.out.print("\n\tFaites votre choix: ");
			choix = sc.nextInt();	
		
	}while(choix<1 || choix>3);
	return choix;
}

//Menu d'un utilisateur de type emprunteur.
public static void menuEmprunteur(Emprunteur e,Stock st,ListeUtilisateur lus){
	ObjectOutputStream oos;
	int choix;
	char rep;
	do{
	Scanner sc = new Scanner(System.in);
	System.out.println("\t ________________________________________________________________ ");
	System.out.println("\t|                                                                |");
	System.out.println("\t|                        MENU EMPRUNTEUR                         |");
	System.out.println("\t|                                                                |");
	System.out.println("\t ____   Emprunteur connecté: " + e.getPrenom() + " " + e.getNom().toUpperCase() + " ____");
	System.out.println("\t|                                                                |");
	System.out.println("\t|             1--> Emprunter un nouvel appareil                  |");
	System.out.println("\t|                                                                |");
	System.out.println("\t|             2--> Modifier mon mot de passe                     |");
	System.out.println("\t|                                                                |");
	System.out.println("\t|             3--> Consulter ma fiche                            |");
	System.out.println("\t|                                                                |");
	System.out.println("\t|             4--> Quitter                                       |");
	System.out.println("\t|________________________________________________________________|\n");


	do{
		System.out.print("\n\tFaites votre choix:  ");
		choix = sc.nextInt();
	}while(choix<1 || choix>5);


	switch(choix){
	 	case 1: {
	 				sc.nextLine();
	 				if(st.articlesDisponibles().size()>0){
	 				System.out.println(st.articlesDisponibles());
		 			System.out.print("\n\tEntrer l'Identifiant de l'article: " );
		 			String id = sc.nextLine();
		 			Article ar = st.verifierIdentifiant(id);
		 			
		 			if(ar == null)
		 				System.out.println("\n\tAucun article trouvé.");
		 			else if (ar.getEtat().equals(Etat.Disponible)){
		 						st.emprunter(e,ar);
	 						
		 			}
		 			else
		 				System.out.println("\n\tCet article ne sera disponible que le " + ar.getDateRetour());
	 				}else
	 					System.out.println("Il n'y a aucun article disponible pour le moment.");
	 				break;
	 			}
	 	case 2: {
	 				Console console = System.console();
	 				sc.nextLine();
	 				System.out.print("\nSaisir votre mot de passe actuel: ");
	 				String actuelMDP = new String(console.readPassword());
	 				if(e.getMotDePasse().equals(actuelMDP)){
	 					System.out.print("\nSaisir votre nouveau mot de passe: ");
	 					String newMDP = new String(console.readPassword());
	 					System.out.print("\nConfirmer le nouveau mot de passe: ");
	 					String confirMDP = new String(console.readPassword());

	 					if(newMDP.equals(confirMDP)){
	 						e.setMotDePasse(newMDP);
	 						System.out.println("\nMot de passe correctement modifié.");
	 					}
	 					else
	 						System.out.println("\nErreur lors de la saisie du mot de passe");
	 				}
	 				else
	 					System.out.println("\nMot de passe incorrect.");				
	 				break;
	 			}
	 	case 3: {
	 				sc.nextLine();
	 				System.out.println(e + "\n\tMot de passe: " + e.getMotDePasse() + "\n");
	 				break;
	 			}
	 	case 4:{
	 			System.exit(0);
	 	 		break;
	 	 		}

 		}		
 			try{
			  	oos= new ObjectOutputStream(
			  			new BufferedOutputStream(
			  				new FileOutputStream(
			  					new File("./Sauvegarde/stock.stk"))));
			
			  	oos.writeObject(st);
			  	oos.close();
			 }catch(Exception ex){
			 	ex.printStackTrace();
			 }

			 try{
				oos= new ObjectOutputStream(
							new BufferedOutputStream(
				  				new FileOutputStream(
				  					new File("./Sauvegarde/utilisateur.usr"))));
				
				  	oos.writeObject(lus);
				  	oos.close();
				 }catch(Exception ex){
				 	ex.printStackTrace();
			 }


 			System.out.print("Retourner au menu précédent [O/N]?");
 			rep = sc.nextLine().charAt(0);
 		}while(rep!='n' && rep!='N');

}
 
//Menu d'un utilisateir de type gestionnaire.

public static void menuGestionnaire(Gestionnaire g, Stock st, ListeUtilisateur lus){

 int choix;
 char rep; 
 Scanner sc = new Scanner(System.in);
 ObjectOutputStream oos;
 do{
 System.out.println("\n\t ______________________________________________________________ ");
 System.out.println("\t|                                                              |");
 System.out.println("\t|                       MENU GESTIONNAIRE                      |");
 System.out.println("\t|                                                              |");
 System.out.println("\t    _____ Gestionnaire connecté: " + g.getPrenom() + " " + g.getNom().toUpperCase() + "   ______");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              1--> Ajouter un nouveau matériel                |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              2--> Ajouter un nouvel utilisateur              |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              3--> Etat du stock                              |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              4--> Voir la fiche d'un article                 |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              5--> Liste des appareils à réparer              |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              6--> Liste des appareils en réparation          |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              7--> Réparer les appareils défectueux           |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|              8--> Modifier mot de passe                      |"); 
 System.out.println("\t|                                                              |");
 System.out.println("\t|              9--> Liste de tous les utilisateurs             |");
 System.out.println("\t|                                                              |");
 System.out.println("\t|             10--> Quitter                                    |");
 System.out.println("\t|______________________________________________________________|");


 do{
 	
 	System.out.print("\n\tFaites votre choix: ");
 	choix=sc.nextInt();
 
 }while(choix<0 || choix>10);

 switch(choix){
 	case 1: { 
 		       do{
 		       
 				 Article article = null;
 				 System.out.println("\n\t ______________________________________________________________ ");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|                       MENU Article                           |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|__Gestionnaire connexté: " + g.getPrenom() + " " + g.getNom().toUpperCase() + "   ________________|");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|                 Que voulez - vous ajouter?                   |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              1--> Téléphone                                  |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              2--> Tablette                                   |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              3--> Caméra                                     |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              4--> Casque                                     |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              5--> Quitter                                    |");
				 System.out.println("\t ______________________________________________________________ ");
				 int ch2;
				do {
					System.out.print("\n\tFaites votre choix: ");
					ch2 = sc.nextInt();
				}while(ch2<0 || ch2>5);
				sc.nextLine();
				if(ch2<5){
					System.out.print("\n\tMarque de l'article          : ");
					String marque=sc.nextLine();
					System.out.print("\n\tModèle de l'article          : ");
					String modele = sc.nextLine();
					System.out.print("\n\tCaractéristiques de l'article: ");
					String caracteristiques = sc.nextLine();
					switch (ch2) {
						case 1:{
							
							article = new Telephone(marque,modele,caracteristiques);
							System.out.println("\n\tVous venez ajouter un téléphone au stock.");
							break;
						}
						case 2:{
							System.out.println("\n\tVous venez ajouter une tablette au stock.");
							article = new Tablette(marque,modele,caracteristiques);
							break;
						}
						case 3:{
							System.out.println("\n\tVous venez ajouter une caméra au stock.");
							article = new Camera(marque,modele,caracteristiques);
							break;
						}
						case 4:{
							System.out.println("\n\tVous venez ajouter un casque au stock.");
							article = new Casque(marque,modele,caracteristiques);
							break;
						}

					} 
					st.ajouter(article);
					try{
						oos=new ObjectOutputStream(
								new BufferedOutputStream(
									new FileOutputStream(
										new File("./Sauvegarde/stock.stk"))));
						oos.writeObject(st);
						oos.close();

					}catch(Exception e){
						e.printStackTrace();
					}	
					System.out.print("Voulez-vous continuer [O/N]");
					 rep = sc.nextLine().charAt(0);
					 

		
				}else{
					System.exit(0);		
					break;
				}
				}while(rep!='n' && rep!='N');
						break; 
				}
							 
 	case 2: {	
 				 Utilisateur user=null;
 				 do{
 				 System.out.println("\n\t ______________________________________________________________ ");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|                       MENU Ajout utilisateur                 |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|__Gestionnaire connexté: " + g.getPrenom() + " " + g.getNom().toUpperCase() + "   ________________|");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|                 Vous voulez  ajouter?                        |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              1--> Un gestionnaire                            |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              2--> Un emprunteur                              |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|              3--> Quitter                                    |");
				 System.out.println("\t|                                                              |");
				 System.out.println("\t|______________________________________________________________|");
 				
				 do{
				 	System.out.print("\n\tFaites votre choix: ");
				 	choix = sc.nextInt();
				 }while(choix<0 || choix>3);
				 if(choix<3){	 
				 	sc.nextLine();
		 			System.out.print("Nom de l'utilisateur   : ");
		 			String nom = sc.nextLine();
		 			System.out.print("Prénom de l'utilisateur: ");
		 			String prenom = sc.nextLine();
		 			switch (choix) {
		 				case 1:{
		 					user = new Gestionnaire(nom,prenom);
		 					break;
		 				}	
		 				case 2:  {
		 					user = new Emprunteur(nom,prenom);
		 					break;
		 				}


		 			}
		 			System.out.println("\nVotre mot de passe par défaut est: " + user.getMotDePasse() + ". Pensez à le modifier lors de votre prochaine connexion");
		 			lus.ajouter(user);
		 			try{
		 					oos = new ObjectOutputStream(
		 							new BufferedOutputStream(
		 								new FileOutputStream(
		 									new File("./Sauvegarde/utilisateur.usr"))));

		 					oos.writeObject(lus);
		 					oos.close();
		 				}catch(Exception e){
		 					e.printStackTrace();
		 				}



	 			}else
	 				System.exit(0);
	 			
	 				System.out.print("Voulez-vous ajouter un nouvel utilisateur [O/N]?  ");
	 				rep=sc.nextLine().charAt(0);
	 			}while(rep!='n' && rep!='N');
	 			break;


 			}
 	case 3: 
 			{	
 				sc.nextLine();
 				System.out.println(st);
 				break;
 			}
 	case 4: {
 			sc.nextLine();
 			System.out.print("Saisir l'identifiant de l'article: ");
 			String idArticle = sc.nextLine();
 			Article articleAVerifier =  st.verifierIdentifiant(idArticle);
 			if(articleAVerifier==null){
 				System.out.println("Aucun article touvé");
 			}else{
 				System.out.println(articleAVerifier);
 			}
 			break;
 			}
 	case 5: {
 				sc.nextLine();
 				System.out.println("Nombre d'articles à réparer: " + st.articlesAReparer().size());
 				System.out.println(st.articlesAReparer());
 				break;
 			}
 	case 6: {	
 				sc.nextLine();
 				System.out.println("Nombre d'articles en réparation: " + st.articlesEnReparation().size());
 				System.out.println(st.articlesEnReparation());
 				break;
 			}
 	case 7: {	
 				sc.nextLine();
 				st.reparerArticles();
 				break;
 			}
 	case 8: {
 				Console console = System.console();
	 				sc.nextLine();
	 				System.out.print("\nSaisir votre mot de passe actuel: ");
	 				String actuelMDP = new String(console.readPassword());
	 				if(g.getMotDePasse().equals(actuelMDP)){
	 					System.out.print("\nSaisir votre nouveau mot de passe: ");
	 					String newMDP = new String(console.readPassword());
	 					System.out.print("\nConfirmer le nouveau mot de passe: ");
	 					String confirMDP = new String(console.readPassword());

	 					if(newMDP.equals(confirMDP)){
	 						g.setMotDePasse(newMDP);
	 						System.out.println("\nMot de passe correctement modifié.");
	 					}
	 					else
	 						System.out.println("\nErreur lors de la saisie du mot de passe");
	 				}
	 				else
	 					System.out.println("\nMot de passe incorrect.");

	 				try{
						oos= new ObjectOutputStream(
									new BufferedOutputStream(
						  				new FileOutputStream(
						  					new File("./Sauvegarde/utilisateur.usr"))));
						
						  	oos.writeObject(lus);
						  	oos.close();
						 }catch(Exception ex){
						 	ex.printStackTrace();
					 }
	 				break;
 			}
 	case 9: 
 			{	sc.nextLine();
 				System.out.println(lus); 
 				break;
 			}
 	case 10: {	
 			System.exit(0);
 				break;}

 	 }
 	 try{
						oos= new ObjectOutputStream(
									new BufferedOutputStream(
						  				new FileOutputStream(
						  					new File("./Sauvegarde/utilisateur.usr"))));
						
						  	oos.writeObject(lus);
						  	oos.close();
						 }catch(Exception ex){
						 	ex.printStackTrace();
					 }


		System.out.print("\n\tRetourner au menu précédent [O/N]? ");
		rep = sc.nextLine().charAt(0);

	}while(rep!='n' && rep!='N');
 }


}
