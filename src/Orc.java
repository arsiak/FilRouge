public class Orc extends Perso{
	int parerOrc;
	
	public Orc(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure) {
		super(nom, lettre, positionX, positionY, listeArtefact, armure);
		this.pointVie=90;
		this.pointAttaque=12;
		this.pointDefense=7;
		this.criGuerre="A l'attaque";
		this.parerOrc=0;
	}
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public void Parer(Monstre monstre) {
		System.out.println(this.nom+" pare "+monstre.nom+" !");
		this.parerOrc=parerOrc+1;
	}
	
	public String toString() {
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}
}
