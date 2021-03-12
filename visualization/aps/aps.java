package visualization.aps;

import visualization.visualization.DisplayAPS;

public class aps{

    public enum Bands{

        ALL, BAND_5, BAND_24 ;
    }

    public String resolveAP(DisplayAPS input){
    
        String outString = "";

        if(input != DisplayAPS.NONE) {

        outString = outString + ',' +'"'+"aps"+'"'+":{";

        if(input == DisplayAPS.ALL) {
            
            outString = outString + '"'+ "filter"+ '"'+":{"+ '"' + "include" + '"' + ':' + '{' + '"' + "owner" + '"' + ':' + '"' +"any" + '"' + '}' + '}';

        }

            
        
        }

        if(input == DisplayAPS.MY) {
           
            outString = outString + '"'+ "filter"+ '"'+":{"+ '"' + "include" + '"' + ':' + '{' + '"' + "owner" + '"' + ':' + '"' +"my" + '"' + '}' + '}';
        }

        if(input == DisplayAPS.SIMULATED) {
           
            outString = outString + '"'+ "type"+ '"'+":"+ '"' + "simulated" + '"' + '}';
        }

        outString = outString + "}";

        
    return outString;

}

}