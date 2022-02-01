//https://www.youtube.com/watch?v=iojTgVGkd6o <------ Link to Youtube Video

/* If you want to see the code I demonstrate in this video scroll all the way down I had to comment it out so that I can receive credit
because I wanted to do the whole project in one class but this caused issues with ZyBooks so that is why I am only submitting the Grid.java
portion of it */

//public class Grid {
//	private boolean[][] bombGrid;
//	private int [][] countGrid;
//	private int numRows;
//	private int numColumns;
//	private int numBombs;
//
//    
//	public Grid()  {
//		numRows = 10;
//		numColumns = 10;
//		numBombs = 25;
//		bombGrid = new boolean[numRows][numColumns];
//		countGrid = new int[numRows][numColumns];	
//		createBombGrid();
//		createCountGrid();
//		
//
//	
//	}
//	
//
//	public Grid(int rows, int columns) {
//		numRows = rows;
//		numColumns = columns;
//		numBombs = 25;
//		bombGrid = new boolean[rows][columns];
//		countGrid = new int [rows][columns];
//		createBombGrid();
//		createCountGrid();
//		
//
//	
//	}
//	
//	public Grid(int rows, int columns, int bombs) {
//		numRows = rows;
//		numColumns = columns;
//		numBombs = bombs;
//		bombGrid = new boolean[rows][columns];
//		countGrid = new int [rows][columns];
//		createBombGrid();
//		createCountGrid();
//		
//
//	}
//	
//	public int getNumRows() {
//		return numRows;
//	}
//	
//	public int getNumColumns() {
//		return numColumns;
//	}
//	
//	public int getNumBombs() {
//		return numBombs;
//	}
//	
//    public boolean[][] getBombGrid() {
//    	boolean[][] bomb_arr = new boolean[numRows][numColumns];
//    	
//		for (int i = 0; i < numRows; i++) {
//			
//			System.arraycopy(bombGrid[i], 0, bomb_arr[i], 0, bombGrid[i].length); //copies array from source to destination
//		}
//		
//		return bomb_arr;
//    }
//	
//    public int[][] getCountGrid() {
//    	int[][] count_arr = new int[numRows][numColumns];
//    	
//		for (int i = 0; i < numRows; i++) {
//			
//			System.arraycopy(countGrid[i], 0, count_arr[i], 0, countGrid[i].length);
//		}
//		
//		return count_arr;
//    }
//		
//    public void createBombGrid() {
//    	
//        for (int i = 0; i < numRows; i++) {
//        	
//            for (int j = 0; j < numColumns; j++) {
//            	
//                bombGrid[i][j] = false; 
//            }
//        }
//        
//        for (int i = 0; i < numBombs; i++) {
//        	
//            int first_rand = (int) (Math.random() * numRows);
//            int sec_rand = (int) (Math.random() * numColumns);
//            
//            if (bombGrid[first_rand][sec_rand]) {
//                i--;
//            } 
//            
//            else {
//                bombGrid[first_rand][sec_rand] = true;
//            } 
//        }
//    }
//    
//
//    public boolean isBombAtLocation(int row, int column) {
//        return bombGrid[row][column];
//    }
//    
//    public int getCountAtLocation(int row, int column) {
//        int bombNum = 0;
//        
//        
//        if (column < numColumns - 1 && bombGrid[row][column + 1] == true) {
//            bombNum++;
//        }
//        
//        if (row > 0 && column < numColumns - 1 && bombGrid[row - 1][column + 1] == true) {
//            bombNum++;
//        }
//        
//        if (row > 0 && bombGrid[row - 1][column] == true) {
//            bombNum++;
//        }
//        
//        if (bombGrid[row][column] == true) {
//            bombNum++;
//        }
//        
//        if (row < numRows - 1 && column < numColumns - 1 && bombGrid[row + 1][column + 1] == true) {
//            bombNum++;
//        }
//        
//        if (row < numRows - 1 && bombGrid[row + 1][column] == true) {
//            bombNum++;
//        }
//        
//        if (row > 0 && column > 0 && bombGrid[row - 1][column - 1] == true) {
//            bombNum++;
//        }
//        
//        if (row < numRows - 1 && column > 0 && bombGrid[row + 1][column - 1] == true) {
//            bombNum++;
//        }
//        
//        if (column > 0 && bombGrid[row][column - 1] == true) {
//            bombNum++;
//        }
//        
//        return bombNum;
//    }
//    
//
//    public void createCountGrid() {
//    	
//    	for (int i = 0; i < numRows; i++) {
//    		
//    		for (int j = 0; j < numColumns; j++) {
//    			
//    			countGrid[i][j] = getCountAtLocation(i, j);
//    		}
//    	} 
//    }
//}

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Grid extends JFrame{
	private boolean[][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
    private int safeZones;
    private JButton click[][];
    
	public Grid()  {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];	
		createBombGrid();
		createCountGrid();
		
        safeZones = (getNumRows() * getNumColumns()) - getNumBombs();
        click = new JButton[getNumRows()][getNumColumns()];
        
    	setLayout(new GridLayout(getNumRows(), getNumColumns()));
    	
        for (int i = 0; i < getNumRows(); i++) {
              for (int j = 0; j < getNumColumns(); j++) {
                    click[i][j] = new JButton();
                    click[i][j].addActionListener(new ActList(i, j));
                    click[i][j].setBackground(Color.WHITE);
                    click[i][j].setOpaque(true);
                	add(click[i][j]);
          	}
    	}
        
    	setSize(500, 500);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	

	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		numBombs = 25;
		bombGrid = new boolean[rows][columns];
		countGrid = new int [rows][columns];
		createBombGrid();
		createCountGrid();
		
        safeZones = (getNumRows() * getNumColumns()) - getNumBombs();
        click = new JButton[getNumRows()][getNumColumns()];
        
    	setLayout(new GridLayout(getNumRows(), getNumColumns()));
    	
        for (int i = 0; i < getNumRows(); i++) {
              for (int j = 0; j < getNumColumns(); j++) {
                    click[i][j] = new JButton();
                    click[i][j].addActionListener(new ActList(i, j));
                    click[i][j].setBackground(Color.WHITE);
                    click[i][j].setOpaque(true);
                	add(click[i][j]);
          	}
    	}
        
    	setSize(500, 500);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	public Grid(int rows, int columns, int bombs) {
		numRows = rows;
		numColumns = columns;
		numBombs = bombs;
		bombGrid = new boolean[rows][columns];
		countGrid = new int [rows][columns];
		createBombGrid();
		createCountGrid();
		
        safeZones = (getNumRows() * getNumColumns()) - getNumBombs();
        click = new JButton[getNumRows()][getNumColumns()];
        
    	setLayout(new GridLayout(getNumRows(), getNumColumns()));
    	
        for (int i = 0; i < getNumRows(); i++) {
              for (int j = 0; j < getNumColumns(); j++) {
                    click[i][j] = new JButton();
                    click[i][j].addActionListener(new ActList(i, j));
                    click[i][j].setBackground(Color.WHITE);
                    click[i][j].setOpaque(true);
                	add(click[i][j]);
          	}
    	}
        
    	setSize(500, 500);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public int getNumBombs() {
		return numBombs;
	}
	
    public boolean[][] getBombGrid() {
    	boolean[][] bomb_arr = new boolean[numRows][numColumns];
    	
		for (int i = 0; i < numRows; i++) {
			
			System.arraycopy(bombGrid[i], 0, bomb_arr[i], 0, bombGrid[i].length); //copies array from source to destination
		}
		
		return bomb_arr;
    }
	
    public int[][] getCountGrid() {
    	int[][] count_arr = new int[numRows][numColumns];
    	
		for (int i = 0; i < numRows; i++) {
			
			System.arraycopy(countGrid[i], 0, count_arr[i], 0, countGrid[i].length);
		}
		
		return count_arr;
    }
		
    public void createBombGrid() {
    	
        for (int i = 0; i < numRows; i++) {
        	
            for (int j = 0; j < numColumns; j++) {
            	
                bombGrid[i][j] = false; 
            }
        }
        
        for (int i = 0; i < numBombs; i++) {
        	
            int first_rand = (int) (Math.random() * numRows);
            int sec_rand = (int) (Math.random() * numColumns);
            
            if (bombGrid[first_rand][sec_rand]) {
                i--;
            } 
            
            else {
                bombGrid[first_rand][sec_rand] = true;
            } 
        }
    }
    

    public boolean isBombAtLocation(int row, int column) {
        return bombGrid[row][column];
    }
    
    public int getCountAtLocation(int row, int column) {
        int bombNum = 0;
        
        
        if (column < numColumns - 1 && bombGrid[row][column + 1] == true) {
            bombNum++;
        }
        
        if (row > 0 && column < numColumns - 1 && bombGrid[row - 1][column + 1] == true) {
            bombNum++;
        }
        
        if (row > 0 && bombGrid[row - 1][column] == true) {
            bombNum++;
        }
        
        if (bombGrid[row][column] == true) {
            bombNum++;
        }
        
        if (row < numRows - 1 && column < numColumns - 1 && bombGrid[row + 1][column + 1] == true) {
            bombNum++;
        }
        
        if (row < numRows - 1 && bombGrid[row + 1][column] == true) {
            bombNum++;
        }
        
        if (row > 0 && column > 0 && bombGrid[row - 1][column - 1] == true) {
            bombNum++;
        }
        
        if (row < numRows - 1 && column > 0 && bombGrid[row + 1][column - 1] == true) {
            bombNum++;
        }
        
        if (column > 0 && bombGrid[row][column - 1] == true) {
          bombNum++;
      }
      
        return bombNum;
    }
    

    public void createCountGrid() {
    	
    	for (int i = 0; i < numRows; i++) {
    		
    		for (int j = 0; j < numColumns; j++) {
    			
    			countGrid[i][j] = getCountAtLocation(i, j);
    		}
    	} 
    }
    
	  private void gameReset() {
	    	createBombGrid();
	    	createCountGrid();
	        safeZones = (getNumRows() * getNumColumns()) - getNumBombs();
	        
	        for (int i = 0; i < getNumRows(); i++) {
	              for (int j = 0; j < getNumColumns(); j++) {
	                    click[i][j].setText("");
	                    click[i][j].setEnabled(true);
	                    click[i][j].setBackground(Color.WHITE);
	                    click[i][j].setOpaque(true);
	          	}
	    	}
		}
  
  private class ActList implements ActionListener {
        int row; 
        int col;
	        
      public ActList(int row, int col) {
          this.row = row;
          this.col = col;
      }
        
        @Override
      public void actionPerformed(ActionEvent e) {
              
        	if (isBombAtLocation(row, col)) {
                    int[][] arrCount = getCountGrid();

                    for (int i = 0; i < getNumRows(); i++) {
                          for (int j = 0; j < getNumColumns(); j++) {
                        	  
                                if (isBombAtLocation(i, j)) {
                                      click[i][j].setText("MINE!");
                                      click[i][j].setBackground(Color.RED);
                                      click[i][j].setOpaque(true);
                            	} 
                                
                                else {
                            	      click[i][j].setText(String.valueOf(arrCount[i][j]));
                            	}
                                click[i][j].setEnabled(false);
                      	  }
                	}
                    
                    int report = JOptionPane.showConfirmDialog(null,"Do You Wish to Play Again?", "You Lose!",JOptionPane.YES_NO_OPTION);
                   
                    if (report == JOptionPane.YES_OPTION) {
                      	gameReset();
                	} 
                    
                    else {
             
                      	System.exit(0);
                	}
          	} 
              
	        else {
	                click[row][col].setText(String.valueOf(getCountAtLocation(row, col)));               
	                click[row][col].setEnabled(false); 
	                safeZones--;
	                
	                if (safeZones == 0) {
	                      int report = JOptionPane.showConfirmDialog(null,"Winner Winner Chicken Dinner/n Play again?", "You Win",JOptionPane.YES_NO_OPTION);
	                      
	                      if (report == JOptionPane.YES_OPTION) {
	                        	gameReset();
	                  	  } 
	                      
	                      else {
	                        	System.exit(0);
	                  	  }
	               }
	        }	
      }
        
	}
	  public static void main(String args[]) {
		  Grid mine = new Grid();
	  }
}

    
    


	

