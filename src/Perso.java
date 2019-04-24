
public class Perso {

	protected String lettre;
	protected int positionX;
	protected int positionY;
	protected String nom;
	protected int pointVie;
	protected int pointAttaque;
	protected int pointDefense;
	protected String criGuerre;
	protected Artefact[] equipement= new Artefact[3];
	public boolean armure;

	public Perso() {
		lettre = "@";
		positionX = 6;
		positionY = 8;
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.criGuerre="A l'attaque !!";
		this.equipement=null;
	}
	
	public Perso(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure) {
		this.nom=nom;
		this.lettre=lettre;
		this.positionX=positionX;
		this.positionY=positionY;
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.criGuerre="A l'attaque !!";
		this.equipement=listeArtefact;
		this.armure=armure;
	}
	
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public void mvtGauche () {
		positionY--;
	}

	public void mvtDroite () {
		positionY++;
	}
	
	public void mvtHaut () {
		positionX--;
	}
	
	public void mvtBas () {
		positionX++;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public int getPointVie() {
		return this.pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.pointVie=pointVie;
	}
	
	public int getPointAttaque() {
		return this.pointAttaque;
	}
	
	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque=pointAttaque;
	}
	
	public int getPointDefense() {
		return this.pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
		this.pointDefense=pointDefense;
	}
	
	public String getCriGuerre() {
		return criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.criGuerre=criGuerre;
	}
	
	void Attaquer(Monstre monstre) {
		System.out.println(this.nom+" attaque "+monstre.nom+" !");
		int degat;
		degat=monstre.pointVie+monstre.pointDefense-this.pointAttaque;
		if(monstre.pointDefense>this.pointAttaque) {
			degat=monstre.pointVie;
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		System.out.println(monstre.nom+" perd "+(this.pointAttaque-monstre.pointDefense)+" point(s) de vie !");
	}
	
}