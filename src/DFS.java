import java.util.Stack;

public class DFS extends Searchable{
    @Override
    public void search() throws InterruptedException {

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {0, 0});
        GridSpace.set(0,0, GridSpace.Status.ACTIVE);

        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(isValid(newRow, newCol)){
                    stack.push(new int[] {newRow, newCol});
                    GridSpace.set(newRow, newCol, GridSpace.Status.ACTIVE);
                }
            }
            GridSpace.set(row, col, GridSpace.Status.SEARCHED);
        }

        //dfs(0,0); // recursive
        Thread.sleep(1000);
    }

/*
    // Recursive solution

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

 */
}
