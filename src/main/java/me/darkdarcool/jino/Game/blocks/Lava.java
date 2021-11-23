package me.darkdarcool.jino.Game.blocks;

import me.darkdarcool.jino.Board;
import me.darkdarcool.jino.Utils.Events;
import me.darkdarcool.jino.Utils.Colors;

public class Lava {
  public static int caller = 4;
  public static String cover = "\uD83D\uDFE5";
  private static Board board;
  public Lava(Board map) {
   board = map;
  }

  public void onTouch(int direction) {
    board.map[board.playerIndex(board.map)] = 0;
    board.map[90] = 1;
    Events.put(Colors.RED_BOLD + "You died from touching the lava!" + Colors.RESET);
  }
}
