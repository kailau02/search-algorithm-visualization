public abstract class Searchable {
    public static final int[][] dirs = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
    abstract void search() throws InterruptedException;
    protected static boolean isValid(int row, int col){
        return !(row < 0 || row >= GridSpace.ROWS || col < 0 || col >= GridSpace.COLUMNS || GridSpace.get(row, col) != GridSpace.Status.EMPTY);
    }
}
