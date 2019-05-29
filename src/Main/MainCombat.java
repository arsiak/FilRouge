package Main;
import java.util.Scanner;

import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;
import Monstres.Assassin;
import Monstres.Chamane;
import Monstres.EquipeMonstre;
import Monstres.Necromancien;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Monstres.Monstre;
import Personnages.Paladin;
import Personnages.Personnage;

public class MainCombat {
	
	public static void main(String[] Args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		int tour=1;
		char option;
		
		//Objets
		Arme[] sac1 = {Arme.Epee, Arme.Potion};
		Arme[] sac2 = {Arme.Epee, Arme.Arc};
		Arme[] sac3 = {Arme.Sceptre, Arme.GrandeEpee};
		
		Armure[] armure1 = {Armure.Bouclier};
		Armure[] armure2 = {Armure.Plastron}; 
		Armure[] armure3 = {Armure.BouclierMagique};
		
		//Coordonnées
		Coord coord1=new Coord(4,8);
		Coord coord2=new Coord(6,8);
		Coord coord3=new Coord(8,8);
		Coord coord4=new Coord(4,12);
		Coord coord5=new Coord(4,12);
		Coord coord6=new Coord(4,12);
		
		//Personnages
		Equipe equipe=new Equipe();
		Personnage Anduyn=new Paladin("Anduyn",coord1 , sac1, armure1);
		Personnage Thrall=new Guerrier("Thrall",coord2 , sac2, armure2);
		Personnage Legolas= new Mage("Legolas",coord3 , sac3, armure3);
		equipe.getListePersonnage().add(Anduyn);
		equipe.getListePersonnage().add(Thrall);
		equipe.getListePersonnage().add(Legolas);
		
		//Triage selon vitesse
		/** for(int i=0; i<equipe.getListePersonnage().size(); i++) {
			Perso temporaire;
			if(equipe.getListePersonnage().get(i).pointVitesse<equipe.getListePersonnage().get(i+1).pointVitesse) {
				temporaire=equipe.getListePersonnage().get(i);
				equipe.getListePersonnage().remove(i);
				equipe.getListePersonnage().add(temporaire);
			}
		} **/
		
		EquipeMonstre equipeMonstre=new EquipeMonstre();
		Monstres.Monstre monstre1=new Assassin("monstre1","M" ,coord4 , sac1, armure1);
		Monstres.Monstre monstre2=new Chamane("monstre2","M" ,coord5, sac2, armure2);
		Monstres.Monstre monstre3=new Necromancien("monstre3","M" ,coord6 , sac3, armure3);
		equipeMonstre.getListeMonstre().add(monstre1);
		equipeMonstre.getListeMonstre().add(monstre2);
		equipeMonstre.getListeMonstre().add(monstre3);
		
		equipe.CalculerPointVieGlobal();
		equipeMonstre.CalculerPointVieGlobal();

		
		//Initialisation
		for(int i=0; i<equipe.getListePersonnage().size(); i++) {
			System.out.println(equipe.getListePersonnage().get(i).toString());
			System.out.println(equipe.getListePersonnage().get(i).getCriGuerre());
		}
		
		for(int i=0; i<equipe.getListePersonnage().size(); i++) {
			System.out.println(equipeMonstre.getListeMonstre().get(i).toString());
			System.out.println(equipeMonstre.getListeMonstre().get(i).getCriGuerre());
		}
		
		//Boucle de combat
		while((equipe.getPointVieGlobal()>0) && (equipeMonstre.getPointVieGlobal()>0)) {
			for (int j=0; j<100;j++) {
				Thread.sleep(20);
				System.out.print("-");
			}
			System.out.println();
			System.out.println("Tour "+tour);
			
			//Utilisation des objets
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				Double rand;
				for (int j=0; j<equipe.getListePersonnage().get(i).getSacArme().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.getListePersonnage().get(i).personnage_sacArme[j].Utiliser(equipe.getListePersonnage().get(i));
						System.out.println(equipe.getListePersonnage().get(i).getNom()+" utilise "+equipe.getListePersonnage().get(i).getSacArme()[j]);
					}	
				}
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				Double rand;
				for (int j=0; j<equipeMonstre.getListeMonstre().get(i).getSacArme().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipeMonstre.getListeMonstre().get(i).monstre_sacArme[j].Utiliser(equipeMonstre.getListeMonstre().get(i));
						System.out.println(equipeMonstre.getListeMonstre().get(i).getNom()+" utilise "+equipeMonstre.getListeMonstre().get(i).getSacArme()[j]);
					}	
				}
			}
			
			//Utilisation des objets d'armures
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				Double rand;
				for (int j=0; j<equipe.getListePersonnage().get(i).getArmure().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.getListePersonnage().get(i).personnage_armure[j].Utiliser(equipe.getListePersonnage().get(i));
						System.out.println(equipe.getListePersonnage().get(i).getNom()+" utilise "+equipe.getListePersonnage().get(i).getArmure()[j]);
					}	
				}
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				Double rand;
				for (int j=0; j<equipeMonstre.getListeMonstre().get(i).getArmure().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						((Armure) equipeMonstre.getListeMonstre().get(i).monstre_armure[j]).Utiliser(equipeMonstre.getListeMonstre().get(i));
						System.out.println(equipeMonstre.getListeMonstre().get(i).getNom()+" utilise "+equipeMonstre.getListeMonstre().get(i).getArmure()[j]);
					}	
				}
			}
			
			//Combat
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {			
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
				if(option=='A') {
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
								System.out.println(equipe.getListePersonnage().get(i).toString());
								System.out.println(equipeMonstre.getListeMonstre().get(j).toString());
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
				else {
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
			}		
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				String cible="";
				boolean verifCible=false;
				double choix;
				while(verifCible==false) {
					for(int j=0; j<equipe.getListePersonnage().size(); j++) {
						choix=Math.random();
						if (choix<(1/equipe.getListePersonnage().size())) {
							if(equipeMonstre.getListeMonstre().get(i) instanceof Assassin) {
								((Assassin)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(i));	
							}
							if(equipeMonstre.getListeMonstre().get(i) instanceof Chamane) {
								((Chamane)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(i));
							}
							if(equipeMonstre.getListeMonstre().get(i) instanceof Necromancien) {
								((Necromancien)equipeMonstre.getListeMonstre().get(i)).Attaquer(equipe.getListePersonnage().get(i));
							}
							verifCible=true;
							break;
						}
					}
				}
			}
			
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
			
			
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				//Etat actuel des personnages
				System.out.println(equipe.getListePersonnage().get(i).toString());
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				//Etat actuel des monstres
				System.out.println(equipeMonstre.getListeMonstre().get(i).toString());
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
					equipeMonstre.getListeMonstre().remove(i);
					equipeMonstre.getListeMonstre().get(i).setEstVivant(false);
					break;
				}
			}
			
			equipe.CalculerPointVieGlobal();
			equipeMonstre.CalculerPointVieGlobal();
		}
		
		//Résultat
		if (equipe.getPointVieGlobal()>0) {
			System.out.println(equipe.getNom()+" est le vainqueur !");
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				if(equipe.getListePersonnage().get(i).getPointVie()>0) {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+10);
				}
				else {
					equipe.getListePersonnage().get(i).setXP(equipe.getListePersonnage().get(i).getXP()+5); 
				}
			}
		}
		if (equipeMonstre.getPointVieGlobal()>0) {
			System.out.println(equipeMonstre.getNom()+" est le vainqueur !");
		}
	}
}
