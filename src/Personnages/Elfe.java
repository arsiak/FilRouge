package Personnages;
import Cartes.Coord;
import Equipements.Equipement;

public class Elfe extends Personnage{
	private int parerElfe;
	
	public Elfe(String elfe_nom, Coord elfe_coord, Equipement[] elfe_listeEquipements, boolean elfe_hasArmure) {
		super(elfe_nom, elfe_coord, elfe_listeEquipements, elfe_hasArmure);
		this.personnage_pointAttaque=12;
		this.personnage_pointDefense=2;
		this.personnage_criGuerre="A l'attaque !!";
		this.setParerElfe(0);
	}	
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public void GagnerCombat(int pointVie, int pointDefense) {
		setPointVie(pointVie+2);
		setPointDefense(pointDefense+2);
	}
	
	public void parer(Monstre monstre) {
		System.out.println(this.personnage_nom+" pare "+monstre.getNom()+" !");
		this.setParerElfe(getParerElfe()+1);
	}
	
	public String toString() {
		return "Nom : "+personnage_nom +" | Point de vie : "+personnage_pointVie+" | Point d'attaque : "+personnage_pointAttaque+" | Point de défense : "+personnage_pointDefense;
	}

	public int getParerElfe() {
		return parerElfe;
	}

	public void setParerElfe(int parerElfe) {
		this.parerElfe = parerElfe;
	}
}
