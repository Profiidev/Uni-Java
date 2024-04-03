package de.benji.Ueb02;

import java.util.Scanner;
import java.util.*;

/**
 * Simple simulation for the "Game of Life"
 * @author  	Professoren der Informatikfakultät
 * @version     1.0
 * Created on 	    20.3.2017, Wolfgang Mühlbauer
 * Modified	        20.3.2020, Silke Lechner-Greite
 */
public class GameOfLife {
  
  /**
   * prints living cells to console. Living cells are marked as "X", dead cells as "O".
   * @param c array of cells. True denotes living cells.
   */
  private static void printCells(boolean[][] c) {
    
    // TODO: implement
    for (boolean[] booleans : c) {
      for (int j = 0; j < c[1].length; j++) {
        System.out.print((booleans[j] ? "X" : "O") + " ");
      }
      System.out.println();
    }
  }
  
  /**
   * count number of neighboring cells that are alife
   * @param c 2-dimensional boolean array of cells (true means that cell is alife)
   * @param x row of considered cell
   * @param y column of considered cell
   * @return number of living cells that are neighbors to cell c[x][y]
   */
  private static int countLivingNeighbors(boolean[][] c, int x, int y) {
    int out = 0;
    for(int i = -1; i < 2; i++) {
      for(int j = -1; j < 2; j++) {
        if((i + x < 0) || (i + x >= c.length) || (j + y < 0) || (j + y >= c[1].length)) continue;
        out += c[i + x][j + y] ? 1 : 0;
      }
    }
    
    return out;
  }
  
  /**
   * compute next iteration / next generation of cells based on given rules
   * @param cells current generation: 2-dimensional boolean array of cells (true means that cell is alife)
   * @return next generation, same representation as 2-dimensional array of cells
   */
  private static boolean[][] computeNextGenCells(boolean[][] cells) {
    boolean[][] next = new boolean[cells.length][cells[1].length];
    
    for(int i = 0; i < cells.length; i++) {
      for(int j = 0; j < cells[1].length; j++) {
        int n = countLivingNeighbors(cells, i, j);
        if(n < 2) {
          next[i][j] = false;
        } else if(n > 3) {
          next[i][j] = false;
        } else {
          if(cells[i][j]) {
            next[i][j] = true;
          } else {
            next[i][j] = n == 3;
          }
        }
      }
    }
    
    return next;
  }
  
  
  /**
   * main-Methode welche das Javaprogramm ausführt.
   * @param args input param - String array
   */
  public static void main(String[] args) {
    // world consists of 10 x 10 elements
    boolean[][] cells = new boolean[10][10];
    
    
    
    
    // TODO: initiales 2-dim array "cells"; likelihood shall be 50% that a cell is marked as alife
    Random r = new Random();
    for(int i = 0; i < cells.length; i++) {
      for(int j = 0; j < cells[1].length; j++) {
        cells[i][j] = r.nextInt(2) == 0;
      }
    }
    
    
    
    
    // print out first generation
    System.out.println("Generation #1");
    printCells(cells);
    
    Scanner scanner = new Scanner(System.in);
    int i = 1;
    do {
      
      cells = computeNextGenCells(cells);
      System.out.println("Generation #:" + (++i));
      printCells(cells);
      System.out.println("Should I compute another generation? 'y' for \"yes\"");
    } while (scanner.next().equals("y"));
    
    
    System.out.println("Terminating");
  }
}