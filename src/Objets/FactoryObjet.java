package Objets;

import java.util.ArrayList;

import Objets.Objet;

public class FactoryObjet {
	
	ArrayList<Objet> listeObjet;
	
	public FactoryObjet() {
		
		listeObjet = new ArrayList<Objet>();
		listeObjet.add(new Amulette());
		listeObjet.add(new Arc());
		listeObjet.add(new Epee());
		listeObjet.add(new GrandeEpee());
		listeObjet.add(new Marteau());
		listeObjet.add(new Bouclier());
		listeObjet.add(new BouclierMagique());
		listeObjet.add(new Casque());
		listeObjet.add(new PotionVie());
		listeObjet.add(new PotionRage());
		listeObjet.add(new PotionMana());
		listeObjet.add(new PotionDefense());
		listeObjet.add(new PotionResistance());
		listeObjet.add(new PotionVitesse());
		
	}
	
	public Objet getObjet() {
		
		int randomObjet = (int)(Math.random()*(listeObjet.size()-1));
		
		return listeObjet.get(randomObjet);
	}
	
	public Objet[] getObjets() {
		
		int randomNombre = (int)(Math.random()*3);
		
		Objet[] objets = new Objet[randomNombre];
		for (int i=0; i<randomNombre; i++) {
			objets[i] = this.getObjet();
		}
		
		return objets;
	}

}