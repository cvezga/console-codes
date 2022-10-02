package com.cvezga.consolecodes;

public class ConsoleEscCtrlSequences {

  public static final char ESC = 0x1B; // ESC (0x1B, ^[) starts an escape sequence;

  //        ECMA-48 Set Graphics Rendition
// 
//        The  ECMA-48  SGR sequence ESC [ parameters m sets display attributes.  Several attributes
//        can be set in the same sequence, separated by semicolons.   An  empty  parameter  (between
//        semicolons or string initiator or terminator) is interpreted as a zero.
// 
  public static final char[] RESET_ALL_ATTRIBUTES = {ESC, '[', '0', 'm'}; // 0         reset all attributes to their defaults
  public static final char[] SET_BOLD = {ESC, '[', '1', 'm'}; // 1         set bold
  public static final char[] SET_HALF_BRIGHT = {ESC, '[', '2', 'm'}; // 2         set half-bright (simulated with color on a color display)
  public static final char[] SET_UNDERSCORE = {ESC, '[', '4', 'm'}; // 4         set  underscore (simulated with color on a color display)
  //                  (the colors used to simulate dim  or  underline  are  set
//                  using ESC ] ...)
  public static final char[] SET_BLINK = {ESC, '[', '5', 'm'}; // 5         set blink
  public static final char[] SET_REVERSE_VIDEO = {ESC, '[', '7', 'm'}; // 7         set reverse video
  public static final char[] RESET_SELECTED_MAPPING = {ESC, '[', '1', '0', 'm'}; // 10        reset  selected mapping, display control flag, and toggle
  //                  meta flag (ECMA-48 says "primary font").
  public static final char[] SELECT_NULL_MAPPING = {ESC, '[', '1', '1', 'm'}; // 11        select null mapping,  set  display  control  flag,  reset
  //                  toggle meta flag (ECMA-48 says "first alternate font").
  public static final char[] SELECT_NULL_MAPPING2 = {ESC, '[', '1', '2', 'm'}; // 12        select null mapping, set display control flag, set toggle
  //                  meta flag (ECMA-48 says "second  alternate  font").   The
//                  toggle  meta  flag  causes  the  high bit of a byte to be
//                  toggled before the mapping table translation is done.
  public static final char[] SET_UNDERLINE = {ESC, '[', '2', '1', 'm'}; // 21        set underline; before Linux 4.17, this value  set  normal
  //                  intensity (as is done in many other terminals)
// 
  public static final char[] SET_NORMAL_INTENSITY = {ESC, '[', '2', '2', 'm'}; // 22        set normal intensity
  public static final char[] UNDERLINE_OFF = {ESC, '[', '2', '4', 'm'}; // 24        underline off
  public static final char[] BLINK_OFF = {ESC, '[', '2', '5', 'm'}; // 25        blink off
  public static final char[] REVERSE_VIDEO_OFF = {ESC, '[', '2', '7', 'm'}; // 27        reverse video off
  public static final char[] SET_BLACK_FOREGROUND = {ESC, '[', '3', '0', 'm'}; // 30        set black foreground
  public static final char[] SET_RED_FOREGROUND = {ESC, '[', '3', '1', 'm'}; // 31        set red foreground
  public static final char[] SET_GREEN_FOREGROUND = {ESC, '[', '3', '2', 'm'}; // 32        set green foreground
  public static final char[] SET_BROWN_FOREGROUND = {ESC, '[', '3', '3', 'm'}; // 33        set brown foreground
  public static final char[] SET_BLUE_FOREGROUND = {ESC, '[', '3', '4', 'm'}; // 34        set blue foreground
  public static final char[] SET_MAGENTA_FOREGROUND = {ESC, '[', '3', '5', 'm'}; // 35        set magenta foreground
  public static final char[] SET_CYAN_FOREGROUND = {ESC, '[', '3', '6', 'm'}; // 36        set cyan foreground
  public static final char[] SET_WHITE_FOREGROUND = {ESC, '[', '3', '7', 'm'}; // 37        set white foreground
  public static final char[] SET_FOREGROUND_256_24_bit = {ESC, '[', '3', '8', 'm'}; // 38        256/24-bit  foreground  color follows, shoehorned into 16
  //                  basic colors (before Linux 3.16: set underscore  on,  set
//                  default foreground color)
  public static final char[] SET_DEFAULT_FOREGROUND_COLOR = {ESC, '[', '3', '9', 'm'}; // 39        set  default  foreground  color  (before  Linux 3.16: set
  //                  underscore off, set default foreground color)
  public static final char[] SET_BLACK_BACKGROUND = {ESC, '[', '4', '0', 'm'}; // 40        set black background
  public static final char[] SET_RED_BACKGROUND = {ESC, '[', '4', '1', 'm'}; // 41        set red background
  public static final char[] SET_GREEN_BACKGROUND = {ESC, '[', '4', '2', 'm'}; // 42        set green background
  public static final char[] SET_BROWN_BACKGROUND = {ESC, '[', '4', '3', 'm'}; // 43        set brown background
  public static final char[] SET_BLUE_BACKGROUND = {ESC, '[', '4', '4', 'm'}; // 44        set blue background
  public static final char[] SET_MAGENTA_BACKGROUND = {ESC, '[', '4', '5', 'm'}; // 45        set magenta background
  public static final char[] SET_CYAN_BACKGROUND = {ESC, '[', '4', '6', 'm'}; // 46        set cyan background
  public static final char[] SET_WHITE_BACKGROUND = {ESC, '[', '4', '7', 'm'}; // 47        set white background
  public static final char[] SET_BACKGROUND_256_24_bit = {ESC, '[', '4', '8', 'm'}; // 48        256/24-bit background color follows,  shoehorned  into  8
  //                  basic colors
  public static final char[] SET_DEFAULT_BACKGROUND_COLOR = {ESC, '[', '4', '9', 'm'}; // 49        set default background color
//
//        Commands 38 and 48 require further arguments:
// 
//        ;5;x       256  color:  values 0..15 are IBGR (black, red, green,
//                   ... white), 16..231 a 6x6x6  color  cube,  232..255  a
//                   grayscale ramp
//        ;2;r;g;b   24-bit color, r/g/b components are in the range 0..255
//
  public static final char[] SET_BLACK_BRIGHT_FOREGROUND = {ESC, '[', '9', '0', 'm'}; // 30        set black foreground
  public static final char[] SET_RED_BRIGHT_FOREGROUND = {ESC, '[', '9', '1', 'm'}; // 31        set red foreground
  public static final char[] SET_GREEN_BRIGHT_FOREGROUND = {ESC, '[', '9', '2', 'm'}; // 32        set green foreground
  public static final char[] SET_BROWN_BRIGHT_FOREGROUND = {ESC, '[', '9', '3', 'm'}; // 33        set brown foreground
  public static final char[] SET_BLUE_BRIGHT_FOREGROUND = {ESC, '[', '9', '4', 'm'}; // 34        set blue foreground
  public static final char[] SET_MAGENTA_BRIGHT_FOREGROUND = {ESC, '[', '9', '5', 'm'}; // 35        set magenta foreground
  public static final char[] SET_CYAN_BRIGHT_FOREGROUND = {ESC, '[', '9', '6', 'm'}; // 36        set cyan foreground
  public static final char[] SET_WHITE_BRIGHT_FOREGROUND = {ESC, '[', '9', '7', 'm'}; // 37        set white foreground

  public static final char[] SET_BLACK_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '0', 'm'}; // 40        set black background
  public static final char[] SET_RED_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '1', 'm'}; // 41        set red background
  public static final char[] SET_GREEN_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '2', 'm'}; // 42        set green background
  public static final char[] SET_BROWN_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '3', 'm'}; // 43        set brown background
  public static final char[] SET_BLUE_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '1', '0', 'm'}; // 44        set blue background
  public static final char[] SET_MAGENTA_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '5', 'm'}; // 45        set magenta background
  public static final char[] SET_CYAN_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '6', 'm'}; // 46        set cyan background
  public static final char[] SET_WHITE_BRIGHT_BACKGROUND = {ESC, '[', '1', '0', '7', 'm'}; // 47        set white background

}
