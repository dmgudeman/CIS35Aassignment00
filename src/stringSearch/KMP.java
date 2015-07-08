
package stringSearch;
 
public class KMP{
 
    /**
     * Pre processes the pattern array based on proper prefixes and proper
     * suffixes at every position of the array
     * 
     * @param pattern - takes a char array of the search pattern
     * @return - partial match table which indicates
     */
    public static int[] preProcessPattern(char[] pattern) {
        int i = 0, j = -1;
        int ptrnLen = pattern.length;
        int[] b = new int[ptrnLen + 1];
 
        b[i] = j;
        while (i < ptrnLen) {
            while (j >= 0 && pattern[i] != pattern[j]) {
                // if there is mismatch consider next widest border
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
        
        return b;
    }
 
    /**
     * search function - takes in two char arrays and calls the function
     * to obtain a preprocessor table.
     *  
     * @param text - character array of the text to be searched
     *            
     * @param pattern - character array of the pattern
     */
    public static void searchSubString(char[] text, char[] pattern) {
        
        int comparisons = 0;
        int i = 0, j = 0;
        
        // pattern and text lengths
        int ptrnLen = pattern.length;
        int txtLen = text.length;
 
        // initialize new array and preprocess the pattern
        int[] b = preProcessPattern(pattern);
 
        while (i < txtLen) {
            while (j >= 0 && text[i] != pattern[j]) {
              
                j = b[j];

            comparisons++;
            }
            i++;
            j++;
            // a match is found
            if (j == ptrnLen) {
 //               System.out.println("KPM MATCH AT INDEX " + (i - ptrnLen));
                j = b[j];
            }
        }
        System.out.println("KMP COMPARISONS = " + comparisons);
    }
 
   
    }
