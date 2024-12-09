package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   *
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length == 2) {
      String type = args[0];
      String converted = "";
      if (type.equals("braille")) {
        char[] text = args[1].toCharArray();
        for (char ch : text) {
          converted = converted + BrailleAsciiTables.toBraille(ch);
        }
      } else if (type.equals("unicode")) {
        char[] text = args[1].toCharArray();
        String braille = "";
        for (char ch : text) {
          braille = braille + BrailleAsciiTables.toBraille(ch);
        }


        if ((braille.length() % 6) == 0) {
          for (int i = 0; i < braille.length(); i += 6) {
            String str = braille.substring(i, i + 6);
            converted = converted + BrailleAsciiTables.toUnicode(str);
          }
        } else {
          pen.println("Invalid length of bits");
        }
      } else if (type.equals("ascii")) {
        if ((args[1].length() % 6) == 0) {
          for (int i = 0; i < args[1].length(); i += 6) {
            String str = args[1].substring(i, i + 6);
            converted = converted + BrailleAsciiTables.toAscii(str);
          }
        } else {
          pen.println("Invalid length of bits");
        }
      }
      pen.println(converted);
    }
    pen.close();
  } // main(String[]

} // class BrailleASCII
