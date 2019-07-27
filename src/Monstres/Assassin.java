package Monstres;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Objets.Objet;
import Personnages.Personnage;

public class Assassin extends Monstre {
	
	public Assassin(String nom, char lettre, Objet[] sac) {
		super(nom, lettre, sac);
		this.monstre_pointMana=0;
	}
	
	public Assassin(String nom, Image image, Objet[] sac) {
		super(nom, image, sac);
		this.monstre_pointMana=0;
	}
	
	public Assassin(String nom, char lettre, Objet[] sac,int vie, int rage, int def, int mana, int res, int vit, String cri) {
		this.monstre_nom=nom;
		this.monstre_image=this.getImage();
		this.monstre_lettre=lettre;
		this.monstre_pointVie=vie;
		this.monstre_pointRage=rage;
		this.monstre_pointDefense=def;
		this.monstre_pointMana=mana;
		this.monstre_pointResistance=res;
		this.monstre_pointVitesse=vit;
		this.monstre_criGuerre=cri;
		this.monstre_sac=sac;
		this.setEstVivant(true);
	}
	
	public Image getImage() {
		try {
			monstre_image = ImageIO.read(new File("Ressources/Images/" +this.getClass().getSimpleName()+ "Face.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monstre_image;
	}

	public void attaquer(Personnage personnage) {
		
		System.out.println(this.getNom()+" attaque "+personnage.getNom()+" !");
		
		if (personnage.getParade()) this.setPointRage(this.getPointRage()/2);
		int degat;
		degat=personnage.getPointVie()+personnage.getPointDefense()-this.getPointRage();
		if(personnage.getPointDefense()>this.getPointRage()) {
			degat=personnage.getPointVie();
			personnage.setPointDefense(personnage.getPointResistance()-this.getPointRage());
		}
		if(degat<0) {
			degat=0;
		}
		personnage.setPointVie(degat);
		if(this.getPointRage()-personnage.getPointDefense()>0) {
			System.out.println(personnage.getNom()+" perd "+(this.getPointRage()-personnage.getPointDefense())+" point(s) de vie !");
			personnage.setPointDefense(0);
		}
		else {
			System.out.println(personnage.getNom()+" perd " +(personnage.getPointDefense()-this.getPointRage())+" point(s) de défense !");
		}	
		if (personnage.getParade()) {
			personnage.setParade(false);
			this.setPointRage(this.getPointRage()*2);
		}
	}

}
