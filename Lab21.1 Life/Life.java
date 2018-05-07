import chn.util.*;
import apcslib.*;
public class Life
{   
    private FileInput infile;
    private int grid[][];
    private int tempGrid[][];    
    public Life(String name1){
        infile = new FileInput(name1);
        grid = new int[22][22];
        tempGrid = new int[22][22];
        while(infile.hasMoreTokens()){
            int row = infile.readInt();
            int col =  infile.readInt();
            grid[row][col] = 1;
        }
    }

    public void printGrid(){
        System.out.print("    ");
        for(int c = 1; c <= grid.length-2; c++){
            System.out.print(c % 10 + " ");
        }
        System.out.println();
        System.out.println();
        for(int r = 1; r <= grid.length-2; r++){            
            System.out.print(Format.left(r, 4));
            for(int c = 1; c <= grid[r].length - 2; c++){
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    public int alive(){
        int alive = 0;
        for(int r = 1; r <= grid.length-2; r++){            
            for(int c = 1; c <= grid[r].length - 2; c++){
                if(grid[r][c] == 1)
                    alive++;
            }
        }
        return alive;
    } 

    public int rowAlive(){
        int rowAlive = 0;
        for(int r = 1; r <= grid.length-2; r++){            
            if(grid[10][r] == 1)
                rowAlive++;
        }
        return rowAlive;
    }

    public int colAlive(){
        int colAlive = 0;
        for(int c = 1; c <= grid.length-2; c++){            
            if(grid[c][10] == 1)
                colAlive++;
        }
        return colAlive;
    }

    private int countNeighborsAlive(int r, int c){//counts neighbors around the position in the entered row,column
        int neighborsAlive = 0;
        if(grid[r-1][c-1]==1)
            neighborsAlive++;
        if(grid[r-1][c] == 1)
            neighborsAlive++;               
        if(grid[r-1][c+1] == 1)
            neighborsAlive++;                
        if(grid[r][c-1] == 1)
            neighborsAlive++;                
        if(grid[r][c+1] == 1)
            neighborsAlive++;                
        if(grid[r+1][c-1] == 1)
            neighborsAlive++;                
        if(grid[r+1][c] == 1)
            neighborsAlive++;               
        if(grid[r+1][c+1] == 1)
            neighborsAlive++;               
        return neighborsAlive;
    }

    private int checkAliveOrDead(int r, int c){//checks if the neighbors around are alive or dead
        if(countNeighborsAlive(r, c) == 3)
            return 1;
        else if(countNeighborsAlive(r, c) <= 1 || countNeighborsAlive(r, c) >= 4)
            return 0;
        else
            return grid[r][c];            

    }

    public void newGrid(){
        for(int r = 1; r <= grid.length-2; r++){
            for(int c = 1; c <= grid[r].length-2; c++){
                tempGrid[r][c] = checkAliveOrDead(r,c);//uses helper method to see if the position is alive or dead in the next gen. and sends it to tempGrid
            }
        }
        grid = tempGrid;
        tempGrid = new int[22][22];
    }
}