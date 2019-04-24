import java.util.ArrayList;
import java.util.Scanner;

public class FactoryPersonnage {
	public Perso getPerso(String typePerso) {
		Perso perso;
		switch(typePerso) {
			case "Humain":
				Scanner scHumain=new Scanner(System.in);
				String nomHumain;
				String lettreHumain;
				Artefact[] listeArtefactHumain=new Artefact[3];
				System.out.println("Création d'un humain :");
				System.out.println("Nom :");
				nomHumain=scHumain.nextLine();
				System.out.println("Lettre (représentation personnage) :");
				lettreHumain=scHumain.nextLine();
				for(int i=0; i<listeArtefactHumain.length;i++) {
					System.out.println("Saisissez un objet :");
					listeArtefactHumain[i].identifiant=scHumain.nextLine();
				}
				perso = new Humain(nomHumain, lettreHumain, 6, 8, listeArtefactHumain, false);
				System.out.println("Vous avez créé l'humain "+nomHumain);
			break;
			case "Orc":
				Scanner scOrc=new Scanner(System.in);
				String nomOrc;
				String lettreOrc;
				Artefact[] listeArtefactOrc=new Artefact[3];
				System.out.println("Création d'un Orc :");
				System.out.println("Nom :");
				nomOrc=scOrc.nextLine();
				System.out.println("Lettre (représentation personnage) :");
				lettreOrc=scOrc.nextLine();
				for(int i=0; i<listeArtefactOrc.length;i++) {
					System.out.println("Saisissez un objet :");
					listeArtefactOrc[i].identifiant=scOrc.nextLine();
				}
				perso = new Orc(nomOrc, lettreOrc, 6, 8, listeArtefactOrc, false);
				System.out.println("Vous avez créé l'orc "+nomOrc);
			break;
			case "Elfe":
				Scanner scElfe=new Scanner(System.in);
				String nomElfe;
				String lettreElfe;
				Artefact[] listeArtefactElfe=new Artefact[3];
				System.out.println("Création d'un Elfe :");
				System.out.println("Nom :");
				nomElfe=scElfe.nextLine();
				System.out.println("Lettre (représentation personnage) :");
				lettreElfe=scElfe.nextLine();
				for(int i=0; i<listeArtefactElfe.length;i++) {
					System.out.println("Saisissez un objet :");
					listeArtefactElfe[i].identifiant=scElfe.nextLine();
				}
				perso = new Elfe(nomElfe, lettreElfe, 6, 8, listeArtefactElfe, false);
				System.out.println("Vous avez créé l'elfe "+nomElfe);
			break;
			default :
			throw new IllegalArgumentException("Type de produit inconnu");
		}
		return perso ;
	}
}
