public class DFS implements Searchable{
    @Override
    public void search() throws InterruptedException {
        dfs(0,0);
        Thread.sleep(1000);
    }

    private static void dfs(int row, int col){
        if(row == -1 || col == -1) return;
        GridSpace.set(row, col, GridSpace.Status.ACTIVE);
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow < 0 || newRow >= GridSpace.ROWS ||
               newCol < 0 || newCol >= GridSpace.COLUMNS ||
               GridSpace.get(newRow, newCol) != GridSpace.Status.EMPTY) continue;
            dfs(newRow, newCol);
        }
        GridSpace.set(row, col, GridSpace.Status.SEARCHED);
    }
}
