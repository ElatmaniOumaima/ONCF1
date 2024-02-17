package Database;
import java.sql.*;


public class Database{
	

		public void query(String q) throws SQLException {

			// **Étape 1 : Charger la classe du driver**
	
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver PostgreSQL non trouvé : " + e.getMessage());
				return;
			}
	
			// **Étape 2 : Créer l'objet de connexion**
	
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres",
					"postgres",
					"admin"
				);
			} catch (SQLException e) {
				System.out.println("Échec de la connexion à la base de données : " + e.getMessage());
				return;
			}
	
			// **Étape 3 : Créer l'objet Statement**
	
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				System.out.println("Échec de la création de l'objet Statement : " + e.getMessage());
				return;
			}
	
			// **Étape 4 : Exécuter la requête**
	
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(q);
			} catch (SQLException e) {
				System.out.println("Échec de l'exécution de la requête : " + e.getMessage());
				return;
			}
			//get the number of rows 
			rs.last();

            // Get the row count
            int rowCount = rs.getRow();
			
               
            
	
			// **Étape 5 : Parcourir les résultats**
	
			try {
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}
			} catch (SQLException e) {
				System.out.println("Échec de la lecture des résultats : " + e.getMessage());
			}
	
			// **Étape 6 : Fermer l'objet de connexion**
	
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Échec de la fermeture de la connexion : " + e.getMessage());
			}
	

        // **Étape 6 : Fermer l'objet de connexion**

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Échec de la fermeture de la connexion : " + e.getMessage());
        }


}}