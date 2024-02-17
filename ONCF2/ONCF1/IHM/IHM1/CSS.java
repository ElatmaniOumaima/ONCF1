package IHM1;
import com.formdev.flatlaf.*;
import javax.swing.*;
import java.awt.*;
public class CSS {

    public static void setFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            // Customize FlatLaf settings here
            customizeFlatLaf();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static void customizeFlatLaf() {
        // Customize FlatLaf properties here
        UIManager.put("TextFieldCobox.arrowType", "triangle");
        UIManager.put("DatePicker.weekPanelHeight", 30);
        UIManager.put("DatePicker.background", Color.black);
        UIManager.put( "Component.focusWidth", 1 );
        UIManager.put( "tabbedPane.selectedBackground", Color.RED );
        
        // Add more customization as needed
    }
}