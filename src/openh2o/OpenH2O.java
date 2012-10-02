package openh2o;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cards.*;

/**
 *
 * @author cfviper
 */
public class OpenH2O {

    static public JFrame buildMain(){
        JFrame mainFrame = new JFrame("OpenH2O");
        mainFrame.setSize(1024, 768);
        
        
        JPanel homePanel = new JPanel(new CardLayout());
        //homePanel.setPreferredSize(new Dimension(800, 600));
        homePanel.add("nodeProperties", NodeProperties.buildNodePropWindow());
        homePanel.add("nodeProperties", PipeProperties.buildPropertiesWindow());
        
        homePanel.repaint();       
        
        //** attach panel(s) to main fram  and make visible**//
        mainFrame.add(homePanel);
        mainFrame.setVisible(true);
        mainFrame.pack();
        
        return mainFrame;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        buildMain();
    }
}
