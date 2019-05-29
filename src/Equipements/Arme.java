package Equipements;
import Personnages.Personnage;
import Monstres.Monstre;


public enum Arme {
	//Objets directement construits
	Epee("Epee", "Améliore ton attaque ", +3,0,0,0,0,0),
	GrandeEpee("GrandeEpee", "Améliore ton attaque ", +3,0,0,0,0,0),
	Marteau("Marteau", "Détruit la défense de l'adveraire ", +10,+5,0,0,0,0),
	Poignard ("Poignard", "Assène un coup fatal ", +5,0,0,0,0,0),
	Arc("Arc", "Il permet d'atteindre des cibles lointaines, penser à avoir beaucoups de flèches ", +10,+3,0,0,0,0),
	Sceptre("Sceptre", "Permet de lancer des sorts", 0,0,+5,0,0,0),
	Bombe("Bombe", "Aveugle l'adversaire", +10,5,0,0,0,0),
	Potion("Potion", "Accélère la guérison ", +10,0,0,0,0,0);
	
	private String name;
	private String description;
	private int rage;
	private int defense;
	private int mana;
	private int resistance;
	private int vie;
	private int vitesse;
	  
	   
	//Constructeur
	Arme (String name, String description, int rage, int  defense, int mana, int resistance, int vie, int vitesse){
		this.name = name;
	    this.description = description;
	    this.rage = rage;
	    this.defense = defense;
	    this.mana=mana;
	    this.resistance=resistance;
	    this.vie=vie;
	    this.vitesse=vitesse;
	}
	   
	public void getDescription(){
		System.out.println("Editeur : " + description);
	}
	   
	public String toString(){
	    return name;
	}
	  
	public int getAttaque(){
		return rage; 
	}
	  
	public int getDefense(){
		return defense;
	}
	  
	public int getMagie() {
		return mana;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public int getVie() {
		return vie;
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	public void Utiliser(Personnage personnage) {
		personnage.setPointRage(personnage.getPointRage()+rage);
		personnage.setPointDefense(personnage.getPointDefense()+defense);
		personnage.setPointVie(personnage.getPointVie()+vie);
		personnage.setPointMana(personnage.getPointMana()+mana);
		personnage.setPointResistance(personnage.getPointResistance()+resistance);
		personnage.setPointVitesse(personnage.getPointVitesse()+vitesse);
	}
	
	public void Utiliser(Monstre monstre) {
		monstre.setPointRage(monstre.getPointRage()+rage);
		monstre.setPointDefense(monstre.getPointDefense()+defense);
		monstre.setPointVie(monstre.getPointVie()+vie);
		monstre.setPointMana(monstre.getPointMana()+mana);
		monstre.setPointResistance(monstre.getPointResistance()+resistance);
		monstre.setPointVitesse(monstre.getPointVitesse()+vitesse);
	}
	  
}
