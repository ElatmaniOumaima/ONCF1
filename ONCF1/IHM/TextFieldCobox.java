import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.*;

public class TextFieldCobox extends JFrame {
    public JTextField textField;
    public JComboBox<String> comboBox;

    public TextFieldCobox(JPanel p,String[] villes,String statut) {
       
       
       

        // Create a text field
        textField = new JTextField(20);

        // Create a combo box
        
        JComboBox<String> comboBox = new JComboBox<>(villes);

        // Add components to the panel
        //p.add(textField);
        p.add(comboBox,statut);

       
        
    }


}
