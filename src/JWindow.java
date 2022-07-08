import javax.swing.*;
import java.awt.*;

public class JWindow extends JFrame {

    public static void main(String[] args) throws InterruptedException {
        new JWindow();
    }

    public static JPanel pane;

    public JWindow() throws InterruptedException {
        super("Algorithmic Searches");
        pane = new DrawPane();
        setContentPane(pane);
        pane.setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GridSpace.COLUMNS * GridSpace.CELL_SIZE + 10,
                GridSpace.ROWS * GridSpace.CELL_SIZE + 38);
        setVisible(true);

        GridSpace.initialize();
        GridSpace.generateNoise();

        pane.repaint();
        Thread.sleep(1000);

        Searchable dfs = new DFS();
        dfs.search();
        GridSpace.clearColors();
        Searchable bfs = new BFS();
        bfs.search();

    }

    private class DrawPane extends JPanel{

        @Override
        public void repaint() {
            super.repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintBackground(g);
            GridSpace.printGrid(g);
        }

        private void paintBackground(Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,
                    GridSpace.COLUMNS * GridSpace.CELL_SIZE + 1,
                    GridSpace.ROWS * GridSpace.CELL_SIZE + 1);
        }
    }
}