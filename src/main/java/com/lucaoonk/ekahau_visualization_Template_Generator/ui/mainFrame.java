package com.lucaoonk.ekahau_visualization_Template_Generator.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lucaoonk.ekahau_visualization_Template_Generator.visualization.visualization;

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
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }

    public void packContent(JFrame mainFrame) {

        JPanel container = new JPanel();
        container.add(creator.createJPanel());

        mainFrame.getContentPane().add(container);;

    }
    
}