import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reservation extends JFrame {
    // first for instanciate this class we have to declare the 2D arraylist after that we gonna define an row ARrraylist<String> row after add the row to the main data
    
        public static JTable Reserver(ArrayList<ArrayList<String>> Data_Table) {
        // Create column names
        String[] columnNames = {"Date départ", "Date arrivée", "Gare départ", "Gare d'arrivée",
                                "Classe", "Voyageurs", "Prix", "Prix après réduction"};

        // Create table model with specified column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate table model with data from ArrayList
        for (ArrayList<String> rowData : Data_Table) {
            model.addRow(rowData.toArray());
        }
        JTable table = new JTable(model);

        return table;
        //we gonna implement it in the controller part for communicate with the data base 
        

        }


    

}
