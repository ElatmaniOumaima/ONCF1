package Database;

import java.sql.*;
import java.util.ArrayList;

public class Database1 {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    

    public Database1(String q) {
        Driver();
        connection();
        createStatement();
        queryy(q);
    }

    public void Driver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL non trouvé : " + e.getMessage());
        }
    }

    public void connection() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ONCF",
                "postgres",
                "admin"
            );
        } catch (SQLException e) {
            System.out.println("Échec de la connexion à la base de données : " + e.getMessage());
        }
    }

    public void createStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Échec de la création de l'objet Statement : " + e.getMessage());
        }
    }

    public ResultSet queryy(String q) {
        try {
            rs = stmt.executeQuery(q);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " | ");
            }
            System.out.println();

            // Print each row's data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if(i==1 || i==8 ||i==9){
                        String valueAsString = String.valueOf(rs.getDouble(i));
                        System.out.print(valueAsString + " | ");

                    }
                    
                    System.out.print(rs.getString(i) + " | ");
                }
               
               
            }
            
        } catch (SQLException e) {
            System.out.println("Échec de l'exécution de la requête : " + e.getMessage());
        } finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Échec de la fermeture des ressources : " + e.getMessage());
            }
        }
        return rs;
    }

    @Override
    public String toString() {
        return "Database1";
    }

    public static void main(String[] args) {
        new Database1("SELECT * FROM ticket");
    }

    public int CountRow(String q) throws SQLException{
        queryy(q);
        rs.last();

            // Get the row count
        int rowCount = rs.getRow();
        return rowCount;


    }

    public char[] getString(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getString'");
    }
    
}