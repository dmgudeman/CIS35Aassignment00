/**
 *  CIS 035B 
 *  Lab Assignment 0
 *  
 *  David Gudeman
 *  July 7, 2015
 */
package stringSearch;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;



public class Main
{

   public static void main(String[] args) throws IOException
   {
      // prepare for the timer
      long startTime, stopTime;
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      
      
      // prepare the text
      String fileName = "/Users/davidgudeman/Documents"
                      + "/workspace/CIS35Aassignment00/Files"
                      + "/Pride_and_Prejudice.txt";
     
      File textFile = new File(fileName);
      Scanner in = new Scanner(textFile);
      String text = "";            // The text
      while (in.hasNextLine())
      {
         String line = in.nextLine();
         text += line;
      }
      System.out.println("Preparing Text");
      in.close();
      
      String pattern = "the"; // The pattern
      
      // The NAIVE run
      startTime = System.nanoTime();
      
      Naive naive = new Naive(text , pattern);
      naive.naive_algo(text, pattern);
      stopTime = System.nanoTime();
      System.out.println("\naive algorithm Elapsed Time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.\n"); 
      
      // The BOYER MOORE run 
      startTime = System.nanoTime();
      BoyerMoore.searchHaystack(text, pattern);
      stopTime = System.nanoTime();
      System.out.println("\nBoyerMoore algorithm Elapsed Time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.\n"); 
      
      // The KMP run
      char[] charText = text.toCharArray();
      char[] charPattern = pattern.toCharArray();
      startTime = System.nanoTime();
      KMP.searchSubString(charText, charPattern);
      stopTime = System.nanoTime();
      System.out.println("\nKMP algorithm Elapsed Time: "
            + tidy.format((stopTime - startTime) / 1e9) + " seconds.\n"); 
   }
}
