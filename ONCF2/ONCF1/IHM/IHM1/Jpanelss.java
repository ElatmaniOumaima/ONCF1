package IHM1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import Controllerss.*;
import Controllerss.java.listners;

import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class Jpanelss extends JFrame {
    String[] villesD={"casablanca","tanger","Rabat"};
    String[] genre={"Adulte","Enfant","Adulte et Enfant","Adulte et 2Enfants","Adulte et 3Enfants","2Adultes","3Adultes","4Adultes","2Adultes et Enfant","2Adulte et 2Enfants","2Adultes et 3Enfants"};
    String[] classe={"1ere classe","2eme classe","lit single"};
    String[] tarif={"Etudiant","Professeur","Promo"};
    public Jpanelss(){
         String[] vide={};
        setTitle("ONCF VOYAGES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create panels for each section
        JPanel section1 = new JPanel(new BorderLayout());
        JPanel section2 = new JPanel(new BorderLayout());
        section2.setBackground(new Color(234, 71, 71));
        JPanel section3 = new JPanel();
        setLayout(new GridLayout(3, 1));
        add(section1);
        add(section2);
        add(section3);
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tab1 = new JPanel(new MigLayout());
        JPanel tab2 = new JPanel(new MigLayout());
        tab1.setBackground(new Color(230,207,241));
        tab2.setBackground(new Color(230,207,241));
        tabbedPane.setBackground(Color.RED);
        ImageIcon image=new ImageIcon("oncf.png");
        JLabel    image1=new JLabel(image);
        section1.add(image1,BorderLayout.WEST);
       
        
        tabbedPane.addTab("j'achete mon ticket", tab1);
        tabbedPane.addTab("j'utilise mon tarif réduit", tab2);
        section2.add(tabbedPane, BorderLayout.CENTER);
        Contain(tab1);
        Contain(tab2);
        new Jlabelss(tab2,"Mon tarif","width 300:300:300, height 30:30:30");
        new Jlabelss(tab2,"Mon code d'adhérent","width 300:300:300, height 30:30:30");
        new Jlabelss(tab2,"Rechercher","width 300:300:300, height 30:30:30,wrap");
        new Jlabelss(tab1,"","width 300:300:300, height 30:30:30");
        JButton search1=new JButton("Rchercher");
        tab1.add(search1,"width 300:300:300, height 30:30:30");
        search1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new frame when the search button is clicked
                new MainFrame1();
            }
        });
        new Jlabelss(tab1,"","width 300:300:300, height 30:30:30");
        
        
        new TextFieldCobox(tab2, tarif,"width 300:300:300,height 30:30:30");
        JPasswordField pass=new JPasswordField(50);
        tab2.add(pass,"width 300:300:300,height 30:30:30");
        
     
        JButton search=new JButton("RECHERCHER");
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new frame when the search button is clicked
               new MainFrame();
            }
        });
        tab2.add(search,"width 300:300:300, height 30:30:30");

      
        section1.setBackground(new Color(234, 71, 71));
        //section1.setBackground(new Color(234, 71, 71));
        section3.setBackground(new Color(234, 71, 71));
        pack();
        
        
    }
    private void Contain(JPanel tab1){
        new Jlabelss(tab1,"Gare de départ","width 300:300:300, height 30:30:30");
        new Jlabelss(tab1,"Date de départ","width 300:300:300, height 30:30:30");
        new Jlabelss(tab1,"Voyageurs","width 400:300:300, height 30:30:30,wrap");
        new TextFieldCobox(tab1, villesD,"width 300:300:300, height 30:30:30");
        
        new DatePicker(tab1,"width 300:300:300, height 30:30:30");
        new TextFieldCobox(tab1, genre,"wrap");

        
        new Jlabelss(tab1,"Gare d'arrivée","width 300:300:300, height 30:30:30");
        new Jlabelss(tab1,"Date de retour","width 300:300:300, height 30:30:30");
        new Jlabelss(tab1,"Mon confort","width 300:300:300, height 30:30:30,wrap");
        new TextFieldCobox(tab1, villesD,"width 300:300:300, height 30:30:30");
        
        new DatePicker(tab1,"width 300:300:300, height 30:30:30");
        new TextFieldCobox(tab1, classe,"width 300:300:300,height 30:30:30,wrap");
        

    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CSS.setFlatLaf();
            Jpanelss frame = new Jpanelss();
            frame.setVisible(true);
        });
    }


}
