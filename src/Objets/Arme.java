package Objets;
import Personnages.Personnage;
import Monstres.Monstre;


public abstract class Arme extends Objet {
	
	protected String objet_nom;
	protected String objet_description;
	protected String objet_type = "Arme";
	protected int objet_rage, objet_mana;
	
	//Constructeur
	public Arme() {
		
	}
	
	
	public Arme (String nom, String description, int rage, int mana) {
		objet_nom = nom;
		objet_description = description;
		objet_rage = rage;
		objet_mana = mana;
	}	
	
	/*
	Epee("Epee", "Améliore ton attaque ", +3,0,0,0,0,0),
	GrandeEpee("GrandeEpee", "Améliore ton attaque ", +3,0,0,0,0,0),
	Marteau("Marteau", "Détruit la défense de l'adveraire ", +10,+5,0,0,0,0),
	Poignard ("Poignard", "Assène un coup fatal ", +5,0,0,0,0,0),
	Arc("Arc", "Il permet d'atteindre des cibles lointaines, penser à avoir beaucoups de flèches ", +10,+3,0,0,0,0),
	Sceptre("Sceptre", "Permet de lancer des sorts", 0,0,+5,0,0,0),
	Bombe("Bombe", "Aveugle l'adversaire", +10,5,0,0,0,0),
	Potion("Potion", "Accélère la guérison ", +10,0,0,0,0,0);
	*/
	
	public String getNom() {
		// TODO Auto-generated method stub
		return objet_nom;
	}
	
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		objet_nom=nom;
	}
	
	public String getType() {
		return objet_type;
	}
	
	public String getPresentationMenu(){
		return (objet_nom+ " Rage " +objet_rage+ " Mana " +objet_mana);
	}
	  
	public String getDescription(){
		return objet_description;
	}
	
	public int getAttaque(){
		return objet_rage; 
	}
	  
	public int getMagie() {
		return objet_mana;
	}
	
	public void utiliser(Personnage personnage) {
		super.utiliser(personnage); 
		personnage.setPointRage(personnage.getPointRage() + objet_rage);
		personnage.setPointMana(personnage.getPointMana() + objet_mana);
	}
	
	public void desutiliser(Personnage personnage) {
		super.utiliser(personnage); 
		personnage.setPointRage(personnage.getPointRage() - objet_rage);
		personnage.setPointMana(personnage.getPointMana() - objet_mana);
	}
	
	public void utiliser(Monstre monstre) {
		super.utiliser(monstre);
		monstre.setPointRage(monstre.getPointRage() + objet_rage);
		monstre.setPointMana(monstre.getPointMana() + objet_mana);
	}
	  
}
