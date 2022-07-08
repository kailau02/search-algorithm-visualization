public interface Searchable {
    int[][] dirs = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
    void search() throws InterruptedException;
}
