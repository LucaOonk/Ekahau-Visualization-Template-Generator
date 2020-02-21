package visualization;

public class statistics {

    private String template;
    private String tag = '"'+"visualization-statistics" +'"';
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



    public statistics(){

        this.template = new String();
        this.setOptions = options.NONE;
        this.template = template + visualization.getDefaultStartString() + tag + ":{";

    }



    private void prepStatistics(){
        
        this.template = template + setOptions(this.setOptions);
        this.template = template + "}";
        this.template = template + visualization.getDefaultEndString();

    }

    public String getStatistics(){

        prepStatistics();
        return this.template;

    }

    
}