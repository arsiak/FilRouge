import java.util.Scanner;
import java.lang.Object;

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
		Perso Anduyn=new Humain("Anduyn","@", 4, 8, artefactAnduyn, true);
		Perso Thrall=new Orc("Thrall", "@", 6, 8, artefactThrall, false);
		Perso Legolas= new Elfe("Legolas", "@", 8, 8, artefactLegolas, false);
		equipe.listePersonnage.add(Anduyn);
		equipe.listePersonnage.add(Thrall);
		equipe.listePersonnage.add(Legolas);
		
		EquipeMonstre equipeMonstre=new EquipeMonstre();
		Monstre monstre1=new Monstre("monstre1");
		Monstre monstre2=new Monstre("monstre2");
		Monstre monstre3=new Monstre("monstre3");
		equipeMonstre.listeMonstre.add(monstre1);
		equipeMonstre.listeMonstre.add(monstre2);
		equipeMonstre.listeMonstre.add(monstre3);
		
		equipe.CalculerPointVieGlobal();
		equipeMonstre.CalculerPointVieGlobal();

		
		//Initialisation
		for(int i=0; i<equipe.listePersonnage.size(); i++) {
			System.out.println(equipe.listePersonnage.get(i).toString());
			System.out.println(equipe.listePersonnage.get(i).getCriGuerre());
		}
		
		for(int i=0; i<equipe.listePersonnage.size(); i++) {
			System.out.println(equipeMonstre.listeMonstre.get(i).toString());
			System.out.println(equipeMonstre.listeMonstre.get(i).getCriGuerre());
		}
			
		//Armure
		for(int i=0; i<equipe.listePersonnage.size(); i++) {
			if(equipe.listePersonnage.get(i).armure==true) {
				equipe.listePersonnage.get(i).setPointDefense(equipe.listePersonnage.get(i).pointDefense+5);
				System.out.println(equipe.listePersonnage.get(i).nom+" utilise l'armure");
			}
		}
		
		//Boucle de combat
		while((equipe.pointVieGlobal>0) && (equipeMonstre.pointVieGlobal>0)) {
			for (int j=0; j<100;j++) {
				Thread.sleep(20);
				System.out.print("-");
			}
			System.out.println();
			System.out.println("Tour "+tour);
			
			//Utilisation des objets
			for(int i=0; i<equipe.listePersonnage.size(); i++) {
				Double rand;
				for (int j=0; j<equipe.listePersonnage.get(i).equipement.length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.listePersonnage.get(i).equipement[j].utiliser(equipe.listePersonnage.get(i));
						System.out.println(equipe.listePersonnage.get(i).nom+" utilise "+equipe.listePersonnage.get(i).equipement[j].identifiant);
					}	
				}
			}
			
			//Combat
			for(int i=0; i<equipe.listePersonnage.size(); i++) {
				for(int j=0; j<equipeMonstre.listeMonstre.size(); j++) {
					System.out.println(equipe.listePersonnage.get(i).nom+" vs "+equipeMonstre.listeMonstre.get(j).nom);
					System.out.println(equipe.listePersonnage.get(i).toString());
					System.out.println(equipeMonstre.listeMonstre.get(j).toString());
					
					System.out.println("Saissez A pour attaquer ou P pour parer");
					if(equipe.listePersonnage.get(i) instanceof Humain) {
						System.out.println("!! Parer peut ne pas fonctionner (1/2) !!");
					}
					if(equipe.listePersonnage.get(i) instanceof Orc) {
						System.out.println("!! Parer fait perdre 1 point de défense !!");
					}
					if(equipe.listePersonnage.get(i) instanceof Elfe) {
						System.out.println("!! Parer fait perdre 1 point d'attaque !!");
					}

					option=sc.next().charAt(0);
					if(option=='A') {
						equipe.listePersonnage.get(i).Attaquer(equipeMonstre.listeMonstre.get(j));
						equipeMonstre.listeMonstre.get(j).Attaquer(equipe.listePersonnage.get(i));
					}
					else {
						if(equipe.listePersonnage.get(i) instanceof Humain) {
							boolean parer;
							parer=((Humain)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));
							if(parer==false) {
								equipeMonstre.listeMonstre.get(j).Attaquer(equipe.listePersonnage.get(i));
							}
						}
						if(equipe.listePersonnage.get(i) instanceof Orc) {
							((Orc)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));
						}
						if(equipe.listePersonnage.get(i) instanceof Elfe) {
							((Elfe)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));
						}
					}
					
					//Reset utilisation des objets
					if((equipe.listePersonnage.get(i) instanceof Humain)) {
						equipe.listePersonnage.get(i).pointAttaque=10;
						if(equipe.listePersonnage.get(i).armure==true) {
							equipe.listePersonnage.get(i).pointDefense=11;
						}
						else {
							equipe.listePersonnage.get(i).pointDefense=5;
						}
					}
					if (equipe.listePersonnage.get(i) instanceof Elfe) {
						equipe.listePersonnage.get(i).pointAttaque=12-((Elfe)equipe.listePersonnage.get(i)).parerElfe;
						if(equipe.listePersonnage.get(i).armure==true) {
							equipe.listePersonnage.get(i).pointDefense=10;
						}
						else {
							equipe.listePersonnage.get(i).pointDefense=5;
						}
					}
					if((equipe.listePersonnage.get(i) instanceof Orc) ) {
						equipe.listePersonnage.get(i).pointAttaque=12;
						if(equipe.listePersonnage.get(i).armure==true) {
							equipe.listePersonnage.get(i).pointDefense=12-((Orc)equipe.listePersonnage.get(i)).parerOrc;
						}
						else {
							equipe.listePersonnage.get(i).pointDefense=7-((Orc)equipe.listePersonnage.get(i)).parerOrc;
						}
					}
					
					System.out.println();
				}
			}
			
			for(int i=0; i<equipe.listePersonnage.size(); i++) {
				//Etat actuel des personnages
				System.out.println(equipe.listePersonnage.get(i).toString());
			}
			
			for(int i=0; i<equipeMonstre.listeMonstre.size(); i++) {
				//Etat actuel des monstres
				System.out.println(equipeMonstre.listeMonstre.get(i).toString());
			}
			tour=tour+1;
			
			for(int i=0; i<equipe.listePersonnage.size(); i++) {
				if(equipe.listePersonnage.get(i).pointVie<=0) {
					equipe.listePersonnage.remove(i);
					break;
				}
			}
			
			for(int i=0; i<equipeMonstre.listeMonstre.size(); i++) {
				if(equipeMonstre.listeMonstre.get(i).pointVie<=0) {
					equipeMonstre.listeMonstre.remove(i);
					break;
				}
			}
			
			equipe.CalculerPointVieGlobal();
			equipeMonstre.CalculerPointVieGlobal();
		}
		
		//Résultat
		if(fuite==false) {
			if (equipe.pointVieGlobal>0) {
				System.out.println(equipe.nom+" est le vainqueur !");
			}
			if (equipeMonstre.pointVieGlobal>0) {
				System.out.println(equipeMonstre.nom+" est le vainqueur !");
			}
		}
	}
}