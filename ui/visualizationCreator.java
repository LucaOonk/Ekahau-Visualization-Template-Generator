package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import visualization.visualization;
import visualization.visualizationTypes;
import visualization.heatmap.heatmap;
import visualization.heatmap.heatmapOptions;
import visualization.heatmap.heatmap.HeatmapTypes;
import visualization.visualization.sizeOptions;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class visualizationCreator extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JButton applyButton;
    private visualization result;
    private JComboBox comboBoxHeatmap;
    private JComboBox comboBoxHeatmapType;
    private JCheckBox checkBoxWalls;
    private JTextArea textArea;
    private JCheckBox checkBoxLegend;
    private JCheckBox checkBoxStatistics;
    private JComboBox apBands;
    private JComboBox showAPS;
    private JTextField visualizationWidthInput;
    private JTextField legendWidthInput;
    private JTextField statisticsWidthInput;

    public Component createJPanel() {

       
        this.result = new visualization();
        this.textArea = setTextArea();
        content();
      
        return this;
    }

    /*****
    * All the Content needed for the panel
    ******/
    
    
    private JCheckBox checkBoxWalls() {

        final JCheckBox c1 = new JCheckBox("Show Walls");
        this.checkBoxWalls = c1;

        return c1;
    }

    private JCheckBox checkBoxLegend() {

        final JCheckBox c1 = new JCheckBox("Show Legend");
        this.checkBoxLegend = c1;

        return c1;
    }

    private JCheckBox checkBoxStatistics() {

        final JCheckBox c1 = new JCheckBox("Show Statistics");
        this.checkBoxStatistics = c1;

        return c1;
    }

    private JTextArea setTextArea(){

        final JTextArea c1 = new JTextArea();
        c1.setText(this.result.getVisualization());
        c1.setPreferredSize(new Dimension(400, 150));
        c1.setLineWrap(true);

        return c1;

    }

    private JComboBox comboBoxHeatmap() {

        final String[] options = new heatmap().values;
        final JComboBox c1 = new JComboBox<String>(options);
        this.comboBoxHeatmap = c1;

        return c1;
    }

    private JComboBox comboAPBands() {

        final String[] options = {"ALL","2.4GHz only","5GHz only"};
        final JComboBox c1 = new JComboBox<String>(options);
        this.apBands = c1;

        return c1;
    }

    private JComboBox showAPS() {

        final String[] options = {"NONE", "ALL","MY"};
        final JComboBox c1 = new JComboBox<String>(options);
        this.showAPS = c1;

        return c1;
    }

    private JComboBox comboBoxHeatmapType() {

        final String[] options = new heatmapOptions().values;
        final JComboBox c1 = new JComboBox<String>(options);
        this.comboBoxHeatmapType = c1;

        return c1;
    }

    private JTextField visualizationWidthinput(){

        final JTextField c1 = new JTextField(3);
        this.visualizationWidthInput = c1;

        return c1;
    }

    private JTextField legendWidthinput(){

        final JTextField c1 = new JTextField(3);
        this.legendWidthInput = c1;

        return c1;
    }

    private JTextField statisticsWidthinput(){

        final JTextField c1 = new JTextField(3);
        this.statisticsWidthInput = c1;

        return c1;
    }

    private JButton applyButton() {

        this.applyButton = new JButton("Apply");
        this.applyButton.addActionListener(this);
        return this.applyButton;
    }


    public visualization getVisualization() {

        return this.result;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        resoleInputToVisualization();
        System.out.println("Triggerd");
        System.out.println(this.result.getVisualization());
        this.textArea.setText(this.result.getVisualization());
        repaint();
    }

    /*****
    * The function to resolve the input to commands for visualization.java
    ******/

    private void resoleInputToVisualization() {

        this.result = new visualization();

        if (this.comboBoxHeatmapType.getSelectedItem().toString() == "APS") {
            this.result.addVisualizationType(visualizationTypes.Type.APS);
        }

        if (this.comboBoxHeatmapType.getSelectedItem().toString() == "HEATMAP") {
            this.result.addVisualizationType(visualizationTypes.Type.HEATMAP);
            final HeatmapTypes t1 = new heatmap().stringToType(this.comboBoxHeatmap.getSelectedItem().toString());
            this.result.setHeatmapType(t1);
        }

        if (this.apBands.getSelectedItem().toString() == "ALL") {
            this.result.showOnAllBands();
        }

        if (this.apBands.getSelectedItem().toString() == "2.4GHz only") {
            this.result.showOn2_4GHz();
        }

        if (this.apBands.getSelectedItem().toString() == "5GHz only") {
            this.result.showOn5GHz();
        }

        if (this.showAPS.getSelectedItem().toString() == "ALL") {
            this.result.showAllAPS();
        }

        if (this.showAPS.getSelectedItem().toString() == "MY") {
            this.result.showMyAPS();
        }
        if(this.visualizationWidthInput.getText().toString() != ""){
            final String input = this.visualizationWidthInput.getText().toString();
            int size;
            try {
                size = Integer.parseInt(input);
                this.result.addWidth(size);
            }
            catch (final NumberFormatException e)
            {
            }
        }
        if(this.visualizationWidthInput.getText().toString() != ""){
            final String input = this.visualizationWidthInput.getText().toString();
            int size;
            try {
                size = Integer.parseInt(input);
                this.result.addWidth(size);
            }
            catch (final NumberFormatException e)
            {
            }
        }

        
        if(this.checkBoxWalls.isSelected() == true){
            this.result.showWalls();
        }

        if(this.checkBoxLegend.isSelected() == true){
            if(this.legendWidthInput.getText().toString() != ""){
                final String input = this.legendWidthInput.getText().toString();
                int size;
                try {
                    size = Integer.parseInt(input);
                    this.result.showLegend(size, sizeOptions.WIDTH);
                }
                catch (final NumberFormatException e)
                {
                    this.result.showLegend();

                }
            }else{
                this.result.showLegend();
            }
        }

        if(this.checkBoxStatistics.isSelected() == true){
            if(this.statisticsWidthInput.getText().toString() != ""){
                final String input = this.statisticsWidthInput.getText().toString();
                int size;
                try {
                    size = Integer.parseInt(input);
                    this.result.showStatistics(size, sizeOptions.WIDTH);
                }
                catch (final NumberFormatException e)
                {
                    this.result.showStatistics();

                }
            }else{
                this.result.showStatistics();
            }
            
        }

    }

    /*****
    * The layout of the panel 
    ******/

    private void content(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        c.gridy = 1;
        c.gridx = 1;
        add(new JLabel("Visualization Type:"), c);
        c.gridy = 2;
        c.gridx = 1;
        add(comboBoxHeatmapType(), c);
        c.gridy = 1;
        c.gridx = 2;
        add(new JLabel("Heatmap Type:"), c);
        c.gridy = 2;
        c.gridx = 2;
        add(comboBoxHeatmap(), c);     
          
        c.gridy = 3;
        c.gridx = 1;
        add(new JLabel("Show AP's:"), c);
        c.gridy = 4;
        c.gridx = 1;
        add(showAPS(), c);

        c.gridy = 3;
        c.gridx = 2;
        add(new JLabel("Filter by band:"), c);
        c.gridy = 4;
        c.gridx = 2;
        add(comboAPBands(), c);

          

        c.gridy = 1;
        c.gridx = 3;
        c.gridwidth = 2;
        add(new JLabel("----------------------Optionals----------------------"), c);
        c.gridy = 2;
        c.gridx = 3;
        add(checkBoxWalls(), c);
        c.gridy = 3;
        c.gridx = 3;
        add(checkBoxLegend(), c);
        c.gridy = 4;
        c.gridx = 3;
        add(checkBoxStatistics(), c);

        c.gridy = 5;
        c.gridx = 1;
        c.gridwidth = 2;
        add(new JLabel("------------------Set custom fixed Size------------------"), c);
        c.gridy = 6;
        c.gridx = 1;
        c.gridwidth = 1;
        add(new JLabel("Visualization width in MM:"), c);
        c.gridy = 6;
        c.gridx = 2;
        c.gridwidth = 1;
        add(visualizationWidthinput(), c);


        c.gridy = 7;
        c.gridx = 1;
        c.gridwidth = 1;
        add(new JLabel("Legend width in MM:"), c);
        c.gridy = 7;
        c.gridx = 2;
        c.gridwidth = 1;
        add(legendWidthinput(), c);

        c.gridy = 8;
        c.gridx = 1;
        c.gridwidth = 1;
        add(new JLabel("Statistics width in MM:"), c);
        c.gridy = 8;
        c.gridx = 2;
        c.gridwidth = 1;
        add(statisticsWidthinput(), c);


       
        c.gridy = 10;
        c.gridx = 2;
        add(applyButton(), c);
        c.gridy = 10;
        c.gridx = 3;
        add(this.textArea, c);


    }


}