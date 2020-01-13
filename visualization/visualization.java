package visualization;

import java.util.List;

import visualization.visualizationTypes.Type;
import visualization.aps.aps;
import visualization.aps.aps.Bands;
import visualization.heatmap.heatmapOptions;
import visualization.heatmap.heatmap.HeatmapTypes;

public class visualization {

    private String template;

    private static String startString = "<#";
    private static String endString = "#>";
    private String startType = ('"' + "visualization" + '"' + ":{");
    private String endType = "}";
    private int size;
    private sizeOptions sOptions;
    private HeatmapTypes setHeatmapType;
    public List<heatmapOptions> setHeatmapOptions;
    private visualizationTypes.Type visualizationType;
    private DisplayAPS displayAPS;
    private boolean showLegend;
    private sizeOptions legendOptions;
    private int legendValue;
    private boolean showStatistics;
    private sizeOptions statisticsOptions;
    private int statisticsvalue;
    private boolean showWalls;
    private boolean done;

    private aps.Bands APBands;

    public enum DisplayAPS {

        NONE, MY, ALL;

    };

    public enum sizeOptions {
        WIDTH, HEIGHT, NONE;
    };

    public static String getDefaultEndString() {

        return endString;
    }

    public void showLegend() {

        this.showLegend = true;

    }

    public void showLegend(int value, sizeOptions width) {

        this.showLegend = true;
        this.legendOptions = width;
        this.legendValue = value;

    }

    public void showStatistics() {

        this.showStatistics = true;

    }

    public void showStatistics(int value, sizeOptions sizeOptions) {

        this.showStatistics = true;
        this.statisticsOptions = sizeOptions;
        this.statisticsvalue = value;

    }

    private String setSizeOptions(sizeOptions sOptions) {

        switch (sOptions) {

        case WIDTH:
            return "," + '"' + "width-in-millis" + '"' + ":" + '"' + size + '"';
        case HEIGHT:
            return "," + '"' + "height-in-millis" + '"' + ":" + '"' + size + '"';
        default:
            return "";

        }

    }

    public void showWalls() {

        this.showWalls = true;

    }

    public void addHeight(int heigtInMillis) {

        this.sOptions = sizeOptions.HEIGHT;
        size = heigtInMillis;
    }

    public void addWidth(int widthInMillis) {

        this.sOptions = sizeOptions.WIDTH;
        size = widthInMillis;
    }

    public visualization() {

        this.visualizationType = Type.NONE;
        this.displayAPS = DisplayAPS.NONE;
        this.sOptions = sizeOptions.NONE;
        this.APBands = Bands.ALL;
        this.done = false;
        this.setHeatmapType = HeatmapTypes.NONE;
        this.template = "";
        this.template = template + startString;
        this.template = template + startType;

    }

    public void addVisualizationType(visualizationTypes.Type type) {

        this.visualizationType = type;
        this.template = template + visualizationTypes.typeCheck(type);
    }

    private void prepTemplate() {
        if(this.done ==false ){

        if(this.visualizationType.equals(visualizationTypes.Type.NONE)){

            this.template = "Change the visualizationtype to get a visualization";


        }else{

        if(this.visualizationType.equals(visualizationTypes.Type.HEATMAP)){
            this.template = template + this.setHeatmapType.resolveType();

        }

        if(this.visualizationType.equals(visualizationTypes.Type.APS)){
            //this.template = template + this.setHeatmapType.resolveType();

        }

        this.template = template + this.filterBands();
        
        this.template = template + endType;

        aps a1 = new aps();

        this.template = template +  a1.resolveAP(this.displayAPS);


        this.template = template + this.setSizeOptions(this.sOptions);

        if(this.showWalls){

            this.template = template + ','+'"'+"walls"+'"'+ ':' + '"' +"true"+'"';

        }

        this.template = template + endType;

        /*
        //this, Set Heatmap Specific Options
        */
        
        this.template = template + endString;

        
        if(this.showLegend){
            legend l1 = new legend();

            if(this.legendOptions == sizeOptions.WIDTH){
                l1.addWidth(this.legendValue);
            }
            if(this.legendOptions == sizeOptions.HEIGHT){
                l1.addHeight(this.legendValue);
            }
            this.template = template + "\n"+ l1.getLegend();
        }

        if(this.showStatistics){
            statistics l1 = new statistics();

            if(this.statisticsOptions == sizeOptions.WIDTH){
                l1.addWidth(this.statisticsvalue);
            }
            if(this.statisticsOptions == sizeOptions.HEIGHT){
                l1.addHeight(this.statisticsvalue);
            }
            this.template = template + "\n"+ l1.getStatistics();
        }
    
    }
this.done = true;
}else{

}
    }

    public void showMyAPS(){
        
        this.displayAPS = DisplayAPS.MY;
        
    }

    public void showAllAPS(){
        
        this.displayAPS = DisplayAPS.ALL;
        
    }

    public void showOn2_4GHz(){

        this.APBands = Bands.BAND_24;
        
    }

    public void showOnAllBands(){
        this.APBands = APBands.ALL;
    }

    public void showOn5GHz(){

        this.APBands = Bands.BAND_5;

    }

    public String getVisualization() {

        prepTemplate();
        return this.template.toString();
    }

    public void print() {

        System.out.println(this.getVisualization());

    }

    public static String getDefaultStartString() {

        return startString;
    }

    public void setHeatmapType(HeatmapTypes Type){

        this.setHeatmapType = Type;
        

    }

    private String filterBands(){


        String outString = "";


        if(this.visualizationType.equals(visualizationTypes.Type.HEATMAP)){
        
        
            outString = outString + ",";

        }

            //Resolves the Bands ENUM to String for the visualization
        
        
            outString = outString + '"'+ "filter"+ '"'+":{"+ '"' + "include" + '"' + ':' + '{' ;
           
            if(this.APBands == Bands.BAND_24) {

                outString = outString + '"' + "band" + '"' + ':' + '"' +"2.4" + '"'+ '}' + '}';
           
            } 

            if(this.APBands == APBands.BAND_5){
               
                outString = outString + '"' + "band" + '"' + ':' + '"' +"5" + '"'+ '}' + '}';

            } 

            if(this.APBands == APBands.ALL){

                outString = outString + '"' + "band" + '"' + ':' + '"' +"any" + '"'+ '}' + '}';

            } 
        

            return outString;
    }



    }
