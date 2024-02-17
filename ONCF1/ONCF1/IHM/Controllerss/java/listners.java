package Controllerss.java;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;



import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import IHM1.*;



public class listners implements ActionListener{
    
    private JComboBox<String> comboBox;
    private JDatePanelImpl datePicker;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==comboBox ) {
             String selectedValue = (String) comboBox.getSelectedItem();
             Date selectedDate = (Date) datePicker.getModel() .getValue();
           
                // Create a new frame when the search button is clicked
                JFrame resultFrame = new JFrame("Search Results");
                JLabel label = new JLabel("Search results will be displayed here.");
                resultFrame.add(label);
                resultFrame.setSize(300, 200);
                resultFrame.setVisible(true);
            }
           
        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }}
   




    
