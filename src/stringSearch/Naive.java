package stringSearch;
public class Naive
{
   private String text;
   private String pattern;

   public Naive(String text, String pattern)
   {
      super();
      this.text = text;
      this.pattern = pattern;
   }

   public void show()
   {
      System.out.println(this.text + this.pattern);
   }
   /**
    * Search function takes in the text and pattern in the form of strings
    * matches them a character at a time a prints out the indices of the 
    * matches.
    * 
    * @param text - string of the item to be searched
    * @param pattern - string search pattern
    * @return boolean, prints out the match indices
    */
   public boolean naive_algo(String text, String pattern)
   {  int comparisons = 0;
      int occurences[];
      int textLength = text.length();
      int patternLength = pattern.length();
      int diffLength = textLength - patternLength;

      System.out.println("textLength = " + textLength);
      System.out.println("patternLength = " + patternLength);
      System.out.println(diffLength);
      int i = 0;
      if (i + patternLength <= textLength)
      {
         for (; i <= diffLength; i++)
         {
            comparisons++;
            int j = 0;
            while (text.charAt(i + j) == pattern.charAt(j))
            {
               if (j == patternLength - 1)
               {
            //      System.out.println("NAIVE MATCH AT INDEX " + (i));
                  break;
               } else
                  j++;
            }
         }
         System.out.println("COMPARISONS = " + comparisons); 
      }
      return false;

   }

}
