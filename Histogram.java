
/**
 * This class displays a graphic representation of data to the screen assuming
 * the screen is 80 characters wide.
 *
 * @author Nick Coyle
 * @version 10.1.2018
 */
public class Histogram
{ 
   public static final String TITLE = "Presidential Elections";
   public static final int SCREENWIDTH = 80;
   public static final char TOTALELIGIBLE = 'T';
   public static final char REGISTEREDVOTERS = 'R';
   public static final char VOTESCAST = 'V';
   public static final int SCALE = 100000;
   public static final int STEP = 1000000;
   
   public static void main(String[] args) {      
    printHeader(TITLE);
    createBar(2000, 4368000, TOTALELIGIBLE, SCALE);
    emptyRow();
    createAxis(STEP);    
    }       
    
    public static void printHeader(String title) {
        int centerCalculation = (SCREENWIDTH - title.length())/2;
        for(int i = 0; i < centerCalculation; ++i){
            System.out.print(" ");
        }    
        System.out.println(title);
        System.out.println();
    }
    
    public static void createBar(int barTitle, int barValue, char dataChar, int scale) {
        System.out.println(barTitle + " |");
        for(int i = 0; i<SCREENWIDTH; ++i) {
            System.out.print(dataChar);
        }        
    }
    
    public static void createBar(int barValue, char dataChar, int scale) {
        System.out.println("     |");
    }
    
    public static void createAxis(int step) {
        System.out.print("|");
        for(int i = 2; i < SCREENWIDTH/10; ++i) {
            for(int j = 0; j < 10; ++j) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        
        System.out.println();
        System.out.print(0 + "\t");
        
        for(int k = 1; k <= SCREENWIDTH/10-2; ++k) {            
            System.out.print(k*step);            
            System.out.print(" " + " " + " " + " ");
        }
        
        System.out.println();
    }
    
    public static void emptyRow() {
        System.out.println("|");
    }
}
