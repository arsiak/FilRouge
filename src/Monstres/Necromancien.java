package Monstres;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Objets.Objet;
import Personnages.Personnage;

public class Necromancien extends Monstre{
	
	public Necromancien(String nom, char lettre, Objet[] sac) {
		super(nom, lettre, sac);
		this.monstre_pointRage=0;
		monstre_pointVie=70;
	}
	
	public Necromancien(String nom, Image image, Objet[] sac) {
		super(nom, image, sac);
		this.monstre_pointRage=0;
		monstre_pointVie=70;
	}
	
	public Necromancien(String nom, char lettre, Objet[] sac,int vie, int rage, int def, int mana, int res, int vit, String cri) {
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
		
		if (personnage.getParade()) this.setPointMana(this.getPointMana()/2);
		
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
		if (personnage.getParade()) {
			this.setPointMana(this.getPointMana()*2);
			personnage.setParade(false);
		}
	}

}
