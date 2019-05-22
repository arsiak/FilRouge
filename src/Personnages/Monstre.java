package Personnages;
public class Monstre {
	String monstre_nom;
	public int monstre_pointVie;
	int monstre_pointAttaque;
	int monstre_pointDefense;
	String monstre_criGuerre;

	public Monstre(String nom) {
		this.monstre_nom=nom;
		this.monstre_pointVie=100;
		this.monstre_pointAttaque=10;
		this.monstre_pointDefense=5;
		this.monstre_criGuerre="mlll wwouogrouroulou !!";
	}

	public String getNom() {
		return monstre_nom;
	}

	public void setNom(String nom) {
		this.monstre_nom=nom;
	}

	public int getPointVie() {
		return monstre_pointVie;
	}

	public void setPointVie(int pointVie) {
		this.monstre_pointVie=pointVie;
	}

	public int getPointAttaque() {
		return monstre_pointAttaque;
	}

	public void setPointAttaque(int pointAttaque) {
		this.monstre_pointAttaque=pointAttaque;
	}

	public int getPointDefense() {
		return monstre_pointDefense;
	}

	public void setPointDefense(int pointDefense) {
		this.monstre_pointDefense=pointDefense;
	}

	public String getCriGuerre() {
		return monstre_criGuerre;
	}

	public void setCriGuerre(String criGuerre) {
		this.monstre_criGuerre=criGuerre;
	}

	public void attaquer(Personnage personnage) {
		System.out.println(this.monstre_nom+" attaque "+personnage.getNom()+" !");
		int degat;
		degat=personnage.personnage_pointVie+personnage.personnage_pointDefense-this.monstre_pointAttaque;
		if(personnage.personnage_pointDefense>this.monstre_pointAttaque) {
			degat=personnage.personnage_pointVie;
		}
		if(degat<0) {
			degat=0;
		}
		personnage.setPointVie(degat);
		System.out.println(personnage.getNom()+" perd "+(this.monstre_pointAttaque-personnage.personnage_pointDefense)+" point(s) de vie !");
	}

	public String toString() {
		return "Nom : "+monstre_nom +" | Point de vie : "+monstre_pointVie+" | Point d'attaque : "+monstre_pointAttaque+" | Point de défense : "+monstre_pointDefense;
	}
}
