package me.darkdarcool.jino.Game;

import me.darkdarcool.jino.Board;
import me.darkdarcool.jino.Game.blocks.Box;
import me.darkdarcool.jino.Game.blocks.Lava;

public class Levels {
  // Board must be 14 x 14
  public static final int[] level1 = {
          2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
          2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2,
          2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2,
          2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
          2, 4, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 1, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 0, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 2,
          2, 4, 3, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 2,
          2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
  };
  public static Board loadLevel1() {
    Board board = new Board();
    Box box = new Box(board);
    board.setBoard(level1);
    board.registerBlock((curBoard, direction) -> {
      Lava lava = new Lava(curBoard);
      lava.onTouch(direction);
    }, "Lava", Lava.cover, Lava.caller);
    board.registerBlock((curBoard, direction) -> {
      box.onTouch(direction);
    }, "Box", Box.cover, Box.caller);


    board.registerUpdate((curBoard) -> {
       box.update();
    }, Box.caller);

    return board;
  }

}
