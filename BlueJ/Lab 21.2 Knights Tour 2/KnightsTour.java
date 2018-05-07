import chn.util.*;
import apcslib.*;
public class KnightsTour
{
    private static final int[] horizontal = {1,2,2,1,-1,-2,-2,-1};
    private static final int[] vertical = {-2,-1,1,2,2,1,-1,-2};
    private int row;
    private int col;
    private int ctr;
    private int[][] grid;

    public KnightsTour(){  
        grid = new int[8][8]; 
        grid[0][0] = 1;
        row = 0;
        col = 0;
        ctr = 1;
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid.length; j++){
                grid[i][j] = 0;
            }
        }
    }

    private boolean canMove(int row, int col){
        if(row < 8 && row >= 0 && col < 8 && col >=0){
            if(grid[row][col] == 0){
                return true;
            }
        }
        return false;
    }

    public void move(){
        int move = (int)(Math.random()*8);
        int nRow = row + horizontal[move];
        int nCol = col + vertical[move];
        while(!canMove(nRow, nCol)){
            move = (int)(Math.random()*8);
            nRow = row+horizontal[move];
            nCol = col+vertical[move];
        }
        row = nRow;
        col = nCol;
        ctr++;
        grid[row][col] = ctr;
    }

    public boolean noMoreMoves(){
        for(int i = 0; i < 8; i++){
            if(canMove(row+horizontal[i],col+vertical[i])){
                return false;
            }
        }
        return true;
    }

    public void print()
    {
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }	
        System.out.println(ctr + " squares were visited");
    }
}

