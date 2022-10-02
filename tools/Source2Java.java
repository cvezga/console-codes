package com.cvezga.consolecodes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Source2Java {

  static BufferedWriter bw;
  static String switchValue = "";

  static {
    try {
      bw = new BufferedWriter(new FileWriter("ConsoleCtrl.java"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws IOException {

    write("package com.cvezga.consolecodes;\n" +
            "\n" +
            "public class ConsoleCtrl {\n");

    Files.lines(Paths.get("source.txt")).forEach(line -> {
      System.out.println(line);
      //write("// " + line);
      boolean wasProcessed;
      changeSwitch(line,
              "Control characters",
              "ESC- but not CSI-sequences",
              "ECMA-48 CSI sequences",
              "ECMA-48 Set Graphics Rendition",
              "ECMA-48 Mode Switches",
              "ECMA-48 Status Report Commands",
              "Linux Console Private CSI Sequences");
      switch (switchValue) {
        case "Control characters":
          wasProcessed = control_characters(line);
          break;
        case "ESC- but not CSI-sequences":
          wasProcessed = ESC_but_not_CSI_sequences(line);
          break;
        case "ECMA-48 CSI sequences":
          wasProcessed = ECMA_48_CSI_sequences(line);
          break;
        case "ECMA-48 Set Graphics Rendition":
          wasProcessed = ECMA_48_Set_Graphics_Rendition(line);
          break;
        case "ECMA-48 Mode Switches":
          wasProcessed = ECMA_48_Mode_Switches(line);
          break;
        case "ECMA-48 Status Report Commands":
          wasProcessed = ECMA_48_Status_Report_Commands(line);
          break;
        case "Linux Console Private CSI Sequences":
          wasProcessed = Linux_Console_Private_CSI_Sequences(line);
          break;
        default:
          wasProcessed = false;
      }

      if(!wasProcessed){
        write("// " + line);
      }

    });

    write("}");

    bw.flush();
    bw.close();
  }

  private static boolean Linux_Console_Private_CSI_Sequences(String line) {
    String text = line.trim();
    if (!text.startsWith("ESC [")) return false;
    int idx1 = text.indexOf("[");
    int idx2 = text.indexOf("]");
    String chunk = text.substring(idx1, idx2 + 2).replace(" ", "");


    write(String.format("public static final char[] ??? = {ESC,%s} // %s", splitChunk(chunk), line.trim()));

    return true;
  }

  private static String splitChunk(String chunk) {
    StringBuilder sb = new StringBuilder();
    for (char c : chunk.toCharArray()) {
      if(sb.length()>0) sb.append(", ");
      sb.append("'").append(c).append("'");
    }
    return sb.toString();
  }

  private static boolean ECMA_48_Status_Report_Commands(String line) {
    String text = line.trim();
    if (!text.startsWith("ESC [") || !text.endsWith("h")) return false;
    String[] data = text.split(" ");

    write(String.format("public static final char[] %s = {ESC,'[','?','%s','h'} // %s", "???", data[3], line.trim()));

    return true;
  }

  private static boolean ECMA_48_Mode_Switches(String line) {
    String text = line.trim();
    if (!text.endsWith("h")) return false;
    String[] data = text.split(" ");

    write(String.format("public static final char[] %s = {ESC,'[','%s','h'} // %s", "???", data[2], line.trim()));

    return true;
  }

  private static boolean ECMA_48_Set_Graphics_Rendition(String line) {
    String text = removeConsecutiveSpaces(line.trim());
    String[] data = text.split(" ");
    if (!isInt(data[0])) return false;

    write(String.format("public static final char[] %s = {ESC,'[','%s','m'} // %s", data[1], data[0], line.trim()));

    return true;
  }

  private static boolean ESC_but_not_CSI_sequences(String line) {
    if (!line.contains("ESC ")) return false;
    String text = removeConsecutiveSpaces(line);
    String[] data = text.trim().split(" ");

    write(String.format("public static final char[] %s = {ESC,'%s'} // %s", data[2], data[1], line.trim()));

    return true;
  }

  private static boolean control_characters(String line) {
    //System.out.println(line);
    if (!line.contains("(0x")) return false;

    String text = remove(line, "(,)").replace("  ", " ");
    //System.out.println(line);
    String[] data = text.trim().split(" ", -1);
    data[1] = data[1].replace("(", "").replace(",", "");
    write("public static final char " + data[0] + " = " + data[1] + "; // " + line.trim());

    return true;
  }

  private static boolean ECMA_48_CSI_sequences(String line) {
    String text = line.trim().replace("   ", " ");
    String[] data = text.split(" ");
    if (data[0].length() != 1) return false;

    write(String.format("public static final char[] %s = {ESC,'[','%s'} // %s", data[1], data[0], line.trim()));

    return true;
  }

  private static void changeSwitch(String line, String... values) {
    for (String value : values) {
      if (line.contains(value)) {
        switchValue = value;
        break;
      }
    }
  }

  private static void write(String line) {
    try {
      bw.write(line);
      bw.write("\n");

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String remove(String text, String remove) {
    for (char c : remove.toCharArray()) {
      text = text.replace(String.valueOf(c), "");
    }
    return text;
  }

  private static boolean isInt(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static String removeConsecutiveSpaces(String line) {
    StringBuilder sb = new StringBuilder();
    boolean lastWasSpace = false;
    for (char c : line.toCharArray()) {
      if (lastWasSpace && c == ' ') {
        //skip
      } else {
        sb.append(c);
        lastWasSpace = (c == ' ');
      }
    }
    return sb.toString();
  }
}
