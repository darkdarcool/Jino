package me.darkdarcool.jino.Utils;


import java.util.HashMap;

public class Events {
  public static HashMap<Integer, String> events = new HashMap<Integer, String>();
  private static int amount = 0;
  public static void put(String msg) {
    amount++;
    String event = Colors.BLUE + "[EVENT] " + Colors.RESET + msg;
    events.put(amount, event);
  }

  public static void printEvents() {
    for (int i : events.keySet()) {
      System.out.println(events.get(i));
    }
  }
}
