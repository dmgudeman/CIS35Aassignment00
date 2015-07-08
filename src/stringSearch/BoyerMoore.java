package stringSearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class BoyerMoore
{
   public static HashMap makeBadMatchTable(String needle)
   {
      Character[] needleArray = toCharacterArray(needle); // str to Character[]
      Character[] eldeenArray = new Character[needle.length()];
      eldeenArray = reverse(needleArray); // reversed array
      HashMap<Character, Integer> badMatchMap = new HashMap<>();
      for (Character c : eldeenArray)
      {
         badMatchMap.put(c, Arrays.asList(eldeenArray).indexOf(c));
         if (Arrays.asList(eldeenArray).indexOf(c) == 0)
         {
            badMatchMap.put(c, needle.length());
         }
      }
      return badMatchMap;
   }


   public static void searchHaystack(String strHaystack, String strNeedle)
   {
      int comparisons = 0;
      int leadIndex = strNeedle.length() - 1;
      int leadPatternIndex = strNeedle.length() -1;
      int curHi = leadIndex;
      int curNi = leadPatternIndex;
      while (leadPatternIndex <= leadIndex && leadIndex >= 0)
      {
        if (strHaystack.charAt(curHi) == strNeedle.charAt(curNi))
        {
            if (curNi==0)
            {
     //    System.out.println("Boyer-Moore MATCH AT INDEX " 
     //          + (leadIndex - strNeedle.length() + 1));
               leadIndex = leadIndex +strNeedle.length()  ;
               if (leadIndex >= strHaystack.length()) { break;}
               curHi = leadIndex  ;
               curNi = leadPatternIndex;
            }
            curHi--;
            curNi--;
        }   
        else {
           Character lookUpCharacter = strHaystack.charAt(leadIndex);
           HashMap badMatchTable = makeBadMatchTable(strNeedle);
           Integer jump;
           jump = (Integer) badMatchTable.get(lookUpCharacter);
           comparisons ++;
           leadIndex++;
               if (leadIndex >= strHaystack.length()) 
               { 
                  System.out.println("comparisons = " + comparisons);
                  break;
               }
           curHi= leadIndex;
           curNi= leadPatternIndex;
        }
         
      }
   }
   /**
    * Prepares a Character object array from string 
    * @param pattern - takes in a string of the search pattern
    * @return
    */
  
   public static Character[] toCharacterArray(String pattern)
   {
      if (pattern == null)
      {
         return null;
      }
      int len = pattern.length();
      Character[] array = new Character[len];
      for (int i = 0; i < len; i++)
      {
         array[i] = new Character(pattern.charAt(i));
      }
      return array;
   }
   /**
    * provides a reversed  Character array from the search string
    * @param data - a Character array
    * @return a reversed Character array
    */

   public static Character[] reverse(Character[] data)
   {
      for (int left = 0, right = data.length - 1; left < right; left++, right--)
      {
         Character temp = data[left];
         data[left] = data[right];
         data[right] = temp;
      }
      return data;
   }
}