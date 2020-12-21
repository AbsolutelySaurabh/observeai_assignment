package main.constant;

/**
 * @author AbsolutelySaurabh
 */

public class Constants {

   // Map to store 62 possible characters
   public static char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
   public static int dbRowId = 12345;
   public static String  SHORT_URL_NOT_EXIST_ERROR = "ERROR: Short Url doesn't exist in db";

   public static void print(String message){
      System.out.println(message);
   }

}
