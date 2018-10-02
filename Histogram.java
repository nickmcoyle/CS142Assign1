    
/**
 * This class displays a graphic representation of data to the screen assuming
 * the screen is 65 characters wide.
 *
 * @author Nick Coyle
 * @version 10.1.2018
 */

public class Histogram{ 
    public static final String TITLE = "Presidential Elections";
    public static final int SCREEN_WIDTH = 65;
    public static final String LEFT_MARGIN = "     ";
    public static final char TOTAL_ELIGIBLE = 'T';
    public static final char REGISTERED_VOTERS = 'R';
    public static final char VOTES_CAST = 'V';
    public static final int SCALE = 100000;
    public static final int STEP = 1000000;
       
    public static void main(String[] args) {       
        printHeader(TITLE);
        
        createBar(2000, 4368000, TOTAL_ELIGIBLE, SCALE);
        createBar(3335714, REGISTERED_VOTERS, SCALE);
        createPercentage(4368000, 3335714);
        createBar(2517028, VOTES_CAST, SCALE);
        createPercentage(4368000, 2517028);
        emptyRow();
        
        createBar(2004, 4646000, TOTAL_ELIGIBLE, SCALE);        
        createBar(3508208, REGISTERED_VOTERS, SCALE);
        createPercentage(4646000, 3508208);
        createBar(2884783, VOTES_CAST, SCALE);
        createPercentage(4646000, 2884783);
        emptyRow();
        
        createBar(2008, 5010844, TOTAL_ELIGIBLE, SCALE);
        createBar(3630118, REGISTERED_VOTERS, SCALE);
        createPercentage(5010844, 3630118);
        createBar(3071587, VOTES_CAST, SCALE);
        createPercentage(5010844, 3071587);
        emptyRow();
        
        createBar(2012, 5221125, TOTAL_ELIGIBLE, SCALE);        
        createBar(3904959, REGISTERED_VOTERS, SCALE);
        createPercentage(5221125, 3904959);
        createBar(3172930, VOTES_CAST, SCALE);
        createPercentage(5221125, 3172930);
        emptyRow();
        
        createBar(2016, 5557921, TOTAL_ELIGIBLE, SCALE);
        createBar(4270270, REGISTERED_VOTERS, SCALE);
        createPercentage(5557921, 4270270);
        createBar(3363440, VOTES_CAST, SCALE); 
        createPercentage(5557921, 3363440);
        
        createAxis(STEP);    
    }  
    
    /**
     *  Computes the distance to the center of the screen and prints the Title of our chart
     *  at this center point.
     *  
     *  @param title the name of our chart
     */
    public static void printHeader(String title) {
        int spacesToCenter = (SCREEN_WIDTH - title.length())/2;
        
        for(int i = 0; i < spacesToCenter; ++i) {
            System.out.print(" ");
        }    
        
        System.out.println(title);
        System.out.println();
    }
    
    /**
     *  1 of 2 overloads of this method. This one prints the year, then it computes the 
     *  number of bars to print by dividing the barValue by the scale and it prints
     *  those bars to the screen.
     *  
     *  @param barTitle name of the section, in this case the year
     *  @param barValue the data we are graphing
     *  @param dataChar the symbol used to display our value
     *  @param scale the units of the y axis
     */
    public static void createBar(int barTitle, int barValue, char dataChar, int scale) {
        System.out.print(barTitle + " |");
        
        int numBars = barValue/scale;
        for(int i = 0; i<numBars; ++i) {
            System.out.print(dataChar);
        }   
        
        System.out.println();
    }
    
    /**
     *  Second of 2 overloads of this method. This one does not print the year. It computes 
     *  the number of bars to print by dividing the barValue by the scale and it prints
     *  those bars to the screen.
     *    
     *  @param barValue the data we are graphing
     *  @param dataChar the symbol used to display our value
     *  @param scale the units of the y axis
     */
    public static void createBar(int barValue, char dataChar, int scale) {
        System.out.print(LEFT_MARGIN + "|");
        
        int numBars = barValue/scale;
        for(int i = 0; i<numBars; ++i) {
            System.out.print(dataChar);
        }      
    }
    
    /**
     *  Computes the percentage difference between the bar above this bar
     *   
     *  @param total is the maximum quantity possible
     *  @param actual is the quantity that is either the number that was registered or that voted out of the possible 100%
     */
    public static void createPercentage(int total, int actual) {
        float percentage = ((float)actual/(float)total)*100.00f;       
               
        System.out.printf("     %.2f", percentage);
        System.out.print("%");
        
        System.out.println();
    }
    
    /**
     *  Computes number of chunks to display in the x-axis by dividing the screen width by 10
     *  since we assume always display x-axis by base 10
     *  
     *  @param step the amount each value increases for every 10 points on the x-axis
     */
    public static void createAxis(int step) {
        System.out.print(LEFT_MARGIN + "|");
        
        int axisSegments = SCREEN_WIDTH/10;
        
        for(int i = 0; i<axisSegments; ++i) {       
            System.out.print("---------+");      
        }

        System.out.println();
        System.out.print(LEFT_MARGIN + 0 + "      ");
        
        for(int i = 1; i<=axisSegments; ++i) {            
            System.out.print(i*step);            
            System.out.print("   ");
        }
        
        System.out.println();
    }
    
    /**
     *  Prints an empty row to the chart for style
     */
    public static void emptyRow() {
        System.out.println(LEFT_MARGIN + "|");
    }
}
