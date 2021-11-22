package me.darkdarcool.jino;


import java.io.IOException;
import java.util.Scanner;

public class Menu {
  /**
   * Prints the title screen for the JINO game
   * @return void
   */
  public static void titleScreen() {
    System.out.println("JINO");
    System.out.println("THE GAME");
  }

  /**
   * Prints the credits for the JINO game
   * @returns void
   */
  public static void credits() {
    System.out.println("Created by: darkdarcool");
  }

  /**
   * Awaits for user to start game
   * <p>
   * The event for starting is anything to SI(Standard input)
   */

  public static void awaitStart() {
    Scanner s = new Scanner(System.in);
    s.nextLine(); // Await enter
  }

}
