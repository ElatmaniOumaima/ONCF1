import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class TwoSectionFrameWithTabs1 extends JFrame {
    public TwoSectionFrameWithTabs1() {
        setTitle("Frame with Two Sections and Tabs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create panels for each section
        JPanel section1 = new JPanel();
        JPanel section2 = new JPanel(new BorderLayout());
        JPanel section3 = new JPanel();

        // Create components for section 1
        JLabel label1 = new JLabel("Section 1");
        section1.add(label1);

        // Create components for section 2
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tab1 = new JPanel(new MigLayout());
        JPanel tab2 = new JPanel();
        JPanel tab3 = new JPanel();
        tabbedPane.addTab("j'achete mon ticket", tab1);
        tabbedPane.addTab("j'utilise mon tarif réduit", tab2);
        tabbedPane.addTab("Tab 3", tab3);

        section2.add(tabbedPane, BorderLayout.CENTER);

        // Set layout for the main frame
        setLayout(new GridLayout(3, 1));
        add(section1);
        add(section2);
        add(section3);
        int height = getHeight();
        int width = getWidth();
        section1.setBackground(new Color(234, 71, 71));

        // Create a text field linked with coboxes (drop downs)
        JLabel departLabeld = new JLabel("Ma gare de départ");
        JLabel departDateLb = new JLabel("Ma date de départ");
        JLabel Vlabeld = new JLabel("Voyageurs");
        JLabel Vlabeld1 = new JLabel("Ma gare d'arrivée");
        JLabel Vlabeld2 = new JLabel("Ma date de retour");
        JLabel Vlabeld3 = new JLabel("Mon confort");

        JTextField depart = new JTextField(30);
        String[] destinations = { "A", "B", "C" };
        JComboBox<String> depart1 = new JComboBox<>(destinations);

        tab1.add(departLabeld);
        tab1.add(departDateLb);
        tab1.add(Vlabeld, "wrap");
        tab1.add(depart);
        tab1.add(depart1);
        tab1.add(Vlabeld1, "wrap");
        tab1.add(Vlabeld2);
        tab1.add(Vlabeld3);

        
       
       

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TwoSectionFrameWithTabs1 frame = new TwoSectionFrameWithTabs1();
            frame.setVisible(true);
        });
    }
}
