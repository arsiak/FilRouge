package Combat;
import java.util.Random;
import java.util.Scanner;

import Equipements.Objet;
import Monstres.Assassin;
import Monstres.Chamane;
import Monstres.EquipeMonstre;
import Monstres.FactoryMonstre;
import Monstres.Necromancien;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Monstres.Monstre;
import Personnages.Paladin;
import Personnages.Personnage;

public class Combat {
	
	Scanner sc;
	int tour;
	char option;
	boolean gameOver = false;
	Equipe equipe;
	EquipeMonstre equipeMonstre;
	
	//Objets des monstres
	
	Objet[] sacVide = {};
	
	public Combat(Equipe equipe) throws Exception {
		
		this.equipe=equipe;
		sc=new Scanner(System.in);
		tour=0;
		this.initMonstre();
		this.deroulementCombat();

	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void affichageCombattants() {
		
		
		
		int bordGauche = 75, petitBordGauche = 3, rogne;
		Personnage combattant1 =  this.equipe.getListePersonnage().get(0), combattant2 = null, combattant3 = null;
		Monstre monstre1 =  equipeMonstre.getListeMonstre().get(0), monstre2 = null, monstre3 = null;
	
		switch (equipe.getListePersonnage().size()) {
			case 2 : combattant2 = equipe.getListePersonnage().get(1); break;
			case 3 : combattant2 = equipe.getListePersonnage().get(1); 
					 combattant3 = equipe.getListePersonnage().get(2);
		}
		
		switch (equipeMonstre.getListeMonstre().size()) {
			case 2 : monstre2 = equipeMonstre.getListeMonstre().get(1); break;
			case 3 : monstre2 = equipeMonstre.getListeMonstre().get(1); 
					 monstre3 = equipeMonstre.getListeMonstre().get(2);
	}
	
			
		for (int i=0; i<bordGauche; i++) { System.out.print(" "); }
			System.out.println("|                  |");
			rogne = combattant1.toString().length();
		for (int i=0; i<bordGauche-rogne-petitBordGauche; i++) { System.out.print(" "); } 
			System.out.print(combattant1.toString());
			System.out.print("   |    " +combattant1.getLettre()+ "        " +monstre1.getLettre()+ "    |   ");
			System.out.println(monstre1.toString());
			
		for (int i=0; i<bordGauche; i++) { System.out.print(" "); }
			System.out.println("|                  |");
			if (combattant2 == null) rogne = 0;
			else rogne = combattant2.toString().length();
		for (int i=0; i<bordGauche-rogne-petitBordGauche; i++) { System.out.print(" "); } 
			if (combattant2 != null) System.out.print(combattant2.toString());
			System.out.print("   |    ");
			if (combattant2 == null) System.out.print(" ");
			else System.out.print(combattant2.getLettre());
			System.out.print("        ");
			if (monstre2 == null) System.out.print(" ");
			else System.out.print(monstre2.getLettre());
			System.out.print("    |   ");
			if (monstre2 != null) System.out.println(monstre2.toString());
			else System.out.println();
			
		for (int i=0; i<bordGauche; i++) { System.out.print(" "); }
			System.out.println("|                  |");
			if (combattant3 == null) rogne = 0;
			else rogne = combattant3.toString().length();
		for (int i=0; i<bordGauche-rogne-petitBordGauche; i++) { System.out.print(" "); } 
			if (combattant3 != null) System.out.print(combattant3.toString());
			System.out.print("   |    ");
			if (combattant3 == null) System.out.print(" ");
			else System.out.print(combattant3.getLettre());
			System.out.print("        ");
			if (monstre3 == null) System.out.print(" ");
			else System.out.print(monstre3.getLettre());
			System.out.print("    |   ");
			if (monstre3 != null) System.out.println(monstre3.toString()+"\n");
			else System.out.println("\n");
		
	}
	
	public void initMonstre() throws Exception {
		
		equipeMonstre = new EquipeMonstre();
		int random = (int)(Math.random()*3+1);
		for (int i=0; i<random; i++) {
			FactoryMonstre monstre = new FactoryMonstre();
			equipeMonstre.getListeMonstre().add(monstre.getTypeMonstre());
		}
		
		/*Monstre monstre1=new Assassin("Delios","A" ,sacVide);
		Monstre monstre2=new Chamane("Chakoros","C" , sacVide);
		Monstre monstre3=new Necromancien("Neckralos","N" , sacVide);
		equipeMonstre.getListeMonstre().add(monstre1);
		equipeMonstre.getListeMonstre().add(monstre2);
		equipeMonstre.getListeMonstre().add(monstre3);*/
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
		
		equipe.CalculerPointVieGlobal();
		equipeMonstre.CalculerPointVieGlobal();
		
		//Initialisation
		/*for(int i=0; i<equipe.getListePersonnage().size(); i++) {
			System.out.println(equipe.getListePersonnage().get(i).toString());
			System.out.println(equipe.getListePersonnage().get(i).getCriGuerre());
		}
		
		for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
			System.out.println(equipeMonstre.getListeMonstre().get(i).toString());
			System.out.println(equipeMonstre.getListeMonstre().get(i).getCriGuerre());
		}*/
		
		//Boucle de combat
		while((equipe.getPointVieGlobal()>0) && (equipeMonstre.getPointVieGlobal()>0)) {
			
			this.attente();
			tour++;
			System.out.println("Tour "+tour);
			
			//Utilisation des objets
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				
				for (int j=0; j<equipe.getListePersonnage().get(i).getSac().length; j++) {
					if (equipe.getListePersonnage().get(i).getSac()[j] != null) {
						//System.out.println(equipe.getListePersonnage().get(i).getSac()[j]);
						equipe.getListePersonnage().get(i).getSac()[j].utiliser(equipe.getListePersonnage().get(i));
						//
						System.out.println(equipe.getListePersonnage().get(i).getNom()+" utilise "+equipe.getListePersonnage().get(i).getSac()[j].getNom());
					}
					
				}
				
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				Double rand;
				for (int j=0; j<equipeMonstre.getListeMonstre().get(i).getSac().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipeMonstre.getListeMonstre().get(i).getSac()[j].utiliser(equipeMonstre.getListeMonstre().get(i));
						System.out.println(equipeMonstre.getListeMonstre().get(i).getNom()+" utilise "+equipeMonstre.getListeMonstre().get(i).getSac()[j].getNom());
					}	
				}
			}
			
			
			//Combat
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {	
				
				this.affichageCombattants();
				
				System.out.println(equipe.getListePersonnage().get(i).getNom()+ " attend vos ordre");
				System.out.println("Saisissez A pour attaquer ou P pour parer");
				if(equipe.getListePersonnage().get(i) instanceof Paladin) {
					System.out.println("!! Parer fait gagner un point de rage et de mana !!");
				}
				if(equipe.getListePersonnage().get(i) instanceof Guerrier) {
					System.out.println("!! Parer fait gagner 1 point de rage !!");
				}
				if(equipe.getListePersonnage().get(i) instanceof Mage) {
					System.out.println("!! Parer fait gagner 1 point de mana !!");
				}

				option=sc.next().charAt(0);
				if(option=='A' || option=='a') {
					String cible="";
					boolean verifCible=false;
					while(verifCible==false) {
						Scanner scAttaque=new Scanner(System.in);
						System.out.println("Saisissez le nom de la cible");
						cible=scAttaque.nextLine();
						for(int j=0; j<equipeMonstre.getListeMonstre().size(); j++) {
							if(cible.equals(equipeMonstre.getListeMonstre().get(j).getNom())) {
								verifCible=true;
								System.out.println(equipe.getListePersonnage().get(i).getNom()+" vs "+equipeMonstre.getListeMonstre().get(j).getNom());
								System.out.println();
								if(equipe.getListePersonnage().get(i) instanceof Guerrier) {
									((Guerrier)equipe.getListePersonnage().get(i)).Attaquer(equipeMonstre.getListeMonstre().get(j));
									break;
								}
								if(equipe.getListePersonnage().get(i) instanceof Mage) {
									((Mage)equipe.getListePersonnage().get(i)).Attaquer(equipeMonstre.getListeMonstre().get(j));
									break;
								}
								if(equipe.getListePersonnage().get(i) instanceof Paladin) {
									((Paladin)equipe.getListePersonnage().get(i)).Attaquer(equipeMonstre.getListeMonstre().get(j));
									break;
								}
							}
						}
					}
				}
				else if (option=='P' || option=='p'){
					if(equipe.getListePersonnage().get(i) instanceof Guerrier) {
						((Guerrier)equipe.getListePersonnage().get(i)).Parer();	
						break;
					}
					if(equipe.getListePersonnage().get(i) instanceof Mage) {
						((Mage)equipe.getListePersonnage().get(i)).Parer();
						break;
					}
					if(equipe.getListePersonnage().get(i) instanceof Paladin) {
						((Paladin)equipe.getListePersonnage().get(i)).Parer();
						break;
					}
				}
				else {
					System.out.println("Le joueur est périfié de peur (mauvaise saisie de touche)");
				}
			}		
			
			System.out.println("Les monstres s'apprêtent à vous attaquer");
			this.attente();
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				
				int choixCible=(int)(Math.random()*equipe.getListePersonnage().size());
							
					equipeMonstre.getListeMonstre().get(i).Attaquer(equipe.getListePersonnage().get(choixCible));
				/*
					if(equipeMonstre.getListeMonstre().get(i) instanceof Assassin) {
						((Assassin)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(choixCible));	
					}
					if(equipeMonstre.getListeMonstre().get(i) instanceof Chamane) {
						((Chamane)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(choixCible));
					}
					if(equipeMonstre.getListeMonstre().get(i) instanceof Necromancien) {
						((Necromancien)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(choixCible));
					}
				*/
			}
			
			tour=tour+1;
			
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				if(equipe.getListePersonnage().get(i).getPointVie()<=0) {
					System.out.println(equipe.getListePersonnage().get(i).getNom()+" est KO");
					equipe.getListePersonnage().remove(i);
					break;
				}
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				if(equipeMonstre.getListeMonstre().get(i).getPointVie()<=0) {
					System.out.println(equipeMonstre.getListeMonstre().get(i).getNom()+" a été neutralisé");
					equipeMonstre.getListeMonstre().get(i).setEstVivant(false);
					equipeMonstre.getListeMonstre().remove(i);
					
					break;
				}
			}
			
			equipe.CalculerPointVieGlobal();
			equipeMonstre.CalculerPointVieGlobal();
			
						
		}
		//fin combat
				
			
			//Reset utilisation des objets
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {	
				if(equipe.getListePersonnage().get(i) instanceof Guerrier) {
					((Guerrier)equipe.getListePersonnage().get(i)).setPointRage(10+((Guerrier)equipe.getListePersonnage().get(i)).getParerGuerrier());
					equipe.getListePersonnage().get(i).setPointMana(0);
					equipe.getListePersonnage().get(i).setPointDefense(5);
					equipe.getListePersonnage().get(i).setPointResistance(5);
				}
				if(equipe.getListePersonnage().get(i) instanceof Mage) {
					equipe.getListePersonnage().get(i).setPointRage(0);
					((Mage)equipe.getListePersonnage().get(i)).setPointMana(10+((Mage)equipe.getListePersonnage().get(i)).getParerMage());
					equipe.getListePersonnage().get(i).setPointDefense(5);
					equipe.getListePersonnage().get(i).setPointResistance(5);
				}
				if(equipe.getListePersonnage().get(i) instanceof Paladin) {
					((Paladin)equipe.getListePersonnage().get(i)).setPointRage(10+((Paladin)equipe.getListePersonnage().get(i)).getParerPaladin());
					((Paladin)equipe.getListePersonnage().get(i)).setPointMana(10+((Paladin)equipe.getListePersonnage().get(i)).getParerPaladin());
					equipe.getListePersonnage().get(i).setPointDefense(5);
					equipe.getListePersonnage().get(i).setPointResistance(5);
				}
				System.out.println();
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {	
				if(equipeMonstre.getListeMonstre().get(i) instanceof Assassin) {
					equipeMonstre.getListeMonstre().get(i).setPointRage(10);
					equipeMonstre.getListeMonstre().get(i).setPointMana(0);
					equipeMonstre.getListeMonstre().get(i).setPointDefense(5);
					equipeMonstre.getListeMonstre().get(i).setPointResistance(5);
				}
				if(equipeMonstre.getListeMonstre().get(i) instanceof Chamane) {
					equipeMonstre.getListeMonstre().get(i).setPointRage(10);
					equipeMonstre.getListeMonstre().get(i).setPointMana(10);
					equipeMonstre.getListeMonstre().get(i).setPointDefense(5);
					equipeMonstre.getListeMonstre().get(i).setPointResistance(5);
				}
				if(equipeMonstre.getListeMonstre().get(i) instanceof Necromancien) {
					equipeMonstre.getListeMonstre().get(i).setPointRage(0);
					equipeMonstre.getListeMonstre().get(i).setPointMana(10);
					equipeMonstre.getListeMonstre().get(i).setPointDefense(5);
					equipeMonstre.getListeMonstre().get(i).setPointResistance(5);
				}
				System.out.println();
			}
		
		
		//Résultat
		if (equipe.getPointVieGlobal()>0) {
			System.out.println(equipe.getNom()+" est le vainqueur !");
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				if(equipe.getListePersonnage().get(i).getPointVie()>0) {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+10);
					System.out.println(equipe.getListePersonnage().get(i).getNom()+ "gagne 10 XP." );
				}
				else {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+5); 
					System.out.println(equipe.getListePersonnage().get(i).getNom()+ "gagne 5 XP." );
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
