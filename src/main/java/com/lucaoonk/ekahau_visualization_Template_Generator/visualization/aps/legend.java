package com.lucaoonk.ekahau_visualization_Template_Generator.visualization.aps;

import com.lucaoonk.ekahau_visualization_Template_Generator.visualization.visualization;

public class legend {

    private String template;
    private String tag = '"'+"visualization-legend" +'"';
    private options setOptions;
    private static int value;

    public enum options {
        WIDTH, HEIGHT, NONE
    };

    private String setOptions(options setOptions) {

        switch (setOptions) {

        case WIDTH:
            return '"' + "width-in-millis" + '"' + ":" + '"' + value + '"';
        case HEIGHT:
            return '"' + "height-in-millis" + '"' + ":" + '"' + value + '"';
        case NONE:
            return "";

        }
        return "";

    }

    public void addHeight(int heigtInMillis) {

        this.setOptions = options.HEIGHT;
        value = heigtInMillis;
    }

    public void addWidth(int widthInMillis){

        this.setOptions = options.WIDTH;
        value = widthInMillis;
    }



    public legend(){

        this.template = new String();
        this.setOptions = options.NONE;
        this.template = template + visualization.getDefaultStartString() + tag + ":{";

    }



    private void prepLegend(){
        
        this.template = template + setOptions(this.setOptions);
        this.template = template + "}";
        this.template = template + visualization.getDefaultEndString();

    }

    public String getLegend(){

        prepLegend();
        return this.template;

    }

}