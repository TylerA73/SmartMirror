/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

/**
 *
 * @author Tyler
 */
class StringUtilities {
  /**
   * Creates a string left padded to the specified width with the supplied padding character.
   * @param fieldWidth the length of the resultant padded string.
   * @param padChar a character to use for padding the string.
   * @param s the string to be padded.
   * @return the padded string.
   */
  public static String pad(int fieldWidth, char padChar, String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length(); i < fieldWidth; i++) {
      sb.append(padChar);
    }
    sb.append(s);

    return sb.toString();
  }
  
  public static String capitalize(String s){
      String str = new String();
      String[] words;
      
      words = s.split(" ");
      
      for(int i = 0; i < words.length; i++){
          str = str + words[i].substring(0, 1).toUpperCase() + words[i].substring(1) + " ";
      }
      
      return str;
  }
}
