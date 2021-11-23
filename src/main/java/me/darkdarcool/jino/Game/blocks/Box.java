package me.darkdarcool.jino.Game.blocks;

import me.darkdarcool.jino.Board;

public class Box {
  public static int caller = 5;
  public static String cover = "\uD83D\uDCE6";
  private static Board board;
  public Box(Board curBoard) {
    board = curBoard;
  }

  private Boolean isSafe(int toMoveTo) {
    return board.map[toMoveTo] == 0 || board.map[toMoveTo] == 3;
  }

  private Boolean isLava(int toMoveTo) {
    return board.map[toMoveTo] == 3;
  }

  public void onTouch(int direction) {
    if (direction == 1) {
      int pos = board.playerIndex(board.map);
      if (isSafe(pos - 28)) {
        if (isLava(pos - 28)) {
          board.map[pos - 14] = 0;
        }
        else {
          board.map[pos - 28] = caller;
        }
        board.map[pos] = 0;
        board.map[pos - 14] = 1;

      }
    } else if (direction == 2) {
      int pos = board.playerIndex(board.map);
      if (isSafe(pos - 2)) {
        if (isLava(pos - 2)) {
          board.map[pos - 1] = 0;
        }
        else {
          board.map[pos - 2] = caller;
        }
        board.map[pos] = 0;
        board.map[pos - 1] = 1;
      }
    } else if (direction == 3) {
      int pos = board.playerIndex(board.map);
      if (isSafe(pos + 28)) {
        if (isLava(pos + 28)) {
          board.map[pos + 14] = 0;
        }
        else {
          board.map[pos + 28] = caller;
        }
        board.map[pos] = 0;
        board.map[pos + 14] = 1;

      }
    } else if (direction == 4) {
      int pos = board.playerIndex(board.map);
      if (isSafe(pos + 2)) {
        if (isLava(pos + 2)) {
          board.map[pos + 1] = 0;
        }
        else {
          board.map[pos + 2] = caller;
        }
        board.map[pos] = 0;
        board.map[pos + 1] = 1;

      }
    }
  }
  public void update() {
    int pos = board.playerIndex(board.map);
    if (pos % 28 == 0) {
      System.out.println("YES!");
    }
    else {
      System.out.println("NO!");
    }
  }
}
