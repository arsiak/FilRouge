package Bdd;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Cartes.Carte;
import Cartes.CarteDonjon;
import Cartes.CarteMonde;
import Cartes.CarteVillage;
import Cartes.Coord;
import Personnages.Personnage;

public class ChargementParam {
	
	Connection co;
	Statement state;
	
	public ChargementParam() {
		
		try {
			//Class.forName("org.apache.commons.dbcp2.BasicDataSource");
			
			String url = "jdbc:mysql://localhost/filrouge?serverTimezone=UTC";
			String user = "root";
			String password = "batrix08mysql";
			
			co = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public String getPseudo() {
		String pseudo = "bat";
		return pseudo;
	}
	
	public String getPassword() {
		String password = "test";
		return password;
		
	}
		
	public Coord getCoordPerso() {
		
		Coord coordPerso = new Coord(0,0);
		
		try {
			
			state = co.createStatement();
			
			ResultSet resultatX = state.executeQuery("select coordX from perso ");
			while (resultatX.next()) {
				coordPerso.setX(resultatX.getInt("coordX"));
			}
			resultatX.close();
				
			ResultSet resultatY = state.executeQuery("select coordY from perso ");
			while (resultatY.next()) {
				coordPerso.setY(resultatY.getInt("coordY"));
			}
			resultatY.close();
				
			coordPerso=new Coord(coordPerso.getX(), coordPerso.getY());
			
			state.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return coordPerso;
	}
	
	public void saveCoordPerso(Personnage perso) {
		
		try {
			
			state = co.createStatement();
			
			state.executeUpdate("update perso SET coordX = " +perso.getCoord().getX());
				
			state.executeUpdate("update perso SET coordY = " +perso.getCoord().getY());

			state.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Carte getCoordCarte() {
		
		Carte carte = new Carte();
		String nomCarte = "";
		
		try {
			
			state = co.createStatement();
			
			ResultSet resultat = state.executeQuery("select coordCarte from perso ");
			while (resultat.next()) {
				nomCarte = resultat.getString("coordCarte");
			}
			
			if (nomCarte.equals("Village")) {
				carte = new CarteVillage();
			}
			else if (nomCarte.equals("Monde")) {
				carte = new CarteMonde();
				
			}
			else {
				for (int i=1; i<13; i++) {
					if (nomCarte.equals("Donjon"+i)) {
						carte = new CarteDonjon(i);
					}
				}
			}
				
			resultat.close();
			
			state.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return carte;
	}
	
	public void saveCoordCarte(Carte carte) {
		
		try {
			
			state = co.createStatement();
			
			state.executeUpdate("update perso SET coordCarte = " + "'" +carte.getCarte_nom()+ "'");

			state.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
