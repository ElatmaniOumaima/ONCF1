package IHM1;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RESIZE extends JFrame{
static void setSubpanelSize(JPanel subpanel, int percentage){
    int frameWIDTH=getWidth();
    int frameHEGHT=getHeight();
    int subpanelHeight = frameHEGHT* percentage / 100;
    subpanel.setPreferredSize(new Dimension(frameWIDTH, subpanelHeight));}

}