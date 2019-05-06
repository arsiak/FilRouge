package Main;
import java.util.Scanner;

import Cartes.Coord;
import Equipements.Armure;
import Equipements.Artefact;
import Equipements.Bouclier;
import Equipements.Epee;
import Equipements.PotionDeVie;
import Personnages.Elfe;
import Personnages.Equipe;
import Personnages.EquipeMonstre;
import Personnages.Humain;
import Personnages.Monstre;
import Personnages.Orc;
import Personnages.Perso;


public class Combat {
	
	public static void main(String[] Args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		int tour=1;
		char option;
		boolean fuite=false;
		
		//Objets
		Epee epee=new Epee("epee");
		Bouclier bouclier=new Bouclier("bouclier");
		Armure armure=new Armure("armure");
		PotionDeVie potiondevie=new PotionDeVie("potion");
		Artefact[] artefactAnduyn= {epee};
		Artefact[] artefactThrall= {epee, bouclier};
		Artefact[] artefactLegolas= {epee, potiondevie};
		
		//Personnages
		Equipe equipe=new Equipe();
		Perso Anduyn=new Humain("Anduyn",new Coord(6,8), artefactAnduyn, true);
		Perso Thrall=new Orc("Thrall",new Coord(6,8), artefactThrall, false);
		Perso Legolas= new Elfe("Legolas",new Coord(6,8), artefactLegolas, false);
		equipe.getListePersonnage().add(Anduyn);
		equipe.getListePersonnage().add(Thrall);
		equipe.getListePersonnage().add(Legolas);
		
		EquipeMonstre equipeMonstre=new EquipeMonstre();
		Monstre monstre1=new Monstre("monstre1");
		Monstre monstre2=new Monstre("monstre2");
		Monstre monstre3=new Monstre("monstre3");
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
			
		//Armure
		for(int i=0; i<equipe.getListePersonnage().size(); i++) {
			if(equipe.getListePersonnage().get(i).armure==true) {
				equipe.getListePersonnage().get(i).setPointDefense(equipe.getListePersonnage().get(i).getPointDefense()+5);
				System.out.println(equipe.getListePersonnage().get(i).getNom()+" utilise l'armure");
			}
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
				for (int j=0; j<equipe.getListePersonnage().get(i).getEquipement().length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.getListePersonnage().get(i).getEquipement()[j].utiliser(equipe.getListePersonnage().get(i));
						System.out.println(equipe.getListePersonnage().get(i).getNom()+" utilise "+equipe.getListePersonnage().get(i).getEquipement()[j].identifiant);
					}	
				}
			}
			
			//Combat
			for(int i=0; i<equipe.getListePersonnage().size(); i++) {
				for(int j=0; j<equipeMonstre.getListeMonstre().size(); j++) {
					System.out.println(equipe.getListePersonnage().get(i).getNom()+" vs "+equipeMonstre.getListeMonstre().get(j).getNom());
					System.out.println(equipe.getListePersonnage().get(i).toString());
					System.out.println(equipeMonstre.getListeMonstre().get(j).toString());
					
					System.out.println("Saissez A pour attaquer ou P pour parer");
					if(equipe.getListePersonnage().get(i) instanceof Humain) {
						System.out.println("!! Parer peut ne pas fonctionner (1/2) !!");
					}
					if(equipe.getListePersonnage().get(i) instanceof Orc) {
						System.out.println("!! Parer fait perdre 1 point de défense !!");
					}
					if(equipe.getListePersonnage().get(i) instanceof Elfe) {
						System.out.println("!! Parer fait perdre 1 point d'attaque !!");
					}

					option=sc.next().charAt(0);
					if(option=='A') {
						equipe.getListePersonnage().get(i).Attaquer(equipeMonstre.getListeMonstre().get(j));
						equipeMonstre.getListeMonstre().get(j).Attaquer(equipe.getListePersonnage().get(i));
					}
					else {
						if(equipe.getListePersonnage().get(i) instanceof Humain) {
							boolean parer;
							parer=((Humain)equipe.getListePersonnage().get(i)).Parer(equipeMonstre.getListeMonstre().get(j));
							if(parer==false) {
								equipeMonstre.getListeMonstre().get(j).Attaquer(equipe.getListePersonnage().get(i));
							}
						}
						if(equipe.getListePersonnage().get(i) instanceof Orc) {
							((Orc)equipe.getListePersonnage().get(i)).Parer(equipeMonstre.getListeMonstre().get(j));
						}
						if(equipe.getListePersonnage().get(i) instanceof Elfe) {
							((Elfe)equipe.getListePersonnage().get(i)).Parer(equipeMonstre.getListeMonstre().get(j));
						}
					}
					
					//Reset utilisation des objets
					if((equipe.getListePersonnage().get(i) instanceof Humain)) {
						equipe.getListePersonnage().get(i).setPointAttaque(10);
						if(equipe.getListePersonnage().get(i).armure==true) {
							equipe.getListePersonnage().get(i).setPointDefense(11);
						}
						else {
							equipe.getListePersonnage().get(i).setPointDefense(5);
						}
					}
					if (equipe.getListePersonnage().get(i) instanceof Elfe) {
						equipe.getListePersonnage().get(i).setPointAttaque(12-((Elfe)equipe.getListePersonnage().get(i)).getParerElfe());
						if(equipe.getListePersonnage().get(i).armure==true) {
							equipe.getListePersonnage().get(i).setPointDefense(10);
						}
						else {
							equipe.getListePersonnage().get(i).setPointDefense(5);
						}
					}
					if((equipe.getListePersonnage().get(i) instanceof Orc) ) {
						equipe.getListePersonnage().get(i).setPointAttaque(12);
						if(equipe.getListePersonnage().get(i).armure==true) {
							equipe.getListePersonnage().get(i).setPointDefense(12-((Orc)equipe.getListePersonnage().get(i)).getParerOrc());
						}
						else {
							equipe.getListePersonnage().get(i).setPointDefense(7-((Orc)equipe.getListePersonnage().get(i)).getParerOrc());
						}
					}
					
					System.out.println();
				}
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
					equipe.getListePersonnage().remove(i);
					break;
				}
			}
			
			for(int i=0; i<equipeMonstre.getListeMonstre().size(); i++) {
				if(equipeMonstre.getListeMonstre().get(i).pointVie<=0) {
					equipeMonstre.getListeMonstre().remove(i);
					break;
				}
			}
			
			equipe.CalculerPointVieGlobal();
			equipeMonstre.CalculerPointVieGlobal();
		}
		
		//Résultat
		if(fuite==false) {
			if (equipe.getPointVieGlobal()>0) {
				System.out.println(equipe.getNom()+" est le vainqueur !");
			}
			if (equipeMonstre.getPointVieGlobal()>0) {
				System.out.println(equipeMonstre.getNom()+" est le vainqueur !");
			}
		}
	}
}