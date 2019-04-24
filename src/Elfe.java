import java.util.ArrayList;

public class Elfe extends Perso{
	int parerElfe;
	
	public Elfe(String nom, String lettre, int positionX, int positionY, Artefact[] listeArtefact, boolean armure) {
		super(nom, lettre, positionX, positionY, listeArtefact, armure);
		this.pointAttaque=12;
		this.pointDefense=2;
		this.criGuerre="A l'attaque !!";
		this.parerElfe=0;
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
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}
}
