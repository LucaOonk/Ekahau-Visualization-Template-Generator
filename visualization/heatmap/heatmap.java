package visualization.heatmap;

import visualization.aps.aps.Bands;

public class heatmap{

    private HeatmapTypes type;
    private String[] options;
    public String[] values = {"NONE", "Associated_Access_Point", "Clients_Per_Access_Point","Capacity_health","Channel_Bandwidth", "Channel_coverage", "Data_rate", "Interference", "Network_Health",
        "Network_Issues", "Number_of_Aps", "Packet_Loss", "RTT", "Signal_Strenght", "Signal_Noise_Ratio", "Throughput", "Spectrum_Ch_power", "Spectrum_Utilization", "Diff_Interference",
        "Diff_Signal_Strength", "Diff_Number_of_Aps", "Airtime_Utilization", "Bluetooth_Coverage"};


    public heatmap(){

        this.type = HeatmapTypes.NONE;
        this.options = null;

    }

    public heatmap(HeatmapTypes Type){

        this.type = Type;
        this.options = null;

    }

    // public void setOptions(){

    //     this.options = null;

    // }


    public String getValues() {

        return HeatmapTypes.values().toString();
    }



    public enum HeatmapTypes{

        NONE, Associated_Access_Point, Clients_Per_Access_Point,Capacity_health,Channel_Bandwidth, Channel_coverage, Data_rate, Interference, Network_Health,
        Network_Issues, Number_of_Aps, Packet_Loss, RTT, Signal_Strenght, Signal_Noise_Ratio, Throughput, Spectrum_Ch_power, Spectrum_Utilization, Diff_Interference,
        Diff_Signal_Strength, Diff_Number_of_Aps, Airtime_Utilization, Bluetooth_Coverage;


		public String resolveType() {
        
            switch(this){


                case Associated_Access_Point:
    
                    return '"'+"type"+'"' + ": "+'"'+ "associated-ap"+'"';
                
                case Clients_Per_Access_Point:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "cap-cli-per-ap"+'"';
                    
                case Capacity_health:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "cap-health"+'"';
    
                case Channel_Bandwidth:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "ch-bandwidth"+'"';
    
                 case Channel_coverage:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "ch-coverage"+'"';
    
                case Data_rate:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "data-rate"+'"';
                
                case Interference:
    
                    return '"'+"type"+'"' + ": "+'"'+ "interference"+'"';
                
                case Network_Health:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "nw-health"+'"';
                    
                case Network_Issues:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "nw-issues"+'"';
    
                case Number_of_Aps:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "number-of-aps"+'"';
    
                 case Packet_Loss:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "packet-loss"+'"';
    
                case RTT:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "rtt"+'"';
                
                case Signal_Strenght:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "sig-strength"+'"';
    
                 case Signal_Noise_Ratio:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "snr"+'"';
    
                case Throughput:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "throughput"+'"';
    
                case Spectrum_Ch_power:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "spectrum-ch-power"+'"';
                
                case Spectrum_Utilization:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "spectrum-utilization"+'"';
    
                 case Diff_Interference:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "diff-interference"+'"';
    
                case Diff_Signal_Strength:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "diff-sig-strength"+'"';
                
                case Diff_Number_of_Aps:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "diff-number-of-aps"+'"';
    
                case Airtime_Utilization:
                    
                    return '"'+"type"+'"' + ": "+'"'+ "airtime-utilization"+'"';
    
                case Bluetooth_Coverage:
                   
                    return '"'+"type"+'"' + ": "+'"'+ "bluetooth-coverage"+'"';
    
                default:
    
                    return "";
    
            }
        }


    }

    public HeatmapTypes stringToType(String input){

        HeatmapTypes output = HeatmapTypes.NONE;


        if(input != ""){

            if(input == "NONE"){
                    output = HeatmapTypes.NONE;
            }
            if(input == "Associated_Access_Point"){
                output = HeatmapTypes.Associated_Access_Point;
            }
            if(input == "Clients_Per_Access_Point"){
                output = HeatmapTypes.Clients_Per_Access_Point;
            }
            if(input == "Capacity_health"){
                output = HeatmapTypes.Capacity_health;
            }
            if(input == "Channel_Bandwidth"){
                output = HeatmapTypes.Channel_Bandwidth;
            }
            if(input == "Channel_coverage"){
                output = HeatmapTypes.Channel_coverage;
            }
            if(input == "Data_rate"){
                output = HeatmapTypes.Data_rate;
            }
            if(input == "Interference"){
                output = HeatmapTypes.Interference;
            }
            if(input == "Network_Health"){
                output = HeatmapTypes.Network_Health;
            }
            if(input == "Network_Issues"){
                output = HeatmapTypes.Network_Issues;
            }
            if(input == "Number_of_Aps"){
                output = HeatmapTypes.Number_of_Aps;
            }
            if(input == "Packet_Loss"){
                output = HeatmapTypes.Packet_Loss;
            }
            if(input == "RTT"){
                output = HeatmapTypes.RTT;
            }
            if(input == "Signal_Strenght"){
                output = HeatmapTypes.Signal_Strenght;
            }
            if(input == "Signal_Noise_Ratio"){
                output = HeatmapTypes.Signal_Noise_Ratio;
            }
            if(input == "Throughput"){
                output = HeatmapTypes.Throughput;
            }
            if(input == "Spectrum_Ch_power"){
                output = HeatmapTypes.Spectrum_Ch_power;
            }
            if(input == "Spectrum_Utilization"){
                output = HeatmapTypes.Spectrum_Utilization;
            }
            if(input == "Diff_Interference"){
                output = HeatmapTypes.Diff_Interference;
            }
            if(input == "Diff_Signal_Strength"){
                output = HeatmapTypes.Diff_Signal_Strength;
            }
            if(input == "Diff_Number_of_Aps"){
                output = HeatmapTypes.Diff_Number_of_Aps;
            }
            if(input == "Airtime_Utilization"){
                output = HeatmapTypes.Airtime_Utilization;
            }
            if(input == "Bluetooth_Coverage"){
                output = HeatmapTypes.Bluetooth_Coverage;
            }
        }
        

        return output;

    } 
    // public String resolveType(HeatmapTypes HeatmapTypes){

    //     switch(HeatmapTypes){


    //         case Associated_Access_Point:

    //             return '"'+"type"+'"' + ": "+'"'+ "associated-ap"+'"';
            
    //         case Clients_Per_Access_Point:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "cap-cli-per-ap"+'"';
                
    //         case Capacity_health:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "cap-health"+'"';

    //         case Channel_Bandwidth:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "ch-bandwidth"+'"';

    //          case Channel_coverage:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "ch-coverage"+'"';

    //         case Data_rate:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "data-rate"+'"';
            
    //         case Interference:

    //             return '"'+"type"+'"' + ": "+'"'+ "interference"+'"';
            
    //         case Network_Health:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "nw-health"+'"';
                
    //         case Network_Issues:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "nw-issues"+'"';

    //         case Number_of_Aps:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "number-of-aps"+'"';

    //          case Packet_Loss:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "packet-loss"+'"';

    //         case RTT:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "rtt"+'"';
            
    //         case Signal_Strenght:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "sig-strength"+'"';

    //          case Signal_Noise_Ratio:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "snr"+'"';

    //         case Throughput:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "throughput"+'"';

    //         case Spectrum_Ch_power:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "spectrum-ch-power"+'"';
            
    //         case Spectrum_Utilization:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "spectrum-utilization"+'"';

    //          case Diff_Interference:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "diff-interference"+'"';

    //         case Diff_Signal_Strength:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "diff-sig-strength"+'"';
            
    //         case Diff_Number_of_Aps:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "diff-number-of-aps"+'"';

    //         case Airtime_Utilization:
                
    //             return '"'+"type"+'"' + ": "+'"'+ "airtime-utilization"+'"';

    //         case Bluetooth_Coverage:
               
    //             return '"'+"type"+'"' + ": "+'"'+ "bluetooth-coverage"+'"';

    //         default:

    //             return "";

    //     }
    // }



}



// Associated Access Point	“associated-ap”	“association-mode”, “noise”, “noise-source”, “adapter” and “network-load”
 	 	 
// Capacity: Clients Per Access Point	“cap-cli-per-ap”	Uses capacity requirement settings from project. Has no heatmap specific parameters.
 	 	 
// Capacity: Health	“cap-health”	Uses capacity requirement settings from project. Has no heatmap specific parameters.
 	 	 
// Channel Bandwidth	“ch-bandwidth“	“sig-str-min”
 	 	 
// Channel Coverage	“ch-coverage”	“adapter” and “ch-view-mode”
 	 	 
// Channel Overlap	“ch-overlap”	“ch-overlap-mode”, “adjacent-ch-mode”, “selected-ch”, “max-op-channel”, “adapter”, ”sig-str-min”, “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
 	 	 
// Data Rate	“data-rate”	“noise”, “noise-source”, “adapter”, “network-load” and “data-rate-mode” (ESS 8.0.1).
 	 	 
// Interference/Noise	“interference”	“noise”, “noise-source”, “adapter”, “network-load”, “noise-ch”, “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
 	 	 
// Network Health	“nw-health”	Uses the projects current requirements. Has no heatmap specific parameters.
 	 	 
// Network Issues	“nw-issues”	Uses the projects current requirements. Has no heatmap specific parameters.
 	 	 
// Number of APs	“number-of-aps”	“adapter”, “sig-str-min”, “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
 	 	 
// Packet Loss	“packet-loss”	“range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
 	 	 
// Round trip time	“rtt”	Has no heatmap specific parameters.
 	 	 
// Signal Strength	“sig-strength”	“adapter”, “show-sig-of”, “sig-at-ch”, “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
 	 	 
// Signal to Noise Ratio	“snr”	“noise”, “noise-source”, “adapter”, “network-load”, “range-min”, “range-max”, “range-open”, “range-spacing”, “range-colors“ and “snr-association-mode” (ESS 8.0.1).
 	 	 
// Throughput (Max)	“throughput”	“noise”, “noise-source”, “adapter”, “network-load” and “throughput-mode” (ESS 8.0.0).
 	 	 
// Spectrum Channel Power	“spectrum-ch-power”	“range-min”, “range-max”, “range-open”, “range-spacing”, “range-colors“ and “power-ch” (ESS 8.5.0).
 	 	 
// Spectrum Utilization	“spectrum-utilization”	“utilization-ch” (ESS 8.5.0).
 	 	 
// Difference in Interference	“diff-interference”	"noise-ch", “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“ (ESS 8.6.0).
 	 	 
// Difference in Signal Strength	“diff-sig-strength”	"sig-at-ch", “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“ (ESS 8.6.0).
 	 	 
// Difference in Number of APs	“diff-number-of-aps”	"sig-str-min", “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“ (ESS 8.6.0).
 	 	 
// Airtime Utilization	"airtime-utilization"	Added in (ESS 9.0.0).
// Has no heatmap specific parameters.
 	 	 
// Bluetooth Coverage	"bluetooth-coverage"	“sig-str-min”, “range-min”, “range-max”, “range-open”, “range-spacing” and “range-colors“.
