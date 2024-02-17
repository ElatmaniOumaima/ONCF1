package IHM1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.Database1;

public class Ticket extends JFrame {
    ArrayList<String[]> rows = new ArrayList<>();
    Database1 table = new Database1("SELECT * FROM ticket");

    public Ticket() {
    }

    public void fetchTicketData() {
        try {
            // Fetch rows from the ResultSet
            ResultSet rs = table.queryy("SELECT * FROM ticket");
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String dateDepart = rs.getString("date_depart");
                String dateArrivee = rs.getString("date_arrivee");
                String gareDepart = rs.getString("gare_depart");
                String gareArrivee = rs.getString("gare_arrivee");
                String classe = rs.getString("classe");
                String voyageur = rs.getString("voyageur");
                String prix = String.valueOf(rs.getDouble("prix"));
                String prixApresReduction = String.valueOf(rs.getDouble("prix_apres_reduction"));

                // Add fetched data to an array and then add this array to the ArrayList
                String[] rowData = {id, dateDepart, dateArrivee, gareDepart, gareArrivee, classe, voyageur, prix,
                        prixApresReduction};
                rows.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JTable createTicketTable() {
        // Fetch ticket data from the database
        fetchTicketData();
        
        // Column names
        String[] columnNames = {"id", "dateDepart", "dateArrivee", "gareDepart", "gareArrivee", "classe", "voyageur",
                "prix", "prixApresReduction"};

        // Create JTable with data and column names
        JTable ticketTable = new JTable(rows.toArray(new String[0][]), columnNames);

        // Return the created JTable
        return ticketTable;
    }

    public void displayTicketTable() {
        // Create JTable
        JTable ticketTable = createTicketTable();

        // Add JTable to JFrame
        JScrollPane scrollPane = new JScrollPane(ticketTable);
        this.add(scrollPane);
        
        // Set JFrame properties
        this.setTitle("Ticket Information");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Database1 t=new Database1("SELECT * FROM ticket");
        
    }
}
