package Personnages;
public class Monstre {
	String nom;
	public int pointVie;
	int pointAttaque;
	int pointDefense;
	String criGuerre;
	
	public Monstre(String nom) {
		this.nom=nom;
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.criGuerre="mlll wwouogrouroulou !!";
	}
	
	public String getNom() {
		return nom;
	}
	
	void setNom(String nom) {
		this.nom=nom;
	}
	
	Integer getPointVie() {
		return pointVie;
	}
	
	void setPointVie(int pointVie) {
		this.pointVie=pointVie;
	}
	
	Integer getPointAttaque() {
		return pointAttaque;
	}
	
	void setPointAttaque(int pointAttaque) {
		this.pointAttaque=pointAttaque;
	}
	
	Integer getPointDefense() {
		return pointDefense;
	}
	
	void setPointDefense(int pointDefense) {
		this.pointDefense=pointDefense;
	}
	
	public String getCriGuerre() {
		return criGuerre;
	}
	
	void setCriGuerre(String criGuerre) {
		this.criGuerre=criGuerre;
	}
	
	public void Attaquer(Perso personnage) {
		System.out.println(this.nom+" attaque "+personnage.nom+" !");
		int degat;
		degat=personnage.pointVie+personnage.pointDefense-this.pointAttaque;
		if(personnage.pointDefense>this.pointAttaque) {
			degat=personnage.pointVie;
		}
		if(degat<0) {
			degat=0;
		}
		personnage.setPointVie(degat);
		System.out.println(personnage.nom+" perd "+(this.pointAttaque-personnage.pointDefense)+" point(s) de vie !");
	}
	
	public String toString() {
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}
}
