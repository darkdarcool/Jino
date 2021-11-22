package me.darkdarcool.jino.Game.blocks;

import me.darkdarcool.jino.Board;

public interface Block {
  void handle(Board board, int direction);
}
