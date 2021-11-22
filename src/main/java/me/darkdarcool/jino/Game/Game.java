package me.darkdarcool.jino.Game;

import me.darkdarcool.jino.Board;
import me.darkdarcool.jino.Game.Levels;
import me.darkdarcool.jino.Game.blocks.Block;
import me.darkdarcool.jino.Game.blocks.Lava;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.io.*;

public class Game {
  public Game() {}

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void play() throws InvocationTargetException, InstantiationException, IllegalAccessException {
    Board myBoard = new Board();
    clearScreen();
    while (true) {
      clearScreen();
      myBoard.draw();
      Scanner reader = new Scanner(System.in);
      char option = reader.next().charAt(0);
      if (option == 'w') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur - 14] != 2) {

            myBoard.map[cur - 14] = 1;
            myBoard.map[cur] = 0;
        }
      }

      else if (option == 'a') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur - 1]  != 2) {
          myBoard.map[cur - 1] = 1;
          myBoard.map[cur] = 0;
        }
      }

      else if (option == 's') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur + 14] != 2) {
          myBoard.map[cur + 14] = 1;
          myBoard.map[cur] = 0;
        }
      }

      else if (option == 'd') {
        int cur = Board.playerIndex(myBoard.map);
        if (myBoard.map[cur + 1] != 2) {
          myBoard.map[cur + 1] = 1;
          myBoard.map[cur] = 0;
        }
      }
      else if (option == 'q') {
        clearScreen();
        break;
      }
    }
  }

  private static void handleBlock(int caller, Board board, int playerIndex, char dir) {
    int direction = 0;
    if (dir == 'w') direction = 1;
    else if (dir == 'a') direction = 2;
    else if (dir == 's') direction = 3;
    else if (dir == 'd') direction = 4;
    Block block = board.getBlocks(caller);
    block.handle(board, direction);
  }

  private static void play(Board myBoard) {
    clearScreen();
    while (true) {
      clearScreen();
      try {
        myBoard.draw();
      } catch(Exception e) {
        System.out.println("ERROR");
      }
      char option = 0;
      Scanner scanner = new Scanner(System.in);
      option = scanner.next().charAt(0);
      Lava lava = new Lava(myBoard);
      if (option == 'w') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur - 14] != 2) {
          int dest = myBoard.map[cur - 14];
          if (myBoard.isBlock(dest)) {
            handleBlock(dest, myBoard, cur, 'w');
          }
          else {
            myBoard.map[cur - 14] = 1;
            myBoard.map[cur] = 0;
          }
        }

      }
      else if (option == 'a') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur - 1]  != 2) {
          int dest = myBoard.map[cur - 1];
          if (dest != 0) {
            handleBlock(dest, myBoard, cur, 'a');
          }
          else {
            myBoard.map[cur - 1] = 1;
            myBoard.map[cur] = 0;
          }
        }
      }

      else if (option == 's') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur + 14] != 2) {
          int dest = myBoard.map[cur + 14];
          if (dest != 0) {
            if (myBoard.isBlock(dest)) {
              handleBlock(dest, myBoard, cur, 's');
            }
          }
          else {
            myBoard.map[cur + 14] = 1;
            myBoard.map[cur] = 0;
          }
        }
      }

      else if (option == 'd') {
        int cur = myBoard.playerIndex(myBoard.map);
        if (myBoard.map[cur + 1] != 2) {
          int dest = myBoard.map[cur + 1];
          if (dest != 0) {
            if (myBoard.isBlock(dest)) {
              handleBlock(dest, myBoard, cur, 'd');
            }
          }
          else {
            myBoard.map[cur + 1] = 1;
            myBoard.map[cur] = 0;
          }
        }
      }
      else if (option == 'q') {
        clearScreen();
        break;
      }
    }
  }

  private void playground() {
    try {
      play(); // Starts regular playground
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  private static void levelManager() {
    System.out.println("Prepare to start level 1");
    play(Levels.loadLevel1());
  }

  private void info() {
    System.out.println("Jino is an interactive, and fun to play terminal game");
    System.out.println("You play it by using [w/a/s/d], and pressing enter when your command it done");
    System.out.println("You can enter a playground by typing 0 in to prompt. To play actual levels, type 1. To leave type q");
  }

  public void Start()  {
    clearScreen();
    info();
    while (true) {
      Scanner reader = new Scanner(System.in);
      char cmd = reader.next().charAt(0);
      if (cmd == '0') {
        playground(); // Starts play ground
        clearScreen();
        info();
      } else if (cmd == '1') {
        levelManager();
        clearScreen();
        info();
      } else if (cmd == 'q') {
        break;
      }
      else {
        System.out.println("Unknown command!");
      }
    }
    clearScreen();
    System.out.println("Thanks for playing!");
  }
}
