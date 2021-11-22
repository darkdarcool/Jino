package me.darkdarcool.jino;

import me.darkdarcool.jino.Game.Game;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Menu.titleScreen();
    Menu.credits();
    Menu.awaitStart();
    Game game = new Game();
    try {
      game.Start();
    } catch(Exception err) {
      err.printStackTrace();
      System.out.println("oof");
    }
  }
}