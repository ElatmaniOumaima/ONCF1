package IHM1;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.Database1;

public class Reservation extends JFrame {
    // first for instanciate this class we have to declare the 2D arraylist after that we gonna define an row ARrraylist<String> row after add the row to the main data
        Reservation(String[] columnNames ,int rowCount){

            Reserver(columnNames, rowCount);

        }
        public static    DefaultTableModel Reserver(String[] columnNames ,int rowCount) {

       
        // Create table model with specified column names

        DefaultTableModel model = new DefaultTableModel(columnNames, rowCount);

        // Populate table model with data from ArrayList
       

        return model;
        //we gonna implement it in the controller part for communicate with the data base 
        

        }


    

}
