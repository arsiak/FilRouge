import java.util.Scanner;

public class Combat {
	
	public static void main(String[] Args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		int tour=1;
		char option;
		boolean fuite=false;
		
		//Objets
		Arme[] sac1= {Arme.Epee, Arme.Potion};
		Arme[] sac2= {Arme.Epee, Arme.Arc};
		Arme[] sac3= {Arme.Sceptre, Arme.GrandeEpee};
		
		Armure[] armure1= {Armure.Bouclier};
		Armure[] armure2= {Armure.Plastron}; 
		Armure[] armure3= {Armure.BouclierMagique};
		
		//Personnages
		Equipe equipe=new Equipe();
		Perso Anduyn=new Paladin("Anduyn","@", 4, 8, sac1, armure1);
		Perso Thrall=new Guerrier("Thrall", "@", 6, 8, sac2, armure2);
		Perso Legolas= new Mage("Legolas", "@", 8, 8, sac3, armure3);
		equipe.listePersonnage.add(Anduyn);
		equipe.listePersonnage.add(Thrall);
		equipe.listePersonnage.add(Legolas);
		
		//Triage selon vitesse
		/** for(int i=0; i<equipe.listePersonnage.size(); i++) {
			Perso temporaire;
			if(equipe.listePersonnage.get(i).pointVitesse<equipe.listePersonnage.get(i+1).pointVitesse) {
				temporaire=equipe.listePersonnage.get(i);
				equipe.listePersonnage.remove(i);
				equipe.listePersonnage.add(temporaire);
			}
		} **/
		
		EquipeMonstre equipeMonstre=new EquipeMonstre();
		Monstre monstre1=new Assassin("monstre1", "M", 4, 12, sac1, armure1);
		Monstre monstre2=new Chamane("monstre2", "M", 6, 12, sac2, armure2);
		Monstre monstre3=new GuerrierNecromancien("monstre3", "M", 8, 12, sac3, armure3);
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
				for (int j=0; j<equipe.listePersonnage.get(i).sacArme.length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.listePersonnage.get(i).sacArme[j].Utiliser(equipe.listePersonnage.get(i));
						System.out.println(equipe.listePersonnage.get(i).nom+" utilise "+equipe.listePersonnage.get(i).sacArme[j]);
					}	
				}
			}
			
			for(int i=0; i<equipeMonstre.listeMonstre.size(); i++) {
				Double rand;
				for (int j=0; j<equipeMonstre.listeMonstre.get(i).sacArme.length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipeMonstre.listeMonstre.get(i).sacArme[j].Utiliser(equipeMonstre.listeMonstre.get(i));
						System.out.println(equipeMonstre.listeMonstre.get(i).nom+" utilise "+equipeMonstre.listeMonstre.get(i).sacArme[j]);
					}	
				}
			}
			
			//Utilisation des objets d'armures
			for(int i=0; i<equipe.listePersonnage.size(); i++) {
				Double rand;
				for (int j=0; j<equipe.listePersonnage.get(i).armure.length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipe.listePersonnage.get(i).armure[j].Utiliser(equipe.listePersonnage.get(i));
						System.out.println(equipe.listePersonnage.get(i).nom+" utilise "+equipe.listePersonnage.get(i).armure[j]);
					}	
				}
			}
			
			for(int i=0; i<equipeMonstre.listeMonstre.size(); i++) {
				Double rand;
				for (int j=0; j<equipeMonstre.listeMonstre.get(i).armure.length; j++) {
					rand=Math.random();
					if(rand>=0.5) {
						equipeMonstre.listeMonstre.get(i).armure[j].Utiliser(equipeMonstre.listeMonstre.get(i));
						System.out.println(equipeMonstre.listeMonstre.get(i).nom+" utilise "+equipeMonstre.listeMonstre.get(i).armure[j]);
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
					if(equipe.listePersonnage.get(i) instanceof Paladin) {
						System.out.println("!! Parer fait perdre un point de rage et de mana !!");
					}
					if(equipe.listePersonnage.get(i) instanceof Guerrier) {
						System.out.println("!! Parer fait perdre 1 point de rage !!");
					}
					if(equipe.listePersonnage.get(i) instanceof Mage) {
						System.out.println("!! Parer fait perdre 1 point de mana !!");
					}

					option=sc.next().charAt(0);
					if(option=='A') {
						if(equipe.listePersonnage.get(i) instanceof Guerrier) {
							((Guerrier)equipe.listePersonnage.get(i)).Attaquer(equipeMonstre.listeMonstre.get(j));	
						}
						if(equipe.listePersonnage.get(i) instanceof Mage) {
							((Mage)equipe.listePersonnage.get(i)).Attaquer(equipeMonstre.listeMonstre.get(j));
						}
						if(equipe.listePersonnage.get(i) instanceof Paladin) {
							((Paladin)equipe.listePersonnage.get(i)).Attaquer(equipeMonstre.listeMonstre.get(j));
						}
						
						if(equipeMonstre.listeMonstre.get(j) instanceof Assassin) {
							((Assassin)equipeMonstre.listeMonstre.get(j)).Attaquer(equipe.listePersonnage.get(i));	
						}
						if(equipeMonstre.listeMonstre.get(j) instanceof Chamane) {
							((Chamane)equipeMonstre.listeMonstre.get(j)).Attaquer(equipe.listePersonnage.get(i));
						}
						if(equipeMonstre.listeMonstre.get(j) instanceof GuerrierNecromancien) {
							((GuerrierNecromancien)equipeMonstre.listeMonstre.get(j)).Attaquer(equipe.listePersonnage.get(i));
						}
					}
					else {
						if(equipe.listePersonnage.get(i) instanceof Guerrier) {
							((Guerrier)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));	
						}
						if(equipe.listePersonnage.get(i) instanceof Mage) {
							((Mage)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));
						}
						if(equipe.listePersonnage.get(i) instanceof Paladin) {
							((Paladin)equipe.listePersonnage.get(i)).Parer(equipeMonstre.listeMonstre.get(j));
						}
					}
					
					//Reset utilisation des objets
					if(equipe.listePersonnage.get(i) instanceof Guerrier) {
						((Guerrier)equipe.listePersonnage.get(i)).pointRage=10-((Guerrier)equipe.listePersonnage.get(i)).parerGuerrier;
						equipe.listePersonnage.get(i).pointMana=0;
						equipe.listePersonnage.get(i).pointDefense=5;
						equipe.listePersonnage.get(i).pointResistance=5;
						
					}
					if(equipe.listePersonnage.get(i) instanceof Mage) {
						equipe.listePersonnage.get(i).pointRage=0;
						((Mage)equipe.listePersonnage.get(i)).pointMana=10-((Mage)equipe.listePersonnage.get(i)).parerMage;
						equipe.listePersonnage.get(i).pointDefense=5;
						equipe.listePersonnage.get(i).pointResistance=5;
					}
					if(equipe.listePersonnage.get(i) instanceof Paladin) {
						((Paladin)equipe.listePersonnage.get(i)).pointRage=10-((Paladin)equipe.listePersonnage.get(i)).parerPaladin;
						((Paladin)equipe.listePersonnage.get(i)).pointMana=10-((Paladin)equipe.listePersonnage.get(i)).parerPaladin;
						equipe.listePersonnage.get(i).pointDefense=5;
						equipe.listePersonnage.get(i).pointResistance=5;
					}
					
					if(equipeMonstre.listeMonstre.get(i) instanceof Assassin) {
						equipeMonstre.listeMonstre.get(i).pointRage=10;
						equipeMonstre.listeMonstre.get(i).pointMana=0;
						equipeMonstre.listeMonstre.get(i).pointDefense=5;
						equipeMonstre.listeMonstre.get(i).pointResistance=5;
						
					}
					if(equipeMonstre.listeMonstre.get(i) instanceof Chamane) {
						equipeMonstre.listeMonstre.get(i).pointRage=0;
						equipeMonstre.listeMonstre.get(i).pointMana=10;
						equipeMonstre.listeMonstre.get(i).pointDefense=5;
						equipeMonstre.listeMonstre.get(i).pointResistance=5;
					}
					if(equipeMonstre.listeMonstre.get(i) instanceof GuerrierNecromancien) {
						equipeMonstre.listeMonstre.get(i).pointRage=10;
						equipeMonstre.listeMonstre.get(i).pointMana=10;
						equipeMonstre.listeMonstre.get(i).pointDefense=5;
						equipeMonstre.listeMonstre.get(i).pointResistance=5;
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
					System.out.println(equipe.listePersonnage.get(i).nom+" est KO");
					equipe.listePersonnage.remove(i);
					break;
				}
			}
			
			for(int i=0; i<equipeMonstre.listeMonstre.size(); i++) {
				if(equipeMonstre.listeMonstre.get(i).pointVie<=0) {
					System.out.println(equipeMonstre.listeMonstre.get(i).nom+" a été neutralisé");
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
				for(int i=0; i<equipe.listePersonnage.size(); i++) {
					if(equipe.listePersonnage.get(i).pointVie>0) {
						equipe.listePersonnage.get(i).XP=equipe.listePersonnage.get(i).XP+10;
					}
					else {
						equipe.listePersonnage.get(i).XP=equipe.listePersonnage.get(i).XP+5; 
					}
				}
			}
			if (equipeMonstre.pointVieGlobal>0) {
				System.out.println(equipeMonstre.nom+" est le vainqueur !");
			}
		}
	}
}