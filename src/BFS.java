import java.util.LinkedList;
import java.util.Queue;

public class BFS implements Searchable{
    @Override
    public void search() throws InterruptedException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        GridSpace.set(0,0, GridSpace.Status.ACTIVE);

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            GridSpace.set(row, col, GridSpace.Status.SEARCHED);

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(isValid(newRow, newCol)){
                    queue.add(new int[] {newRow, newCol});
                    GridSpace.set(newRow, newCol, GridSpace.Status.ACTIVE);
                }
            }
        }

        Thread.sleep(1000);
    }

    private static boolean isValid(int row, int col){
        return !(row < 0 || row >= GridSpace.ROWS || col < 0 || col >= GridSpace.COLUMNS || GridSpace.get(row, col) != GridSpace.Status.EMPTY);
    }
}
