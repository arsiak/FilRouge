package Monstres;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Objets.Objet;
import Personnages.Personnage;

public class Chamane extends Monstre{

	public Chamane(String nom, char lettre, Objet[] sac) {
		super(nom, lettre, sac);
	}
	
	public Chamane(String nom, Image image, Objet[] sac) {
		super(nom, image, sac);
	}
	
	public Chamane(String nom, char lettre, Objet[] sac,int vie, int rage, int def, int mana, int res, int vit, String cri) {
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
		int degat;
		double choix;
		
		if (personnage.getParade()) {
			this.setPointRage(this.getPointRage()/2);
			this.setPointMana(this.getPointMana()/2);
		}
		
		choix = Math.random();
		if(choix<0.5) {
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
		}
		else {
			degat=personnage.getPointVie()+personnage.getPointResistance()-this.getPointMana();
			if(personnage.getPointResistance()>this.getPointMana()) {
				degat=personnage.getPointVie();
				personnage.setPointResistance(personnage.getPointResistance()-this.getPointMana());
			}
			if(degat<0) {
				degat=0;
			}
			personnage.setPointVie(degat);
			if(this.getPointMana()-personnage.getPointResistance()>0) {
				System.out.println(personnage.getNom()+" perd "+(this.getPointMana()-personnage.getPointResistance())+" point(s) de vie !");
				personnage.setPointResistance(0);
			}
			else {
				System.out.println(personnage.getNom()+" perd " +(personnage.getPointResistance()-this.getPointMana())+" point(s) de résistance !");
			}	
		}
		if (personnage.getParade()) {
			this.setPointRage(this.getPointRage()*2);
			this.setPointMana(this.getPointMana()*2);
			personnage.setParade(false);
		}
		
	}

}
