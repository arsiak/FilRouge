import java.util.ArrayList;

public class Elfe extends Perso{
	int parerElfe;
	
	public Elfe(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure, Metier metier) {
		super(nom, lettre, positionX, positionY, listeArtefact, armure, metier);
		this.pointDefense=2;
		this.pointVitesse=7;
		this.criGuerre="A l'attaque !!";
		this.parerElfe=0;
		if(metier instanceof Guerrier) {
			this.pointAttaque=12;
			this.pointMagie=0;
		}
		if(metier instanceof Mage) {
			this.pointAttaque=0;
			this.pointMagie=12;
		}
	}	
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public void GagnerCombat(int pointVie, int pointDefense) {
		setPointVie(pointVie+2);
		setPointDefense(pointDefense+2);
	}
	
	public void Parer(Monstre monstre) {
		System.out.println(this.nom+" pare "+monstre.nom+" !");
		this.parerElfe=parerElfe+1;
	}
	
	public String toString() {
		return "Nom : "+nom +" | Vie : "+pointVie+" | Attaque : "+pointAttaque+" | Défense : "+pointDefense+" | Magie : "+pointMagie+" | Résistance : "+pointResistance+" | Vitesse : "+pointVitesse;
	}
}
