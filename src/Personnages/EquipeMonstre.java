package Personnages;
import java.util.ArrayList;

public class EquipeMonstre {
	private String equipeMonstre_nom;
	private ArrayList<Monstre> equipeMonstre_listeMonstre=new ArrayList<Monstre>();
	private int equipeMonstre_pointVieGlobal;

	public EquipeMonstre() {
		this.setNom("L'équipe de monstre");
	}

	public int CalculerPointVieGlobal() {
		setPointVieGlobal(0);
		for(int i=0; i<getListeMonstre().size(); i++) {
			setPointVieGlobal(getPointVieGlobal()+getListeMonstre().get(i).getPointVie());
		}
		return getPointVieGlobal();

	}

	public ArrayList<Monstre> getListeMonstre() {
		return equipeMonstre_listeMonstre;
	}

	public void setListeMonstre(ArrayList<Monstre> listeMonstre) {
		this.equipeMonstre_listeMonstre = listeMonstre;
	}

	public int getPointVieGlobal() {
		return equipeMonstre_pointVieGlobal;
	}

	public void setPointVieGlobal(int pointVieGlobal) {
		this.equipeMonstre_pointVieGlobal = pointVieGlobal;
	}

	public String getNom() {
		return equipeMonstre_nom;
	}

	public void setNom(String nom) {
		this.equipeMonstre_nom = nom;
	}
}
