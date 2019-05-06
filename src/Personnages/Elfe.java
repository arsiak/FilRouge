package Personnages;
import Cartes.Coord;
import Equipements.Artefact;

public class Elfe extends Perso{
	private int parerElfe;
	
	public Elfe(String nom, Coord coord, Artefact[] listeArtefact, boolean armure) {
		super(nom, coord, listeArtefact, armure);
		this.pointAttaque=12;
		this.pointDefense=2;
		this.criGuerre="A l'attaque !!";
		this.setParerElfe(0);
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
		this.setParerElfe(getParerElfe()+1);
	}
	
	public String toString() {
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}

	public int getParerElfe() {
		return parerElfe;
	}

	public void setParerElfe(int parerElfe) {
		this.parerElfe = parerElfe;
	}
}
