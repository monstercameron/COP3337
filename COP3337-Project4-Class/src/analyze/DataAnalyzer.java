package analyze;

import app.ExecutionInfo;
import java.util.ArrayList;

public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         // your output format must match mine
         // look at the video for see the out format
         // the exponent value is e^x = total method class   
         // you need to find the x... do not over think it use the Math class 
         // YOU PUT YOUR CODE HERE
        for (ExecutionInfo executionInfo : data) {
            String ThreeDecinalPlaces = String.format(
                "%.3f", 
                Math.log(executionInfo.getTotalMethodCalls())
            );
            String formattedString = String.format(
                "%-12s %-21s %-18s %-20s",
                 "Index:  "+executionInfo.getFibIndex(),
                 "FibValue:  "+ executionInfo.getFibValue() ,
                 "Calls:  "+(int)executionInfo.getTotalMethodCalls(),
                 "Exponent:  "+ ThreeDecinalPlaces
            );
            System.out.println(formattedString);
        }


    }
    
}// end class
