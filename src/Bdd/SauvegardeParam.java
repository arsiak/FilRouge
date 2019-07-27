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

public class SauvegardeParam {
	
	Connection co;
	Statement state;
	
	public SauvegardeParam() {
		
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
