package com.lucaoonk.ekahau_visualization_Template_Generator.visualization;

public class visualizationTypes {

    Type type;

    public enum Type {
        NONE, APS, HEATMAP;
    };


    public static String typeCheck(Type type){

        switch (type){

            case APS:
            return '"'+"aps"+'"'+":{";

            case HEATMAP:
            return '"'+"heatmap"+'"'+":{";
        
            case NONE:
            return "";
            default:
            return "";
        }
        
    }
    
}