package Personnages;
import Cartes.Coord;
import Equipements.Equipement;
import Equipements.Objet;
import Quetes.Pnj;

public class Personnage {
	
	protected String personnage_nom;
	protected Coord personnage_coord;
	protected int personnage_pointVie;
	protected int personnage_pointAttaque;
	protected int personnage_pointDefense;
	protected String personnage_criGuerre;
	protected Boolean personnage_pnjTrouve;
	private Objet[] equipements= new Objet[3];
	public boolean armure;

	public Personnage() {
		// lettre = "@";
		this.personnage_pointVie=100;
		this.personnage_pointAttaque=10;
		this.personnage_pointDefense=5;
		this.personnage_criGuerre="A l'attaque !!";
		this.setEquipement(null);
	}
	
	public Personnage(Coord coord) {
		this.personnage_coord=coord;
	}
	
	public Personnage(String nom,Coord coord, Equipement[] listeEquipement, boolean armure) {
		this.personnage_nom=nom;
		//this.lettre=lettre;
		this.personnage_coord=coord;
		this.personnage_pointVie=100;
		this.personnage_pointAttaque=10;
		this.personnage_pointDefense=5;
		this.personnage_criGuerre="A l'attaque !!";
		this.setEquipement(listeEquipement);
		this.armure=armure;
	}

	public Coord getCoord() {
		return personnage_coord;
	}

	public void setCoord(Coord coord) {
		this.personnage_coord = coord;
	}
	
	public Boolean getPnjTrouve() {
		return personnage_pnjTrouve;
	}

	public void setPnjTrouve(Boolean pnjTrouve) {
		this.personnage_pnjTrouve = pnjTrouve;
	}
	
	public void mvtGauche () {
		personnage_coord.setX(-1);
	}

	public void mvtDroite () {
		personnage_coord.setX(1);
	}
	
	public void mvtHaut () {
		personnage_coord.setY(-1);;
	}
	
	public void mvtBas () {
		personnage_coord.setY(1);
	}
	
	public String getNom() {
		return this.personnage_nom;
	}
	
	public void setNom(String nom) {
		this.personnage_nom=nom;
	}
	
	public int getPointVie() {
		return this.personnage_pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.personnage_pointVie=pointVie;
	}
	
	public int getPointAttaque() {
		return this.personnage_pointAttaque;
	}
	
	public void setPointAttaque(int pointAttaque) {
		this.personnage_pointAttaque=pointAttaque;
	}
	
	public int getPointDefense() {
		return this.personnage_pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
		this.personnage_pointDefense=pointDefense;
	}
	
	public String getCriGuerre() {
		return personnage_criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.personnage_criGuerre=criGuerre;
	}
	
	public void attaquer(Monstre monstre) {
		System.out.println(this.personnage_nom+" attaque "+monstre.getNom()+" !");
		int degat;
		degat=monstre.getPointVie()+monstre.getPointDefense()-this.personnage_pointAttaque;
		if(monstre.getPointDefense()>this.personnage_pointAttaque) {
			degat=monstre.getPointVie();
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		System.out.println(monstre.getNom()+" perd "+(this.personnage_pointAttaque-monstre.getPointDefense())+" point(s) de vie !");
	}

	public Objet[] getEquipement() {
		return equipements;
	}
	
	public void ajouterEquipement(Objet equipement) {
		
		for (int i=0; i<equipements.length; i++) {
			
			if (equipements[i] == null) {
				equipements[i] = equipement;
			}
		}
	}
	
	public Boolean verifieEquipement(Objet objet) {
		
		for (int i=0; i<equipements.length; i++) {
			if (equipements[i].objet_id.equals(objet.objet_id)) {
				//equipement_id.equals)
				return true;
			}
		}
		return false;
	}
	
	public Boolean verifiePnjTrouve() {
		
		if(personnage_pnjTrouve) {
			return true;
		}
		return false;
		
	}

	public void setEquipement(Equipement[] equipements) {
		this.equipements = equipements;
	}

	public Coord getPosition() {
		// TODO Auto-generated method stub
		return this.personnage_coord;
	}

	
}