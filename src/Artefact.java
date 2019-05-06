
public class Artefact {
	public String identifiant;
	public int attaque;
	public int defense;
	public int sante;
	public int magie;
	public int resistance;
	public int vitesse;
	
	public Artefact(String identifiant) {
		this.identifiant=identifiant;
		this.attaque=0;
		this.defense=0;
		this.sante=0;
		this.magie=0;
		this.vitesse=0;
	}
	
	int getAttaque() {
		return attaque;
	}
	
	void setAttaque(int attaque) {
		this.attaque=attaque;
	}
	
	int getDefense() {
		return defense;
	}
	
	void setDefense(int defense) {
		this.defense=defense;
	}
	
	int getSante() {
		return sante;
	}
	
	void setSante(int sante) {
		this.sante=sante;
	}
	
	int getMagie() {
		return magie;
	}
	
	void setMagie(int magie) {
		this.magie=magie;
	}
	
	int getResistance() {
		return resistance;
	}
	
	void setResistance(int resistance) {
		this.resistance=resistance;
	}
	
	int getVitesse() {
		return vitesse;
	}
	
	void setVitesse(int vitesse) {
		this.vitesse=vitesse;
	}
	
	void Utiliser(Perso personnage) {
		if(personnage instanceof Humain) {
			if(attaque>0) {
				personnage.setPointAttaque(personnage.pointAttaque+attaque+1);
			}
			if(defense>0) {
				personnage.setPointDefense(personnage.pointDefense+defense+1);
			}
			if(sante>0) {
				personnage.setPointVie(personnage.pointVie+sante+1);
			}
			if(magie>0) {
				personnage.setPointMagie(personnage.pointMagie+magie+1);
			}
			if(resistance>0) {
				personnage.setPointResistance(personnage.pointResistance+resistance+1);
			}
			if(vitesse>0) {
				personnage.setPointVitesse(personnage.pointVitesse+vitesse+1);
			}
		}
		else{personnage.setPointAttaque(personnage.pointAttaque+attaque);
		personnage.setPointDefense(personnage.pointDefense+defense);
		personnage.setPointVie(personnage.pointVie+sante);
		personnage.setPointMagie(personnage.pointMagie+magie);
		personnage.setPointResistance(personnage.pointResistance+resistance);
		personnage.setPointVitesse(personnage.pointVitesse+vitesse);
		}
	}
	
	void Utiliser(Monstre monstre) {
		monstre.setPointAttaque(monstre.pointAttaque+attaque);
		monstre.setPointDefense(monstre.pointDefense+defense);
		monstre.setPointVie(monstre.pointVie+sante);
		monstre.setPointMagie(monstre.pointMagie+magie);
		monstre.setPointResistance(monstre.pointResistance+resistance);
		monstre.setPointVitesse(monstre.pointVitesse+vitesse);
	}
}
