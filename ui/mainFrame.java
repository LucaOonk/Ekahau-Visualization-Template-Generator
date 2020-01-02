package ui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import visualization.visualization;

public class mainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JFrame mainFrame;
    private visualizationCreator creator;
    private visualization result;

    public void init() {

        this.creator = new visualizationCreator();
        this.mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setTitle("Ekahau Template Generator");
        mainFrame.setSize(new Dimension(1100, 400));
        
        packContent(mainFrame);
        pack();
        mainFrame.setVisible(true);

    }

    public void packContent(JFrame mainFrame) {

        JPanel container = new JPanel();
        container.add(creator.createJPanel());

        mainFrame.getContentPane().add(container);;

    }
    
}