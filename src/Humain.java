import java.util.ArrayList;

public class Humain extends Perso {
	
	public Humain(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure, Metier metier) {
		super(nom, lettre, positionX, positionY, listeArtefact, armure, metier);
		this.pointVitesse=5;
		this.criGuerre="A l'attaque !!";
		if(metier instanceof Guerrier) {
			this.pointAttaque=10;
			this.pointMagie=0;
		}
		if(metier instanceof Mage) {
			this.pointAttaque=0;
			this.pointMagie=10;
		}
	}
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public boolean Parer(Monstre monstre) {
		System.out.println(this.nom+" tente de parer "+monstre.nom+" !");
		double parer;
		parer=Math.random();
		if(parer<0.5) {
			this.Attaquer(monstre);
			return false;
		}
		else {
			System.out.println(this.nom+" pare "+monstre.nom+" !");
			return true;
		}
	}
	
	public String toString() {
		return "Nom : "+nom +" | Vie : "+pointVie+" | Attaque : "+pointAttaque+" | Défense : "+pointDefense+" | Magie : "+pointMagie+" | Résistance : "+pointResistance+" | Vitesse : "+pointVitesse;
	}
}
