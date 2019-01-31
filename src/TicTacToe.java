/**
 * TicTacToe class implements the interface
 * @author Aden Mariyappa
 * @date 1/28/19
 */

import java.util.Random;

public class TicTacToe implements ITicTacToe {
		 
	   // The game board and the game status
	   private static final int ROWS = 3, COLS = 3; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	   private int setMoveRow;
	   Random rand = new Random();
	  
	/**
	 * clear board and set current player   
	 */
	public TicTacToe(){
		
	}
	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub
		for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	        	 board[row][col] = 0;
	         }
	      }
	}

	@Override
	public void setMove(int player, int location) {
		// TODO Auto-generated method stub
		setMoveRow = (int)(location/3);
		board[setMoveRow][location - (setMoveRow * 3)] = player;
	}

	@Override
	public int getComputerMove() {
		// TODO Auto-generated method stub
		int n = rand.nextInt(8) + 0;
		while (board[n - (setMoveRow * 3)][setMoveRow] != 0) {
			n = rand.nextInt(8) + 0;
		}
		return n;
	}

	@Override
	public int checkForWinner() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("-----------"); // print horizontal partition
	         }
	      }
	      System.out.println();
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either CROSS, NOUGHT or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case NOUGHT: System.out.print(" O "); break;
	         case CROSS:  System.out.print(" X "); break;
	      }
	   }

}
