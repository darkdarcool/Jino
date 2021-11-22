package me.darkdarcool.jino.Game.blocks;

import me.darkdarcool.jino.Board;

public class Lava {
  public static int caller = 3;
  public static String cover = "\uD83D\uDFE5";
  private static Board board;
  public Lava(Board map) {
   board = map;
  }

  public void onTouch(int direction) {
    board.map[board.playerIndex(board.map)] = 0;
    board.map[90] = 1;
  }
}
