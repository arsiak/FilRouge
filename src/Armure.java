
public enum Armure {
	//Objets directement construits
	Casque("Casque", "Protège la tête ", 0,+5,0,0,0,0),
	Bouclier("Bouclier", "Protège des coups d'attaque ", +3,+5,0,0,0,0),
	Plastron("Plastron", "protège des coups d'épées et poignard", 0,+5,0,0,0,0),
	BouclierMagique("Bouclier Magique","Protège de la magie",0,0,0,+3,0,0);
	  
	private String name = "";
	private String description = "";
	private int rage =0;
	private int defense = 0;
	private int mana =0;
	private int resistance =0;
	private int vie=0;
	private int vitesse=0;
	  
	   
	//Constructeur
	Armure (String name, String description, int rage, int  defense, int mana, int resistance, int vie, int vitesse){
		this.name = name;
	    this.description = description;
	    this.rage = rage;
	    this.defense = defense;
	    this.mana=mana;
	    this.resistance=resistance;
	    this.vie=vie;
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
	
	void Utiliser(Perso personnage) {
		personnage.setPointRage(personnage.pointRage+rage);
		personnage.setPointDefense(personnage.pointDefense+defense);
		personnage.setPointVie(personnage.pointVie+vie);
		personnage.setPointMana(personnage.pointMana+mana);
		personnage.setPointResistance(personnage.pointResistance+resistance);
		personnage.setPointVitesse(personnage.pointVitesse+vitesse);
	}
	
	void Utiliser(Monstre monstre) {
		monstre.setPointRage(monstre.pointRage+rage);
		monstre.setPointDefense(monstre.pointDefense+defense);
		monstre.setPointVie(monstre.pointVie+vie);
		monstre.setPointMana(monstre.pointMana+mana);
		monstre.setPointResistance(monstre.pointResistance+resistance);
		monstre.setPointVitesse(monstre.pointVitesse+vitesse);
	}
	  
}
