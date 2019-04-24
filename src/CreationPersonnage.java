import java.util.Scanner;

public class CreationPersonnage {
	
	public void CreerPersonnage() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String typePerso;
		System.out.println("Bienvenue dansle créateur de personnage !");
		System.out.println("Sélectionnez la race que vous souhaitez (Humain / Orc / Elfe) : ");
		typePerso=sc.nextLine();
		
		FactoryPersonnage factory=new FactoryPersonnage();
		Perso perso=factory.getPerso(typePerso);
	}
}
