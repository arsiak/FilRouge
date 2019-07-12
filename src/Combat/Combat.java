package Combat;
import java.util.Random;
import java.util.Scanner;

import Cartes.Carte;
import Monstres.Assassin;
import Monstres.Chamane;
import Monstres.EquipeMonstre;
import Monstres.FactoryMonstre;
import Monstres.Necromancien;
import Objets.Objet;
import Objets.ObjetQuete;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Monstres.Monstre;
import Personnages.Paladin;
import Personnages.Personnage;

public class Combat {
	
	Scanner sc;
	int tour=0, equipePointVieGlobal=0, equipeMonstrePointVieGlobal=0;
	char option;
	boolean gameOver = false, fuite = false;
	Equipe equipe;
	EquipeMonstre equipeMonstre;
	Carte carte;
	//Création de personnages et monstres doublure pour éviter réinitiliser les paramètres en fin de combat
	Personnage[] combattants;
	Monstre[] monstres;
	
	public Combat(Scanner sc, Equipe equipe) throws Exception {
		
		this.equipe=equipe;
		this.sc=sc;
		this.initMonstre();
		this.initialisation(equipe);
		this.deroulementCombat();

	}
	
	public Combat(Equipe equipe, Carte carte) throws Exception {
		
		this.equipe=equipe;
		this.carte=carte;
		sc=new Scanner(System.in);
		this.initBoss(carte);
		this.initialisation(equipe);
		this.deroulementCombat();

	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void initialisation(Equipe equipe) {
		
		combattants = new Personnage[equipe.getListePersonnage().size()];
			for (int i=0; i<equipe.getListePersonnage().size(); i++) {
				combattants[i] = equipe.getListePersonnage().get(i);
			}
			
		monstres = new Monstre[equipeMonstre.getListeMonstre().size()];
			for (int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				monstres[i] = equipeMonstre.getListeMonstre().get(i);
			}

	}
	
	public void affichageCombattants() {
		
		// écriture des paramètres pour chaque combattants et monstres
		for (int i=0; i<3; i++) {
			
			// initialisation 
			int bordGauche = 75, petitBordGauche = 3, rognePresentation = 0, rogneCri = 0;
			String presentationC = "", presentationM = "", criC = "", criM = "";
			char lettreC = ' ', lettreM = ' ';
			
			if (combattants.length>i && combattants[i].getEstVivant()) { 
				rognePresentation = combattants[i].toString().length();
				rogneCri = combattants[i].getCriGuerre().length();
				presentationC = combattants[i].toString();
				lettreC = combattants[i].getLettre();
				criC = combattants[i].getCriGuerre();
			}
	
			if (monstres.length>i && monstres[i].getEstVivant()) { 
				presentationM = monstres[i].toString();
				lettreM = monstres[i].getLettre();
				criM = monstres[i].getCriGuerre();
			}
			
			// première ligne
			for (int j=0; j<bordGauche; j++) { System.out.print(" "); }
			System.out.println("|                  |");
							
			// deuxième ligne
			for (int j=0; j<bordGauche-rognePresentation-petitBordGauche; j++) { System.out.print(" "); } 
			System.out.println(presentationC+ "   |    " +lettreC+ "        " +lettreM+ "    |   " +presentationM);
						
			// troisième ligne
			for (int j=0; j<bordGauche-rogneCri-petitBordGauche; j++) { System.out.print(" "); } 
			System.out.println(criC+ "   |                  |      " +criM);
						
			// quatrième ligne
			for (int j=0; j<bordGauche; j++) { System.out.print(" "); }
			System.out.println("|                  |");
		}
		
		
		
			
			
	}
	
	public void initMonstre() throws Exception {
		
		equipeMonstre = new EquipeMonstre();
		int random = (int)(Math.random()*3+1);
		for (int i=0; i<random; i++) {
			FactoryMonstre monstre = new FactoryMonstre();
			equipeMonstre.getListeMonstre().add(monstre.getTypeMonstre());
		}
	
	}
	
	public void initBoss(Carte carte) throws Exception {
		
		equipeMonstre = new EquipeMonstre();
		equipeMonstre.getListeMonstre().add(carte.getCarte_boss().get(carte.getCarte_nom()));
	
	}
	
	public void attente() {

		for (int j=0; j<100;j++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("-");
		}
		System.out.println();

	}
	
	public void deroulementCombat() {
		
		System.out.println("Vous êtes attaqués !!!");
		
		//Calcul des points de vie global pour les monstres et l'équipe
		for (int i=0; i<monstres.length; i++) {
				equipeMonstrePointVieGlobal += monstres[i].getPointVie();
		}
		
		for (int i=0; i<combattants.length; i++) {
				equipePointVieGlobal += combattants[i].getPointVie();
		}

		//Affectation des différents points des armes et armures pour les mosntres
		for(int i=0; i<monstres.length; i++) {			
			for (int j=0; j<monstres[i].nombreObjetDansSac(); j++) {
				if (monstres[i].getSac()[j] != null) {
					if (monstres[i].getSac()[j].getType().equals("Arme") || monstres[i].getSac()[j].getType().equals("Armure"))
						monstres[i].getSac()[j].utiliser(monstres[i]);
				}
			}
		}
		
		//Boucle de combat
		while((equipePointVieGlobal>0) && (equipeMonstrePointVieGlobal>0) && fuite == false) {
			
			this.attente();
			tour++;
			System.out.println("Tour "+tour+ "\n");
			
			//Affichage des armes et armures utilisé et des possessions du sac pour les personnages
			for(int i=0; i<combattants.length; i++) {
				for (int j=0; j<combattants[i].nombreObjetDansSac(); j++) {
					if (combattants[i].getSac()[j] != null && combattants[i].getEstVivant()) {
						if (combattants[i].getSac()[j].getType().equals("Arme") || combattants[i].getSac()[j].getType().equals("Armure")) {
							System.out.println(combattants[i].getNom()+" utilise "+combattants[i].getSac()[j].getNom());
						}
						else {
							System.out.println(combattants[i].getNom()+" possède "+combattants[i].getSac()[j].getNom());
						}
					}
					
				}
			}
			
			//Affichage des armes et armures utilisé et des possessions du sac pour les monstres
			for(int i=0; i<monstres.length; i++) {
				for (int j=0; j<monstres[i].nombreObjetDansSac(); j++) {
					if (monstres[i].getSac()[j] != null && monstres[i].getEstVivant()) {
						if (monstres[i].getSac()[j].getType().equals("Arme") || monstres[i].getSac()[j].getType().equals("Armure")) {
							System.out.println(monstres[i].getNom()+" utilise "+monstres[i].getSac()[j].getNom());
						}
						else {
							System.out.println(monstres[i].getNom()+" possède "+monstres[i].getSac()[j].getNom());
						}
					}
				}
			}
			
			//Combat
			for(int i=0; i<combattants.length; i++) {	
				
				this.affichageCombattants(); 
				
				System.out.println(combattants[i].getNom()+ " attend vos ordre");
				//Choix : attaquer, parer, objet, fuir
				System.out.println("Saisissez A pour attaquer, P pour parer, O pour objet ou F pour tenter de fuir");
				if(combattants[i] instanceof Paladin) {
					System.out.println("!! Parer fait gagner un point de rage et de mana !!");
				}
				if(combattants[i] instanceof Guerrier) {
					System.out.println("!! Parer fait gagner 1 point de rage !!");
				}
				if(combattants[i] instanceof Mage) {
					System.out.println("!! Parer fait gagner 1 point de mana !!");
				}

				option=sc.next().charAt(0);
				//Option Attaquer choisi
				if(option=='A' || option=='a') {
					String cible="";
					boolean verifCible=false;
					while(verifCible==false) {
						//Scanner sc=new Scanner(System.in);
						System.out.println("Saisissez le nom de la cible");
						cible=sc.next();
						for(int j=0; j<monstres.length; j++) {
							if(cible.equals(monstres[j].getNom())) {
								verifCible=true;
								System.out.println(combattants[i].getNom()+" vs "+monstres[j].getNom());
								System.out.println();
								if(combattants[i] instanceof Guerrier) {
									((Guerrier)combattants[i]).attaquer(monstres[j]);
								}
								else if(combattants[i] instanceof Mage) {
									((Mage)combattants[i]).attaquer(monstres[j]);
								}
								else if(combattants[i] instanceof Paladin) {
									((Paladin)combattants[i]).attaquer(monstres[j]);
								}
								if(monstres[j].getPointVie()<=0) {
									System.out.println(monstres[j].getNom()+" a été neutralisé");
									monstres[j].setEstVivant(false);
								}
							}
						}
					}
					
				}
				//Option Parer choisi
				else if (option=='P' || option=='p'){
					
					combattants[i].parer();	
					
				}
				//Option Objet choisi
				else if (option=='O' || option=='o'){
					
					String objet;
					int nombreConsommable = 0;
					boolean consommablePresent = false;
					
					for (int j=0; j<combattants[i].nombreObjetDansSac(); j++) {
						if (combattants[i].getSac()[j].getType().equals("Consommable")) {
							consommablePresent = true;
						}
					}
					if (consommablePresent == false) {
						System.out.println(combattants[i].getNom()+ " ne possède aucun objet consommable");
					}
					else {
						System.out.println("Liste des objets consommables de " +combattants[i].getNom()+ " : ");
						for (int j=0; j<combattants[i].nombreObjetDansSac(); j++) {
							if (combattants[i].getSac()[j].getType().equals("Consommable")) {
								System.out.println(combattants[i].getSac()[j].getNom());
								nombreConsommable++;
							}
						}
						System.out.println("Saisissez le nom de l'objet que vous voulez utiliser : ");
						Scanner scObjet=new Scanner(System.in);
						objet = scObjet.nextLine();
						
						//System.out.println(objet);
						for (int j=0; j<3; j++) {
							
							try {
								if (combattants[i].getSac()[j].getNom().equals(objet)) {
									combattants[i].getSac()[j].utiliser(combattants[i]);
									System.out.println(combattants[i].getNom()+ "a utilisé " +combattants[i].getSac()[j].getNom());
									combattants[i].retirerEquipement(combattants[i].getSac()[j]);
									equipe.getListePersonnage().get(i).retirerEquipement(combattants[i].getSac()[j]);
								}
							}
							catch(NullPointerException e) {}
						}
					}
				}
				//Option Fuite choisi
				else if (option=='F' || option=='f'){
					System.out.println("Vous tentez de fuir (La réussite dépend de votre vitesse)");
					this.attente();
					fuite = combattants[i].fuir();
					if (fuite == true) {
						System.out.println("Vous avez réussi à fuir");
						i = combattants.length;
					}
					else {
						System.out.println("Votre tentative de fuite a échouée");
					}
				}
				else {
					System.out.println("Le joueur est pétrifié de peur (mauvaise saisie de touche)");
				}
			}		
			//Attaque des monstres
			if (fuite == false) {
				System.out.println("Les monstres s'apprêtent à vous attaquer");
				this.attente();
				
				for(int i=0; i<monstres.length; i++) {
					
					if (monstres[i].getEstVivant()) {
						
						int choixCible=(int)(Math.random()*(combattants.length-1));
									
							monstres[i].attaquer(combattants[choixCible]);
							if(combattants[choixCible].getPointVie()<=0) {
								System.out.println(combattants[choixCible].getNom()+" est KO");
								combattants[choixCible].setEstVivant(false);
							}
					}
				}
			}
			
			//Calcul de nouveau des points de vie global pour les monstres et l'équipe
			equipeMonstrePointVieGlobal=0; 
			equipePointVieGlobal=0;
			for (int i=0; i<monstres.length; i++) {
					equipeMonstrePointVieGlobal += monstres[i].getPointVie();
			}
			
			for (int i=0; i<combattants.length; i++) {
					equipePointVieGlobal += combattants[i].getPointVie();
			}
			
			//Reset des parade
			for (int i=0; i<monstres.length; i++) {
				monstres[i].setParade(false);
			}
			
			for (int i=0; i<combattants.length; i++) {
				combattants[i].setParade(false);
			}
			
		}
		//fin combat
		
		//Résultat
		System.out.println();
		if (equipe.getPointVieGlobal()>0) {
			System.out.println(equipe.getNom()+" est vainqueur !");
			if (monstres[0].getLettre() == 'B') {
				equipe.getListePersonnage().get(0).ajouterEquipement(new ObjetQuete("La tête du boss du " +carte.getCarte_nom()));
				System.out.println("Vous avez récupéré la tête du boss du " +carte.getCarte_nom());
			}
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				if(equipe.getListePersonnage().get(i).getPointVie()>0 && fuite == false) {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+10);
					System.out.println(equipe.getListePersonnage().get(i).getNom()+ " gagne 10 XP." );
				}
				else {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+5); 
					System.out.println(equipe.getListePersonnage().get(i).getNom()+ " gagne 5 XP." );
				}
				if (equipe.getListePersonnage().get(i).getXP()>=100) {
					equipe.getListePersonnage().get(i).levelUp();
					System.out.println(equipe.getListePersonnage().get(i).getNom()+ " est passé au niveau " +equipe.getListePersonnage().get(i).getLevel() 
									   +" (+2 en attaque et en défense, +5 en vie)");
				}
			}
		}
		if (equipeMonstre.getPointVieGlobal()>0) {
			System.out.println(equipeMonstre.getNom()+" vous a vaincus !!");
			System.out.println("GAME OVER");
			gameOver = true;
		}
	}
}
