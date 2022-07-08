import java.awt.*;
import java.util.Random;

public class GridSpace {
    public static final int COLUMNS = 100;
    public static final int ROWS = 80;
    public static final int CELL_SIZE = 8;

    private static Status[][] grid;

    public static void initialize(){
        grid = new Status[ROWS][COLUMNS];
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLUMNS; col++){
                grid[row][col] = Status.EMPTY;
            }
        }
    }

    public static void printGrid(Graphics g){
        if(grid == null) return;
        for(int row = 0; row < GridSpace.ROWS; row++){
            for(int col = 0; col < GridSpace.COLUMNS; col++){
                g.setColor(cellColor(grid[row][col]));
                g.fillRect(col * CELL_SIZE + 1, row * CELL_SIZE + 1,
                        CELL_SIZE - 1, CELL_SIZE - 1);
            }
        }
    }

    public static void generateNoise(){
        Random r = new Random();
        for(int row = 1; row < GridSpace.ROWS; row++){
            for(int col = 0; col < GridSpace.COLUMNS - 1; col++){
                if(r.nextDouble() > 0.65)
                    grid[row][col] = Status.BLOCKED;
            }
        }
    }

    public static void clearColors(){
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLUMNS; col++){
                if(grid[row][col] != Status.BLOCKED)
                    grid[row][col] = Status.EMPTY;
            }
        }
    }

    public static Status get(int row, int col){
        return grid[row][col];
    }

    public static void set(int row, int col, Status cellStatus){
        grid[row][col] = cellStatus;
        JWindow.pane.repaint();
    }

    private static final Color cellColor(Status cellStatus){
        switch (cellStatus){
            case EMPTY:
                return Color.white;
            case BLOCKED:
                return Color.black;
            case ACTIVE:
                return Color.green;
            case SEARCHED:
                return Color.yellow;
            case PATH:
                return Color.red;
            default:
                throw new IllegalArgumentException("cellStatus invalid.");
        }
    }

    public enum Status{
        EMPTY,
        BLOCKED,
        ACTIVE,
        SEARCHED,
        PATH
    }

}
