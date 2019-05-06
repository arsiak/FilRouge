import java.util.ArrayList;

public class Orc extends Perso{
	int parerOrc;
	
	public Orc(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure, Metier metier) {
		super(nom, lettre, positionX, positionY, listeArtefact, armure, metier);
		this.pointVie=90;
		this.pointDefense=7;
		this.pointVitesse=3;
		this.criGuerre="A l'attaque";
		this.parerOrc=0;
		if(metier instanceof Guerrier) {
			this.pointAttaque=12;
			this.pointMagie=0;
		}
		if(metier instanceof Mage) {
			this.pointAttaque=0;
			this.pointMagie=8;
		}
	}
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public void Parer(Monstre monstre) {
		System.out.println(this.nom+" pare "+monstre.nom+" !");
		this.parerOrc=parerOrc+1;
	}
	
	public String toString() {
		return "Nom : "+nom +" | Vie : "+pointVie+" | Attaque : "+pointAttaque+" | Défense : "+pointDefense+" | Magie : "+pointMagie+" | Résistance : "+pointResistance+" | Vitesse : "+pointVitesse;
	}
}
