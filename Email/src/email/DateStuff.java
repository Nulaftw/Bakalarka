package email;

import java.util.*;
import java.text.*;
/**
 *
 * @author Nula
 */

public class DateStuff {

   public static void main(String args[]) {
      SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss dd.MM.yyyy"); 

      String input = "15:20:37 19.11.2014"; 

      System.out.print(input + " Parsuje jako "); 

      Date t = Calendar.getInstance().getTime(); 

      try { 
          t = ft.parse(input); 
          System.out.println(t); 
      } catch (ParseException e) { 
          System.out.println("Neparsovatelne: " + ft); 
      }
      
      String str = ft.format(t);
      System.out.println(str);
      
   }
}