package me.darkdarcool.jino;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import me.darkdarcool.jino.Game.blocks.Block;
import me.darkdarcool.jino.Game.blocks.Update;

public class Board {
  public static int[] map;
  private static final String defaultPlayer = "\uD83D\uDE03";
  private static final String emptyTitle = "⬛";
  private static final String wallTile = "\uD83D\uDFE6";
  private static final String finishTile = "\uD83D\uDFE9";
  private static HashMap<Integer, Block> blocks = new HashMap<Integer, Block>();
  private static HashMap<String, Integer> blockCallers = new HashMap<String, Integer>();
  private static HashMap<Integer, String> blockNames = new HashMap<Integer, String>();
  private static HashMap<Integer, String> blockCovers = new HashMap<Integer, String>();

  private static HashMap<Integer, Update> blockUpdates = new HashMap<Integer, Update>();

  public Board() {
    // Default map gen
    // TODO: Make board bigger
    map = new int[] {
      2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,
      2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
    }; // 14 x 14 array for board
  }

  public void setBoard(int[] board) {
    map = board;
  }

  public void draw() throws InvocationTargetException, InstantiationException, IllegalAccessException {
    int placement = -1;
    for (int key : map) {
      placement++;
      if (placement == 13) {
        if (key == 1) System.out.println(defaultPlayer);
        else if (key == 2 || key == 0) System.out.println(wallTile);
        else if (key == 3) System.out.println(finishTile);
        else {
          for (int block : blockCallers.values()) {
            if (block == key) {
              System.out.println(blockCovers.get(block));
            }
          }
        }
        placement = -1;
      }
      else {
        if (key == 1) System.out.print(defaultPlayer);
        else if (key == 0) System.out.print(emptyTitle);
        else if (key == 2) System.out.print(wallTile);
        else if (key == 3) System.out.print(finishTile);
        else {
          for (int block : blockCallers.values()) {
            if (block == key) {
              System.out.print(blockCovers.get(block));
            }
          }
        }
      }
    }
  }

  public static int playerIndex(int[] arr) {
    for (int i = 0; arr.length > i; i++) {
      if (arr[i] == 1) {
        return i;
      }
    }
    return -1;
  }

  public void registerBlock(Block block, String name, String cover, int caller)  {
    blocks.put(caller, block);
    blockCovers.put(caller, cover);
    blockCallers.put(name, caller);
  }

  public void registerUpdate(Update enemy, int caller)  {
    blockUpdates.put(caller, enemy);
  }

  public void updateBlocks(Board board) {
    for (int key : blockUpdates.keySet()) {
      blockUpdates.get(key).update(board);
    }
  }

  public Boolean isBlock(int caller) {
    for (int block : blockCallers.values()) {
      if (block == caller) return true;
    }
    return false;
  }



  public Block getBlocks(int caller) {
    return blocks.get(caller);
  }
  public String getBlockName(int caller) {
    return blockNames.get(caller);
  }
  public int getBlockCaller(String name) {
    return blockCallers.get(name);
  }


}